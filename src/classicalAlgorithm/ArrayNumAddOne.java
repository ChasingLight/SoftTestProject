package classicalAlgorithm;

/**
 * 2.给定一个用数组表示的整数，将其加1后，返回新的结果，同样以数组的形式
 * 示例：
 * 输入[2,3,4] 输出[2,3,5]
 * 输入[9,9] 输出[1,0,0]
 * 不允许使用Java的API
 */
public class ArrayNumAddOne {

    public static void main(String[] args) {
        int[] nums = {9,9,9};

        int number = 0;
        //将数组转换为10进制数
        int j = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            number += nums[i] * getTenPow(j);
            j--;
        }

        //2.加1
        number += 1;
        System.out.println(number);

        //判断是否加1之后进位了
        int times = (number == getTenPow(nums.length)) ? nums.length+1 : nums.length;
        int[] plusOneNums = new int[times];

        //3.求出各个位
        for (int i = times-1; i >= 0; i--) {
            plusOneNums[i] = number % 10;
            number = number / 10;
        }
    }

    private static int getTenPow(int pow){
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= 10;
        }
        return result;
    }

}
