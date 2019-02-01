package game.gateway.server;

import com.isnowfox.core.net.Session;
import com.isnowfox.game.proxy.PxMsgHandler;
import com.isnowfox.game.proxy.message.PxMsg;
import game.gateway.GatewayService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class BossClientHandler implements PxMsgHandler<Object> {
    private final static Logger log = LoggerFactory.getLogger(GameServerHandler.class);

    private GatewayService gatewayService;

    @Override
    public void onConnect(Session<Object> session) throws Exception {
        log.info("连接boss服务器成功！");
        gatewayService.onBossConnect();
    }

    @Override
    public void onDisconnect(Session<Object> session) throws Exception {
        log.info("boss连接断开!！");
        gatewayService.onBossDisconnect();
    }

    @Override
    public void onException(Session<Object> session, Throwable cause) {
        log.info("错误!{}", session, cause);
    }

    @Override
    public Session<Object> createSession(ChannelHandlerContext ctx) {
        return new Session<>(ctx.channel());
    }

    @Override
    public boolean onIn(Session<Object> session, ByteBuf in) {
        return true;
    }

    @Override
    public void onMessage(PxMsg msg) throws Exception {
        gatewayService.handleMessage(msg);
    }

    public void setGatewayService(GatewayService gatewayService) {
        this.gatewayService = gatewayService;
    }
}
