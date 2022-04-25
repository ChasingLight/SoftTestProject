package bigTalkDesignPattern.StrategyPattern.chargeStrategies;

// 收费策略3：打折
public class ChargeRebate extends ChargeSuper {

    private double disCount;  //折扣率[0.8、0.9]

    public ChargeRebate(double disCount) {
        this.disCount = disCount;
    }

    @Override
    public double charge(double money) {
        return money * disCount;
    }
}
