package bigTalkDesignPattern.ObserverPatternImplByEventHandler;


import bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver.AbstractSubject;
import bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver.ObserverOne;
import bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver.ObserverTwo;
import bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver.SubjectOne;


// 观察者模式+事件委托(JAVA版)---底层基于Java反射机制实现
// https://blog.csdn.net/weixin_42794011/article/details/115694934
public class MainTest {

    public static void main(String[] args) {
        AbstractSubject subject = new SubjectOne("防空警报");

        ObserverOne observerOne = new ObserverOne("张三");
        ObserverTwo observerTwo = new ObserverTwo("李四");

        subject.addObserver(observerOne, "oneUpdate");
        subject.addObserver(observerTwo,"twoUpdate","温馨提示：请安全有序撤离到最近的防空洞中");


        try {
            subject.notifyObserver();

            System.out.println("---移除观察者测试---");
            subject.removeObserver(new ObserverTwo("李四"),"twoUpdate", "温馨提示：请安全有序撤离到最近的防空洞中");
            subject.notifyObserver();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
