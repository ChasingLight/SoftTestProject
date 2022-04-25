package classicalAlgorithm;

import java.util.List;
import java.util.Random;

/**
 * 红包算法需求
 * 1.所有人抢到金额之和，等于 红包金额。不多也不少
 * 2.每个人至少分到1分钱；
 * 3.红包拆分金额尽可能【分布均衡】，不要出现【两级分化】太严重的情况。
 */
public class RedPacketAlgorithm {

    public static void main(String[] args) {
        List<Long> result = redPacketMethod(100L, 10);
        System.out.println(result);

        Random random = new Random(20);
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextDouble());
        }


        System.out.println("------------");
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextLong());
        }


    }

    /**
     * 红包具体分配方法
     * @param money  红包总金额
     * @param peopleNumber  红包个数
     * @return  对应个数的list
     */
    private static List<Long> redPacketMethod(Long money, Integer peopleNumber){
        Random random = new Random();




        return null;
    }
}
