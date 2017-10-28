package mj.data;

import mj.data.majiang.ShiSanYao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 算翻结果
 *
 * @author zuoge85@gmail.com on 2016/11/5.
 */
public class FanResult {
    //雀頭
    private Pai queTou;
    //顺子
    private Pai[] shunZi;
    //刻子
    private Pai[] keZi;

    private BaseFanType baseFanType;
    private ArrayList<JiaFanType> jiaFans = new ArrayList<>();

    private int fan;

    private String fanString;

    private int[] huiErBian;

    public FanResult() {

    }

    public int getFan() {
        return fan;
    }

    public void setFan(int fan) {
        this.fan = fan;
    }

    public void setFanString(String fanString) {
        this.fanString = fanString;
    }


    public String getFanString() {
        return fanString;
    }

    public boolean isDanDiao(Pai pai) {
        if (pai.equals(queTou)) {
            return true;
        }
        for (Pai p : keZi) {
            if (p.equals(pai)) {
                return true;
            }
        }
        for (Pai p : shunZi) {
            if (pai.equals(p.nextPaiType())) {
                return true;
            }
        }
        return false;
    }

    public boolean isDuiDuiHu(UserPaiInfo userPaiInfo) {
        return !hasSunZi() && !userPaiInfo.hasChi();
    }

    public boolean isQingXing(UserPaiInfo userPaiInfo) {
        if (isShiSanYao(userPaiInfo)) {
            ArrayList<Pai> shouPaiList = userPaiInfo.getShouPai();
            Map<Integer, Pai> shouPaiMap = shouPaiList.stream().collect(
                    Collectors.toMap(Pai::getIndex, v -> v)
            );
            return (shouPaiMap.containsKey(Pai.FENG_DONG.getIndex())
                    && shouPaiMap.containsKey(Pai.FENG_XI.getIndex())
                    && shouPaiMap.containsKey(Pai.FENG_NAN.getIndex())
                    && shouPaiMap.containsKey(Pai.FENG_BEI.getIndex())
                    && shouPaiMap.containsKey(Pai.SANYUAN_ZHONG.getIndex())
                    && shouPaiMap.containsKey(Pai.SANYUAN_FA.getIndex())
                    && shouPaiMap.containsKey(Pai.SANYUAN_BEI.getIndex()));
        }
        return false;
    }

    public boolean isShiSanYao(UserPaiInfo userPaiInfo) {
        return ShiSanYao.check(userPaiInfo.getShouPai());
    }

    private boolean hasSunZi() {
        if (this.shunZi == null) {
            return false;
        }
        return this.shunZi.length > 0;
    }

    public Pai getQueTou() {
        return queTou;
    }

    public void setQueTou(Pai queTou) {
        this.queTou = queTou;
    }

    public Pai[] getShunZi() {
        return shunZi;
    }

    public void setShunZi(Pai[] shunZi) {
        this.shunZi = shunZi;
    }

    public Pai[] getKeZi() {
        return keZi;
    }

    public void setKeZi(Pai[] keZi) {
        this.keZi = keZi;
    }

    public BaseFanType getBaseFanType() {
        return baseFanType;
    }

    public void setBaseFanType(BaseFanType baseFanType) {
        this.baseFanType = baseFanType;
    }

    public ArrayList<JiaFanType> getJiaFans() {
        return jiaFans;
    }


    public int[] getHuiErBian() {
        return huiErBian;
    }

    public void setHuiErBian(int[] huiErBian) {
        this.huiErBian = huiErBian;
    }


    @Override
    public String toString() {
        return "FanResult{" +
                "queTou=" + queTou +
                ", shunZi=" + Arrays.toString(shunZi) +
                ", keZi=" + Arrays.toString(keZi) +
                ", baseFanType=" + baseFanType +
                ", jiaFans=" + jiaFans +
                ", fan=" + fan +
                ", fanString='" + fanString + '\'' +
                ", huiErBian=" + Arrays.toString(huiErBian) +
                '}';
    }
}
