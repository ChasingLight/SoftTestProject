package writeExamForItcast.writeExamFor88.randomWeightLuckDraw;

import java.text.DecimalFormat;

//原题题干：下标是用户的id，对应的值是用户的积分。积分越多，中奖几率越高，设计一个抽奖算法。
public class ScoreLuckDraw {

    public static void main(String[] args) {
        // 下标是用户的id，对应的值是用户的积分
        int[] users = {1,2,3,4};

        System.out.println("抽奖一次，中奖用户为：" + getPrizeIndex(users));
    }

    /**
     * 抽奖一次，获取中奖用户下标即id
     * @param users
     * @return
     */
    public static int getPrizeIndex(int[] users) {
        DecimalFormat df = new DecimalFormat("######0.00");
        int random = -1;
        try{
            //计算总权重
            double sumWeight = 0;
            for(int weight : users){
                sumWeight += weight;
            }

            //产生随机数
            double randomNumber;
            randomNumber = Math.random();
            System.out.println("随机数为---" + randomNumber);

            //根据随机数在所有奖品分布的区域并确定所抽奖品
            double d1 = 0;
            double d2 = 0;
            for(int i=0; i < users.length; i++){
                d2 += users[i] / sumWeight;
                if(i==0){
                    d1 = 0;
                }else{
                    d1 += users[i-1] / sumWeight;;
                }
                if(randomNumber >= d1 && randomNumber <= d2){
                    random = i;
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("生成抽奖随机数出错，出错原因：" +e.getMessage());
        }
        return random;
    }
}
