package classicalAlgorithm.sortAlgorithm;


import java.util.Arrays;

//排序算法基础：冒泡排序
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {5,8,6,3,9,2,1,7};
        //bubbleSortVersion1(arr);
        bubbleSortVersion2(arr);
        System.out.println(Arrays.toString(arr));
    }


    //初始版本
    private static void bubbleSortVersion1(int[] arr){
        int temp = 0;
        int i;
        for (i = 1; i <= arr.length-1; i++) {  //几轮(就用<=表示更加符合算法思想，省却额外转换思考)
            for (int j = 0; j <= arr.length-i-1; j++){  //第一次找好规律，和i初始值配合
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        System.out.println("元素全部排序，冒泡排序所走轮数：" + (i-1));
    }


    //优化版本
    private static void bubbleSortVersion2(int[] arr){
        int temp = 0;
        boolean is_sorted;

        int i;
        for (i = 1; i <= arr.length-1; i++) {  //几轮排序 (就用<=表示更加符合算法思想，省却额外转换思考)

            //默认当前轮排序，元素已是有序的
            is_sorted = true;

            for (int j = 0; j <= arr.length-i-1; j++){  //第一次找好规律，和i初始值配合
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    is_sorted = false;
                }
            }

            if (is_sorted){
                break;
            }
        }

        System.out.println("优化版本---元素全部排序，冒泡排序所走轮数：" + (i-1));
    }
}
