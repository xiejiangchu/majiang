package game.scene.room.majiang.rules;

import game.scene.room.majiang.PaiPool;
import mj.data.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xie on 17/8/23.
 */
public class YiChunRules extends Rules {

    private static final Map<JiaFanType, FanInfo> jiaFanMap = initJiaFanMap();
    private static final Map<BaseFanType, FanInfo> baseFanMap = initBaseFanMap();

    private static Map<JiaFanType, FanInfo> initJiaFanMap() {
        Map<JiaFanType, FanInfo> map = new HashMap<>();
        map.put(JiaFanType.WU_HUN_ER, new FanInfo("无鬼", 1));
        return map;
    }

    private static Map<BaseFanType, FanInfo> initBaseFanMap() {
        Map<BaseFanType, FanInfo> map = new HashMap<>(BaseFanType.baseFanMap);
        map.replace(BaseFanType.HUI_ER_GANG, new FanInfo("自摸", 1));
        map.replace(BaseFanType.ZI_MO, new FanInfo("自摸", 1));
        map.replace(BaseFanType.JI_HU, new FanInfo("", 1));
        map.replace(BaseFanType.DUI_DUI_HU, new FanInfo("对对胡", 3));
        map.replace(BaseFanType.QI_DUI, new FanInfo("七对子", 4));
        map.replace(BaseFanType.TIAN_HU, new FanInfo("天胡", 8));
        map.replace(BaseFanType.DI_HU, new FanInfo("地胡", 4));
        return map;
    }


    YiChunRules(Config config) {
        super(config);
    }

    @Override
    public boolean rest() {
        return false;
    }

    @Override
    public ArrayList<Pai> getAllPai() {
        ArrayList<Pai> list = new ArrayList<>();
        for (int paiIndex = Pai.TONG_1.getIndex(); paiIndex <= Pai.SANYUAN_BEI.getIndex(); paiIndex++) {
            Pai pai = Pai.fromIndex(paiIndex);
            list.add(pai);
        }
        return list;
    }

    @Override
    public Pai[] getHuiEr(PaiPool paiPool) {
        return null;
    }

    @Override
    public boolean isChi() {
        return true;
    }

    @Override
    public boolean isFangPao() {
        return true;
    }

    @Override
    public boolean isZaMa() {
        return false;
    }

    @Override
    public int getZaMa() {
        return 0;
    }

    @Override
    public Map<JiaFanType, FanInfo> getJiaFanMap() {
        return jiaFanMap;
    }

    @Override
    public Map<BaseFanType, FanInfo> getBaseFanMap() {
        return baseFanMap;
    }

    @Override
    public boolean isHuiGang() {
        return true;
    }


    public int getBaoliuLength() {
        int maiMa = config.getInt(Config.MAI_MA);
        int length = 0;
        if (maiMa == -1) {
            length = 1;
        } else {
            length = maiMa;
        }
        return length;
    }
}
