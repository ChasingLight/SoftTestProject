package bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteObserver;

import bigTalkDesignPattern.ObserverPattern.abstractSubjectObserver.Observer;
import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject.TrafficLightsSubject;

//抽象交通信号灯【模板方法模式】
public abstract class TrafficObserver implements Observer {

    protected String carName;
    protected TrafficLightsSubject trafficLightsSubject;

    public abstract void waitCar();
    public abstract void stopCar();
    public abstract void startCar();


    @Override
    public void update() {
        switch(trafficLightsSubject.getTrafficLightsStateEnum()){
            case RED:
                stopCar();
                break;
            case GREEN:
                startCar();
                break;
            case YELLOW:
                waitCar();
                break;
        }

    }
}
