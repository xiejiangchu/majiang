package game.scene.room.majiang.rules;

import game.scene.SceneMain;
import game.scene.room.majiang.PaiPool;
import mj.data.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author zuoge85@gmail.com on 2017/1/17.
 */
public abstract class Rules {

    private static final Logger log = LoggerFactory.getLogger(SceneMain.class);
    protected Config config;
    private int baoliuLength = 12;
    private int shouTimeMillisecond = 15000;


    public static Rules createRules(String name, Config config) {
        String binType = config.getString(Config.BIAN_TYPE);
        log.info("麻将类型" + binType);
        if (binType.equalsIgnoreCase(Config.BIAN_TYPE_HONG_ZHONG)) {
            return new HongzhongHnRules(config);
        } else {
            switch (name) {
                case "zhongyouGD":
                    return new ZhongyouGdRules(config);
                default:
                    return new ZhongyouGdRules(config);
            }
        }
    }

    public abstract boolean rest();

    public Rules(Config config) {
        this.config = config;
    }

    public int getBaoliuLength() {
        return baoliuLength;
    }

    public int getShouTimeMillisecond() {
        return shouTimeMillisecond;
    }

    public void setShouTimeMillisecond(int shouTimeMillisecond) {
        this.shouTimeMillisecond = shouTimeMillisecond;
    }

    public abstract ArrayList<Pai> getAllPai();

    public abstract Pai[] getHuiEr(PaiPool paiPool);

    public abstract boolean isChi();

    public abstract boolean isFangPao();

    public abstract boolean isZaMa();

    public abstract int getZaMa();

    public abstract Map<JiaFanType, FanInfo> getJiaFanMap();

    public abstract Map<BaseFanType, FanInfo> getBaseFanMap();

    public abstract boolean isHuiGang();
}
