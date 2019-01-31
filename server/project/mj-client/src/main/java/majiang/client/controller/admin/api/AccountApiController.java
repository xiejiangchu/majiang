package majiang.client.controller.admin.api;

import majiang.client.controller.AdminAccount;
import majiang.client.controller.admin.form.LoginForm;
import majiang.client.controller.admin.model.LoginTokenModel;
import majiang.client.services.AdminAccountService;
import org.forkjoin.apikit.core.Account;
import org.forkjoin.apikit.core.Api;
import org.forkjoin.apikit.core.Result;
import org.forkjoin.apikit.spring.I18nValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author zuoge85 on 15/6/11.
 */
@Api
@RestController
@RequestMapping(value = "admin/v1")
public class AccountApiController {
    @Autowired
    private AdminAccountService adminAccountService;

    /**
     * 测试
     */
    @RequestMapping(value = "account/login", method = RequestMethod.GET)
    @Account(false)
    public Result<LoginTokenModel> login(@Valid LoginForm form, HttpServletRequest request) {
        AdminAccount adminAccount = adminAccountService.login(form.getName(), form.getPassword());
        if (adminAccount != null) {
            LoginTokenModel m = new LoginTokenModel();
            m.setName(adminAccount.getName());
            m.setToken(adminAccount.getToken());
            return Result.createSuccess(m);
        } else {
            throw I18nValidationException.of("nameOrPassword", "error");
        }
    }
}
