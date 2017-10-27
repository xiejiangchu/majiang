package game.boss.services;

import game.admin.SettingMsg;
import game.boss.dao.dao.SettingDao;
import game.boss.dao.entity.SettingDO;
import game.boss.net.BossService;
import mj.net.message.login.Radio;
import mj.net.message.login.SysSetting;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * 异步服务，请注意线程安全
 *
 * @author zuoge85 on 14-1-8.
 */
@Service
public final class SettingService {
    public static final int DEFAULT_ID = 1;

    @Autowired
    private SettingDao settingDao;

    @Autowired
    private BossService bossService;

    private SettingDO settingDO;


    @PostConstruct
    private void init(){
        SettingDO setting = settingDao.get(DEFAULT_ID);
        if (setting == null) {
            setting = new SettingDO();
            setting.setId(DEFAULT_ID);
        }
        this.settingDO = setting;
    }

    public SettingDO getSettingDO() {
        return settingDO;
    }

    public SysSetting getSettingMsg() {
        return settingMsg;
    }

    public void change(SettingMsg payMsg) {
        if(!StringUtils.equals(payMsg.getRadio(), settingDO.getRadio())){
            bossService.writeToAll(new Radio(payMsg.getRadio()));
        }
        BeanUtils.copyProperties(payMsg, settingDO);
    }


    private SysSetting settingMsg = new SysSetting(){
        @Override
        public String getRadio() {
            return settingDO.getRadio();
        }

        @Override
        public String getNotice() {
            return settingDO.getNotice();
        }

        @Override
        public String getPayInfo() {
            return settingDO.getPayInfo();
        }

        @Override
        public String getAgreement() {
            return settingDO.getAgreement();
        }
    };
}