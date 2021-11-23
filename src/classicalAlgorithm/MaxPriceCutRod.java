package classicalAlgorithm;

import java.util.ArrayList;
import java.util.List;

//动态规划---钢条最佳切割长度
public class MaxPriceCutRod {

    /**
     * 【递归解决】自顶向下求解最有切割长度
     * @param prices 价格数组
     * @param n  钢条长度
     * @return
     */
    private static int topDownCutRod(List<Integer> prices, int n){
        int temp = 0;
        int r = 0;  //最优子结构

        //递归出口
        if (n == 0){
            return 0;
        }

        for (int i = 1; i <= n; i++) {
            temp = prices.get(i) + topDownCutRod(prices, n-i);
            //最优子结构
            if (temp >= r){
                r = temp;
                System.out.println(n + "最优子结构---" + temp);
            }
        }

        return r;
    }

    /**
     * 【非递归解决】自底向上求解最有切割长度
     * @param prices 价格数组
     * @param n  钢条长度
     * @return
     */
    private static int downTopCutRod(List<Integer> prices, int n){
        int temp = 0;
        List<Integer> r = new ArrayList<>(); //最优子结构记录
        r.add(0,0);

        //最优子结构
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                temp = prices.get(j)+r.get(i-j) >= temp ? prices.get(j)+r.get(i-j):temp;
            }
            r.add(i,temp);
            System.out.println(i+"---最优子结构---"+r.get(i));
        }

        return r.get(n);
    }
    public static void main(String[] args) {

        //index代表钢材长度，index位置的值代表价格。
        List<Integer> prices = new ArrayList<>();
        prices.add(0,0);
        prices.add(1,1);
        prices.add(2,3);
        prices.add(3,5);
        prices.add(4,4);
        prices.add(5,8);

        int bestCutPrice = topDownCutRod(prices, 5);
        int bestCutPrice2 = downTopCutRod(prices, 5);
        System.out.println(bestCutPrice);
        System.out.println(bestCutPrice2);

        String value = System.getProperty("user.name");
        System.out.println(value);

    }
}
