package bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteObserver;

import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject.TrafficLightsSubject;

public class AutomaticCarObserver extends TrafficObserver {

    public AutomaticCarObserver(String carName, TrafficLightsSubject trafficLightsSubject) {
        this.carName = carName;
        this.trafficLightsSubject = trafficLightsSubject;
    }

    @Override
    public void waitCar() {
        System.out.println(this.carName + "减速-等一等-挂N挡");
    }

    @Override
    public void stopCar() {
        System.out.println(this.carName + "减速-挂N挡-停车");
    }

    @Override
    public void startCar() {
        System.out.println(this.carName + "挂D挡-踩油门-起步行驶");
    }
}
