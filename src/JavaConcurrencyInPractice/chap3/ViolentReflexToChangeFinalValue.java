package JavaConcurrencyInPractice.chap3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 验证：使用暴力反射能否，修改私有的、final常量已有的值
 * 答案：可以暴力修改。
 */
public class ViolentReflexToChangeFinalValue {

    public static void main(String[] args) throws Exception {
        //获取类对象
        Class cls = Class.forName("JavaConcurrencyInPractice.chap3.Student");
        //通过无参构造创建对象
        Student student = (Student) cls.newInstance();
        //获取属性
        Field age = cls.getDeclaredField("age");
        //关闭age的属性检测
        age.setAccessible(true);
        //读取对象的属性值
        int ages = (int) age.get(student);
        System.out.println(ages);//27

        //---暴力反射修改，已有初始值的private final常量
        age.set(student, 28);

        //读取修改后的属性值
        System.out.println((int)age.get(student));
    }

}

class Student {
    private final int age;  //私有的 final的变量
    public Student() {
        age = 27;
    }
}
