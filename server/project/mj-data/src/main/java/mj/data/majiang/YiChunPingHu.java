package mj.data.majiang;

import mj.data.Pai;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by xie on 17/10/24.
 */
public class YiChunPingHu {

    private static int[][] TRIM_FENG = new int[][]{
            {4, 4, 4, 3},
            {4, 4, 4, 0},
            {4, 4, 3, 1},
            {4, 4, 2, 2},
            {4, 4, 1, 0},
            {4, 3, 3, 2},
            {4, 3, 1, 1},
            {4, 2, 2, 1},
            {4, 1, 1, 0},
            {3, 3, 3, 3},
            {3, 3, 3, 0},
            {3, 3, 2, 1},
            {3, 3, 0, 0},
            {3, 2, 2, 2},
            {3, 1, 1, 1},
            {3, 0, 0, 0},
            {2, 2, 2, 0},
            {2, 2, 1, 1},
            {1, 1, 1, 0}
    };

    private static int[][] TRIM_SANGYUAN = new int[][]{
            {4, 4, 4},
            {4, 4, 1},
            {4, 1, 1},
            {3, 3, 3},
            {3, 3, 0},
            {3, 0, 0},
            {2, 2, 2},
            {1, 1, 1}
    };

    public static void main(String args[]) {
        Pai[] in = {Pai.FENG_DONG, Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI};

        for (int i = 0; i < in.length; i++) {
            System.out.print(in[i].getName());
        }
        System.out.println();

        if (check(in)) {
            System.out.println("true");
        }
    }

