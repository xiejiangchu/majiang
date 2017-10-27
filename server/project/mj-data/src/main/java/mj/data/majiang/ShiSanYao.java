package mj.data.majiang;

import mj.data.Pai;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xie on 17/10/20.
 */
public class ShiSanYao {

    private static TreeSet<Long> treeSet = new TreeSet();

    public static boolean check(List<Pai> paiList) {
        List<Integer> list = paiList.stream().map(item -> item.getIndex()).sorted().collect(Collectors.toList());
        long code = calcCode(list);
        return treeSet.contains(code);
    }

    static {
        Pai[][] w_array = {
                {Pai.WAN_1},
                {Pai.WAN_2},
                {Pai.WAN_3},
                {Pai.WAN_4},
                {Pai.WAN_5},
                {Pai.WAN_6},
                {Pai.WAN_7},
                {Pai.WAN_8},
                {Pai.WAN_9},
                {Pai.WAN_1, Pai.WAN_4},
                {Pai.WAN_1, Pai.WAN_5},
                {Pai.WAN_1, Pai.WAN_6},
                {Pai.WAN_1, Pai.WAN_7},
                {Pai.WAN_1, Pai.WAN_8},
                {Pai.WAN_1, Pai.WAN_9},
                {Pai.WAN_2, Pai.WAN_5},
                {Pai.WAN_2, Pai.WAN_6},
                {Pai.WAN_2, Pai.WAN_7},
                {Pai.WAN_2, Pai.WAN_8},
                {Pai.WAN_2, Pai.WAN_9},
                {Pai.WAN_3, Pai.WAN_6},
                {Pai.WAN_3, Pai.WAN_7},
                {Pai.WAN_3, Pai.WAN_8},
                {Pai.WAN_3, Pai.WAN_9},
                {Pai.WAN_4, Pai.WAN_7},
                {Pai.WAN_4, Pai.WAN_8},
                {Pai.WAN_4, Pai.WAN_9},
                {Pai.WAN_5, Pai.WAN_8},
                {Pai.WAN_5, Pai.WAN_9},
                {Pai.WAN_6, Pai.WAN_9},
                {Pai.WAN_1, Pai.WAN_4, Pai.WAN_7},
                {Pai.WAN_1, Pai.WAN_4, Pai.WAN_8},
                {Pai.WAN_1, Pai.WAN_4, Pai.WAN_9},
                {Pai.WAN_1, Pai.WAN_5, Pai.WAN_8},
                {Pai.WAN_1, Pai.WAN_5, Pai.WAN_9},
                {Pai.WAN_1, Pai.WAN_6, Pai.WAN_9},
                {Pai.WAN_2, Pai.WAN_5, Pai.WAN_8},
                {Pai.WAN_2, Pai.WAN_5, Pai.WAN_9},
                {Pai.WAN_2, Pai.WAN_6, Pai.WAN_9},
                {Pai.WAN_3, Pai.WAN_6, Pai.WAN_9}
        };

        Pai[][] b_array = {
                {Pai.TONG_1},
                {Pai.TONG_2},
                {Pai.TONG_3},
                {Pai.TONG_4},
                {Pai.TONG_5},
                {Pai.TONG_6},
                {Pai.TONG_7},
                {Pai.TONG_8},
                {Pai.TONG_9},
                {Pai.TONG_1, Pai.TONG_4},
                {Pai.TONG_1, Pai.TONG_5},
                {Pai.TONG_1, Pai.TONG_6},
                {Pai.TONG_1, Pai.TONG_7},
                {Pai.TONG_1, Pai.TONG_8},
                {Pai.TONG_1, Pai.TONG_9},
                {Pai.TONG_2, Pai.TONG_5},
                {Pai.TONG_2, Pai.TONG_6},
                {Pai.TONG_2, Pai.TONG_7},
                {Pai.TONG_2, Pai.TONG_8},
                {Pai.TONG_2, Pai.TONG_9},
                {Pai.TONG_3, Pai.TONG_6},
                {Pai.TONG_3, Pai.TONG_7},
                {Pai.TONG_3, Pai.TONG_8},
                {Pai.TONG_3, Pai.TONG_9},
                {Pai.TONG_4, Pai.TONG_7},
                {Pai.TONG_4, Pai.TONG_8},
                {Pai.TONG_4, Pai.TONG_9},
                {Pai.TONG_5, Pai.TONG_8},
                {Pai.TONG_5, Pai.TONG_9},
                {Pai.TONG_6, Pai.TONG_9},
                {Pai.TONG_1, Pai.TONG_4, Pai.TONG_7},
                {Pai.TONG_1, Pai.TONG_4, Pai.TONG_8},
                {Pai.TONG_1, Pai.TONG_4, Pai.TONG_9},
                {Pai.TONG_1, Pai.TONG_5, Pai.TONG_8},
                {Pai.TONG_1, Pai.TONG_5, Pai.TONG_9},
                {Pai.TONG_1, Pai.TONG_6, Pai.TONG_9},
                {Pai.TONG_2, Pai.TONG_5, Pai.TONG_8},
                {Pai.TONG_2, Pai.TONG_5, Pai.TONG_9},
                {Pai.TONG_2, Pai.TONG_6, Pai.TONG_9},
                {Pai.TONG_3, Pai.TONG_6, Pai.TONG_9}
        };

        Pai[][] t_array = {
                {Pai.TIAO_1},
                {Pai.TIAO_2},
                {Pai.TIAO_3},
                {Pai.TIAO_4},
                {Pai.TIAO_5},
                {Pai.TIAO_6},
                {Pai.TIAO_7},
                {Pai.TIAO_8},
                {Pai.TIAO_9},
                {Pai.TIAO_1, Pai.TIAO_4},
                {Pai.TIAO_1, Pai.TIAO_5},
                {Pai.TIAO_1, Pai.TIAO_6},
                {Pai.TIAO_1, Pai.TIAO_7},
                {Pai.TIAO_1, Pai.TIAO_8},
                {Pai.TIAO_1, Pai.TIAO_9},
                {Pai.TIAO_2, Pai.TIAO_5},
                {Pai.TIAO_2, Pai.TIAO_6},
                {Pai.TIAO_2, Pai.TIAO_7},
                {Pai.TIAO_2, Pai.TIAO_8},
                {Pai.TIAO_2, Pai.TIAO_9},
                {Pai.TIAO_3, Pai.TIAO_6},
                {Pai.TIAO_3, Pai.TIAO_7},
                {Pai.TIAO_3, Pai.TIAO_8},
                {Pai.TIAO_3, Pai.TIAO_9},
                {Pai.TIAO_4, Pai.TIAO_7},
                {Pai.TIAO_4, Pai.TIAO_8},
                {Pai.TIAO_4, Pai.TIAO_9},
                {Pai.TIAO_5, Pai.TIAO_8},
                {Pai.TIAO_5, Pai.TIAO_9},
                {Pai.TIAO_6, Pai.TIAO_9},
                {Pai.TIAO_1, Pai.TIAO_4, Pai.TIAO_7},
                {Pai.TIAO_1, Pai.TIAO_4, Pai.TIAO_8},
                {Pai.TIAO_1, Pai.TIAO_4, Pai.TIAO_9},
                {Pai.TIAO_1, Pai.TIAO_5, Pai.TIAO_8},
                {Pai.TIAO_1, Pai.TIAO_5, Pai.TIAO_9},
                {Pai.TIAO_1, Pai.TIAO_6, Pai.TIAO_9},
                {Pai.TIAO_2, Pai.TIAO_5, Pai.TIAO_8},
                {Pai.TIAO_2, Pai.TIAO_5, Pai.TIAO_9},
                {Pai.TIAO_2, Pai.TIAO_6, Pai.TIAO_9},
                {Pai.TIAO_3, Pai.TIAO_6, Pai.TIAO_9}
        };


        Pai[][] d_array = {
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_FA},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_FA},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_XI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},
                {Pai.FENG_DONG, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},

                {Pai.FENG_DONG, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},


                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_BEI},

                {Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},

                {Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},


                {Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},
                {Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},

                {Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},

                {Pai.FENG_NAN, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},


                {Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},
                {Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},

                {Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},


                {Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},

                {Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},

                /**
                 * 5 个
                */
                {Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA,},

                {Pai.FENG_DONG, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA,},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA,},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG},

                /**
                 * 6个
                */
                {Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_BEI},
                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA},

                {Pai.FENG_DONG, Pai.FENG_NAN, Pai.FENG_XI, Pai.FENG_BEI, Pai.SANYUAN_ZHONG, Pai.SANYUAN_FA, Pai.SANYUAN_BEI},
        };

        Map map = new HashMap<Long, String>();

        for (int w = 0; w < w_array.length; w++) {
            for (int t = 0; t < t_array.length; t++) {
                for (int b = 0; b < b_array.length; b++) {
                    for (int d = 0; d < d_array.length; d++) {

                        Pai[] w_item = w_array[w];
                        Pai[] t_item = t_array[t];
                        Pai[] b_item = b_array[b];
                        Pai[] d_item = d_array[d];
                        if (w_item.length + b_item.length + t_item.length + d_item.length == 14) {
                            Pai[] result = concatAll(w_item, b_item, t_item, d_item);
                            List<Integer> list = Arrays.stream(result).map(item -> item.getIndex()).collect(Collectors.toList());
//                            for (int i = 0; i < list.size(); i++) {
//                                System.out.print(GameHelper.getName(list.get(i)) + ",");
//                            }
                            long code = calcCode(list);
                            treeSet.add(code);
//                            System.out.print("0x" + Long.toHexString(code).toUpperCase());
//                            System.out.print(",");
//                            if (map.containsKey(code)) {
//                                System.out.println("存在");
//                            } else {
//                                map.put(code, "code_" + code);
//                            }
                        }

                    }
                }
            }

        }


