package bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteObserver;

import bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject.TrafficLightsSubject;

public class ManualCarObserver extends TrafficObserver {

    public ManualCarObserver(String carName, TrafficLightsSubject trafficLightsSubject) {
        this.carName = carName;
        this.trafficLightsSubject = trafficLightsSubject;
    }

    @Override
    public void waitCar() {
        System.out.println(trafficLightsSubject.getTrafficLightsStateEnum().getDescription() + this.carName + "减速-等一等");
    }

    @Override
    public void stopCar() {
        System.out.println(this.carName + "减速-挂空挡-停车");
    }

    @Override
    public void startCar() {
        System.out.println(this.carName + "挂1挡-松离合-加油门-正常行驶");
    }
}
