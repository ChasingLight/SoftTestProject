package classicalAlgorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

//动态规划---最佳背包问题
public class MaxValueBag extends Thread{

    private int initBagArray(){

        return 1;
    }


    public static void main(String[] args) throws ParseException {
        List<Integer> weight = new ArrayList<>();
        List<Integer> value = new ArrayList<>();

        weight.add(0,0);
        weight.add(1,1);
        weight.add(2,2);
        weight.add(3,5);
        weight.add(4,6);
        weight.add(5,7);

        value.add(0,0);
        value.add(1,1);
        value.add(2,6);
        value.add(3,18);
        value.add(4,22);
        value.add(5,28);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date firstMeetDate = sdf.parse("2021-06-19");

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstMeetDate);
        calendar.add(Calendar.DATE, 100);
        System.out.println(sdf.format(calendar.getTime()));

    }
}
