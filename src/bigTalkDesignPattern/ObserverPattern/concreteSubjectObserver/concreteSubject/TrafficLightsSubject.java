package bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject;

import bigTalkDesignPattern.ObserverPattern.abstractSubjectObserver.Subject;

public class TrafficLightsSubject extends Subject {

    // 状态变化集合[红灯、绿灯、黄灯]
    private TrafficLightsStateEnum trafficLightsStateEnum;

    public TrafficLightsStateEnum getTrafficLightsStateEnum() {
        return trafficLightsStateEnum;
    }

    public void setTrafficLightsStateEnum(TrafficLightsStateEnum trafficLightsStateEnum) {
        this.trafficLightsStateEnum = trafficLightsStateEnum;
    }
}
