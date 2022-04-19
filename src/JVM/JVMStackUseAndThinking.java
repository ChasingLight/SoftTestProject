package JVM;

import java.util.Arrays;

public class JVMStackUseAndThinking {


    public static void main(String[] args) throws Exception {
        int a = 10;
        int[] arr = {1,2,3};

        updateBasicAndReferenceDataInMethod(a, arr);

        System.out.println(a);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 验证
     * 1.Java方法参数传递，是值传递。
     * 1.方法中基础数据类型，修改会丢失（值传递-基本数据的值）；
     * 2.方法中引用数据类型，修改会保持（值传递-对象的引用，真正修改的是堆中的对象本身）；
     * 3.数组本质上也是 引用数据类型。
     */
    private static void updateBasicAndReferenceDataInMethod(int a, int[] arr){
        a = a++;
        arr[0] = 666;
    }

}