//        for (int j = 0; j < 10000; j++) {
//            Integer[] random = randomCommon(Pai.TONG_1.getIndex(), Pai.SANYUAN_BEI.getIndex(), 14);
//            List<Integer> list = Arrays.asList(random);
//
//            long code = calcCode(list);
//
//            if (treeSet.contains(code)) {
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.print(Pai.fromIndex(list.get(i)).getName());
//                }
//                System.out.println("糊了");
//            }
//        }
    }

    private static <T> T[] concatAll(T[] first, T[]... rest) {
        int totalLength = first.length;
        for (T[] array : rest) {
            totalLength += array.length;
        }
        T[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (T[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        Arrays.sort(result);
        return result;
    }
//
//    public static Integer[] randomCommon(int min, int max, int n) {
//        if (n > (max - min + 1) || max < min) {
//            return null;
//        }
//        Integer[] result = new Integer[n];
//        Arrays.fill(result, 0);
//        int count = 0;
//        while (count < n) {
//            int num = (int) (Math.random() * (max - min)) + min;
//            boolean flag = true;
//            for (int j = 0; j < n; j++) {
//                if (num == result[j]) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                result[count] = num;
//                count++;
//            }
//        }
//        Arrays.sort(result);
//        return result;
//    }

    private static long calcCode(List<Integer> pai) {
        StringBuilder builder = new StringBuilder();
        builder.append(pai.get(0) + 1);
        for (int i = 1; i < pai.size(); i++) {
            Pai current = Pai.fromIndex(pai.get(i));
            Pai pre = Pai.fromIndex(pai.get(i - 1));
            if (current.getType().equals(pre.getType())) {
                builder.append(current.getSecondIndex());
            } else {
                builder.append("0");
                builder.append(current.getSecondIndex());
            }
        }
        return Long.parseLong(builder.toString());
    }
}
