package JavaConcurrencyInPractice.chap4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        //Way1：PersonSet线程安全类【本质也是使用了装饰器模式】
        PersonSet personSet = new PersonSet();
        personSet.addPerson(new Person("靳浩东",27));
        personSet.addPerson(new Person("陈隆基",27));
        personSet.addPerson(new Person("邢华阳",28));

        //Way2：Java类库中的【实例封闭】
        //1.ArrayList并非线程安全的
        List<Person> jadenList = new ArrayList<>();
        //2.实例封闭-装饰模式-实现线程安全访问
        //【请查看Collections.synchronizedList源码实现就可以窥探其中奥秘】
        List<Person> jadenSynList = Collections.synchronizedList(jadenList);

    }
}
