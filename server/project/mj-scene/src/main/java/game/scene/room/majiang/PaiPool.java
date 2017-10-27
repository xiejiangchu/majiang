package game.scene.room.majiang;

import game.scene.room.majiang.rules.Rules;
import mj.data.Pai;
import mj.data.UserPlace;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;

/**
 * 发牌的池子
 *
 * @author zuoge85@gmail.com on 2016/11/4.
 */
public class PaiPool {

    /**
     * 桌面剩余牌的信息
     */
    private final ArrayList<Pai> pais = new ArrayList<>();

    private Rules rules;

    private int[][] faPaiss;

    PaiPool(Rules rules) {
        this.rules = rules;
    }


    public void start() {
        //发牌
        pais.addAll(rules.getAllPai());
        pais.addAll(rules.getAllPai());
        pais.addAll(rules.getAllPai());
        pais.addAll(rules.getAllPai());
        //乱序
        for (int i = 0; i < pais.size(); i++) {
            int randomIndex = RandomUtils.nextInt(pais.size());

            Pai temp = pais.get(i);
            pais.set(i, pais.get(randomIndex));
            pais.set(randomIndex, temp);
        }
    }

    public void clear() {
        pais.clear();
    }

    public Pai get(int index) {
        return pais.get(index);
    }

    public int size() {
        return pais.size();
    }

    public Pai getFreePai() {
        int index = pais.size() - 1;
        return index > -1 ? pais.remove(index) : null;
    }

    public Pai getFreeGangPai() {
        for (int i = 0; i < pais.size(); i++) {
            Pai pai = pais.get(i);
            if (pai != null) {
                pais.set(i, null);
                return pai;
            }
        }
        return null;
    }

    public void faPai(int index, UserPlace userPlace) {
        if (faPaiss != null) {
            int[] faPais = faPaiss[index];
            for (int i = 0; i < 13; i++) {
                Pai pai = Pai.fromIndex(faPais[i]);
                if (!pais.remove(pai)) {
                    throw new RuntimeException("错误的牌" + pai + ",index:" + index + ",i:" + i);
                }
                userPlace.addShouPai(pai);
            }
        } else {
            for (int j = 0; j < 13; j++) {
                userPlace.addShouPai(getFreePai());
            }
        }

    }

    public ArrayList<Pai> getLeftPai() {
        return pais;
    }

    public Pai[] getHuiEr() {
        //计算会儿
        return rules.getHuiEr(this);
    }
}
