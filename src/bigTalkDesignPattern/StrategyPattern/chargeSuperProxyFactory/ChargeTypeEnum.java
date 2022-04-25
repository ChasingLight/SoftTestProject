package bigTalkDesignPattern.StrategyPattern.chargeSuperProxyFactory;

public enum ChargeTypeEnum {
    NORMAL(1,"原价收费"),
    REBATE(2,"打折收费"),
    RETURN(3,"满减收费");

    private int value;
    private String description;

    ChargeTypeEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
