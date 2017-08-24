package game.scene.room.majiang.rules;

import game.scene.room.majiang.PaiPool;
import mj.data.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xie on 17/8/23.
 */
public class HongzhongHnRules extends Rules {

    private static final ArrayList<Pai> ALL_PAI_LIST = createTBWAllList();

    public static final Map<JiaFanType, FanInfo> jiaFanMap = initJiaFanMap();
    public static final Map<BaseFanType, FanInfo> baseFanMap = initBaseFanMap();

    private Pai[] huiErs;

    private static Map<JiaFanType, FanInfo> initJiaFanMap() {
        Map<JiaFanType, FanInfo> map = new HashMap<>();
        map.put(JiaFanType.WU_HUN_ER, new FanInfo("无鬼", 2));
        return map;
    }

    private static Map<BaseFanType, FanInfo> initBaseFanMap() {
        Map<BaseFanType, FanInfo> map = new HashMap<>(BaseFanType.baseFanMap);
        map.replace(BaseFanType.ZI_MO, new FanInfo("自摸", 1));
        return map;
    }


    public HongzhongHnRules(Config config) {
        super(config);
    }

    @Override
    public boolean rest() {
        huiErs = new Pai[]{Pai.SANYUAN_ZHONG};
        return false;
    }

    @Override
    public ArrayList<Pai> getAllPai() {
        return ALL_PAI_LIST;
    }

    @Override
    public Pai[] getHuiEr(PaiPool paiPool) {
        return huiErs;
    }

    @Override
    public boolean isChi() {
        return false;
    }

    @Override
    public boolean isFangPao() {
        return false;
    }

    @Override
    public boolean isZaMa() {
        int maiMa = config.getInt(Config.MAI_MA);
        return maiMa != 0;
    }

    @Override
    public int getZaMa() {
        return config.getInt(Config.MAI_MA);
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

    private static ArrayList<Pai> createTBWAllList() {
        ArrayList<Pai> list = new ArrayList<>();
        for (int paiIndex = Pai.TONG_1.getIndex(); paiIndex <= Pai.WAN_9.getIndex(); paiIndex++) {
            Pai pai = Pai.fromIndex(paiIndex);
            list.add(pai);
        }
        list.add(Pai.SANYUAN_ZHONG);
        return list;
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
