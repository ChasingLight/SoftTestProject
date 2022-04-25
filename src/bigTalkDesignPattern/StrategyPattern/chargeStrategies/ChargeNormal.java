package bigTalkDesignPattern.StrategyPattern.chargeStrategies;

// 收费策略1：正常收费
public class ChargeNormal extends ChargeSuper{

    @Override
    public double charge(double money) {
        return money;
    }
}
