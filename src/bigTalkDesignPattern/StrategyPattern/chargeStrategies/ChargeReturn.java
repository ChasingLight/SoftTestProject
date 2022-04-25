package bigTalkDesignPattern.StrategyPattern.chargeStrategies;

// 收费策略2：满XXX返XXX
public class ChargeReturn extends ChargeSuper {

    private double moneyCondition;  //满减初始金额
    private double moneyReturn;  //满减后返还金额

    public ChargeReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public double charge(double money) {

        // 判断是否符合满减
        if (money >= moneyCondition && moneyCondition != 0){
            money = money - Math.floor(money/moneyCondition)*moneyReturn;
        }

        return money;
    }
}
