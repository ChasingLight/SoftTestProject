package bigTalkDesignPattern.ObserverPattern.concreteSubjectObserver.concreteSubject;

public enum TrafficLightsStateEnum {
    RED("红灯"),
    GREEN("绿灯"),
    YELLOW("黄灯");

    private String description;

    TrafficLightsStateEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
