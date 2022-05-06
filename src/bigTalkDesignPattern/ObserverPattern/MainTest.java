package bigTalkDesignPattern.ObserverPattern;

import bigTalkDesignPattern.ObserverPattern.abstractSubjectObserver.Observer;
import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteObserver.AutomaticCarObserver;
import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteObserver.ManualCarObserver;
import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteObserver.TrafficObserver;
import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject.TrafficLightsStateEnum;
import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject.TrafficLightsSubject;

import java.util.Collections;

public class MainTest {

    public static void main(String[] args) {

        //主题
        TrafficLightsSubject trafficSubject = new TrafficLightsSubject();
        //观察者
        Observer observer1 = new ManualCarObserver("长安35Plus手动挡", trafficSubject);
        Observer observer2 = new AutomaticCarObserver("思域180自动挡", trafficSubject);
        trafficSubject.addObserver(observer1);
        trafficSubject.addObserver(observer2);

        //黄灯等一等
        trafficSubject.setTrafficLightsStateEnum(TrafficLightsStateEnum.YELLOW);
        trafficSubject.notifyObs();

        //红灯停
        trafficSubject.setTrafficLightsStateEnum(TrafficLightsStateEnum.RED);
        trafficSubject.notifyObs();

        //绿灯行
        trafficSubject.setTrafficLightsStateEnum(TrafficLightsStateEnum.GREEN);
        trafficSubject.notifyObs();


    }
}