    public static boolean check(Pai[] pais) {
        Arrays.sort(pais, new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        List<Pai> out = trim(pais);
        return AgariUtils.isHuiErHuPai(null, out, null);
    }

    public static boolean check(Collection<Pai> shouPai) {
        List<Pai> list = shouPai.stream().collect(Collectors.toList());
        Pai[] pais = list.toArray(new Pai[list.size()]);
        Arrays.sort(pais, new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        List<Pai> out = trim(pais);
        return AgariUtils.isHuiErHuPai(null, out, null);
    }

    public static boolean check(Collection<Pai> shouPai, Pai other) {
        List<Pai> list = shouPai.stream().collect(Collectors.toList());
        list.add(other);
        Pai[] pais = list.toArray(new Pai[list.size()]);
        Arrays.sort(pais, new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        List<Pai> out = trim(pais);
        return AgariUtils.isHuiErHuPai(null, out, null);
    }

    public static boolean checkInteger(Collection<Integer> shouPai) {
        Pai[] pais = (Pai[]) shouPai.stream().map(new Function<Integer, Pai>() {
            @Override
            public Pai apply(Integer integer) {
                return Pai.fromIndex(integer);
            }
        }).collect(Collectors.toList()).toArray();
        Arrays.sort(pais, new Comparator<Pai>() {
            @Override
            public int compare(Pai o1, Pai o2) {
                return o1.getIndex() - o2.getIndex();
            }
        });
        List<Pai> out = trim(pais);
        return AgariUtils.isHuiErHuPai(null, out, null);
    }

    private static List<Pai> trim(Pai[] pais) {
        List<Pai> in = Arrays.asList(pais);
        return trim(in);
    }

    private static List<Pai> trim(List<Pai> in) {
        if (in == null || in.size() == 0) {
            return null;
        }
        int FENG_DONG_COUNT = 0;
        int FENG_NAN_COUNT = 0;
        int FENG_XI_COUNT = 0;
        int FENG_BEI_COUNT = 0;
        int SANYUAN_ZHONG_COUNT = 0;
        int SANYUAN_FA_COUNT = 0;
        int SANYUAN_BEI_COUNT = 0;
        for (int i = 0; i < in.size(); i++) {
            Pai item = in.get(i);
            if (item.getIndex() == Pai.FENG_DONG.getIndex()) {
                FENG_DONG_COUNT++;
            } else if (item.getIndex() == Pai.FENG_NAN.getIndex()) {
                FENG_NAN_COUNT++;
            } else if (item.getIndex() == Pai.FENG_XI.getIndex()) {
                FENG_XI_COUNT++;
            } else if (item.getIndex() == Pai.FENG_BEI.getIndex()) {
                FENG_BEI_COUNT++;
            } else if (item.getIndex() == Pai.SANYUAN_ZHONG.getIndex()) {
                SANYUAN_ZHONG_COUNT++;
            } else if (item.getIndex() == Pai.SANYUAN_FA.getIndex()) {
                SANYUAN_FA_COUNT++;
            } else if (item.getIndex() == Pai.SANYUAN_BEI.getIndex()) {
                SANYUAN_BEI_COUNT++;
            }
        }

        List<SortedPai> sortedList_FENG = new ArrayList<>();
        sortedList_FENG.add(new SortedPai(Pai.FENG_DONG, FENG_DONG_COUNT));
        sortedList_FENG.add(new SortedPai(Pai.FENG_NAN, FENG_NAN_COUNT));
        sortedList_FENG.add(new SortedPai(Pai.FENG_XI, FENG_XI_COUNT));
        sortedList_FENG.add(new SortedPai(Pai.FENG_BEI, FENG_BEI_COUNT));

        Collections.sort(sortedList_FENG);
        int[] selected_FENG = new int[4];

        for (int i = 0; i < TRIM_FENG.length; i++) {
            if (sortedList_FENG.get(0).getCount() == 2
                    && sortedList_FENG.get(1).getCount() == 1
                    && sortedList_FENG.get(2).getCount() == 1
                    && sortedList_FENG.get(3).getCount() == 1) {
                selected_FENG = new int[]{0, 1, 1, 1};
            } else if (sortedList_FENG.get(0).getCount() >= TRIM_FENG[i][0]) {
                if (sortedList_FENG.get(1).getCount() >= TRIM_FENG[i][1]) {
                    if (sortedList_FENG.get(2).getCount() >= TRIM_FENG[i][2]) {
                        if (sortedList_FENG.get(3).getCount() >= TRIM_FENG[i][3]) {
                            selected_FENG = Arrays.copyOf(TRIM_FENG[i], TRIM_FENG[i].length);
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < sortedList_FENG.size(); i++) {
            sortedList_FENG.get(i).setCount(sortedList_FENG.get(i).getCount() - selected_FENG[i]);
        }


        List<SortedPai> sortedList_SANGYUAN = new ArrayList<>();
        sortedList_SANGYUAN.add(new SortedPai(Pai.SANYUAN_ZHONG, SANYUAN_ZHONG_COUNT));
        sortedList_SANGYUAN.add(new SortedPai(Pai.SANYUAN_FA, SANYUAN_FA_COUNT));
        sortedList_SANGYUAN.add(new SortedPai(Pai.SANYUAN_BEI, SANYUAN_BEI_COUNT));

        Collections.sort(sortedList_SANGYUAN);

        int[] selected_SANGYUAN = new int[3];
        for (int i = 0; i < TRIM_SANGYUAN.length; i++) {
            if (sortedList_SANGYUAN.get(0).getCount() >= TRIM_SANGYUAN[i][0]) {
                if (sortedList_SANGYUAN.get(1).getCount() >= TRIM_SANGYUAN[i][1]) {
                    if (sortedList_SANGYUAN.get(2).getCount() >= TRIM_SANGYUAN[i][2]) {
                        selected_SANGYUAN = Arrays.copyOf(TRIM_SANGYUAN[i], TRIM_SANGYUAN[i].length);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < sortedList_SANGYUAN.size(); i++) {
            sortedList_SANGYUAN.get(i).setCount(sortedList_SANGYUAN.get(i).getCount() - selected_SANGYUAN[i]);
        }

        List<Pai> out = in.stream().filter(item -> item.getIndex() >= Pai.TONG_1.getIndex() && item.getIndex() <= Pai.WAN_9.getIndex()).collect(Collectors.toList());

        for (int i = 0; i < sortedList_FENG.size(); i++) {
            for (int j = 0; j < sortedList_FENG.get(i).getCount(); j++) {
                out.add(sortedList_FENG.get(i).getPai());
            }
        }

        for (int i = 0; i < sortedList_SANGYUAN.size(); i++) {
            for (int j = 0; j < sortedList_SANGYUAN.get(i).getCount(); j++) {
                out.add(sortedList_SANGYUAN.get(i).getPai());
            }
        }
        return out;
    }


    private static class SortedPai implements Comparable<SortedPai> {
        private Pai pai;
        private int count;

        SortedPai(Pai pai, int count) {
            this.pai = pai;
            this.count = count;
        }

        public Pai getPai() {
            return pai;
        }

        public void setPai(Pai pai) {
            this.pai = pai;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(SortedPai o) {
            return o.getCount() - count;
        }
    }
}
