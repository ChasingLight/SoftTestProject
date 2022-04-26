package bigTalkDesignPattern.StrategyPattern;


import bigTalkDesignPattern.StrategyPattern.chargeSuperProxyFactory.ChargeSuperProxyAndFactory;
import bigTalkDesignPattern.StrategyPattern.chargeSuperProxyFactory.ChargeTypeEnum;

public class MainTest {
    public static void main(String[] args) {

        double money = 100;

        //TODO 待优点：不同策略的-核心参数都是money，除了普通策略其他需要额外参数。
        ChargeSuperProxyAndFactory chargeSuperProxy = new ChargeSuperProxyAndFactory(ChargeTypeEnum.NORMAL,0,0);
        double finalMoney = chargeSuperProxy.chargeProxy(money);
        System.out.println(finalMoney);

        ChargeSuperProxyAndFactory chargeSuperProxy2 = new ChargeSuperProxyAndFactory(ChargeTypeEnum.REBATE,0.7,0);
        System.out.println(chargeSuperProxy2.chargeProxy(money));

        ChargeSuperProxyAndFactory chargeSuperProxy3 = new ChargeSuperProxyAndFactory(ChargeTypeEnum.RETURN,60,10);
        System.out.println(chargeSuperProxy3.chargeProxy(money));

    }
}
