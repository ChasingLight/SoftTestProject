package bigTalkDesignPattern.StrategyPattern.chargeSuperProxyFactory;


import bigTalkDesignPattern.StrategyPattern.chargeStrategies.ChargeNormal;
import bigTalkDesignPattern.StrategyPattern.chargeStrategies.ChargeRebate;
import bigTalkDesignPattern.StrategyPattern.chargeStrategies.ChargeReturn;
import bigTalkDesignPattern.StrategyPattern.chargeStrategies.ChargeSuper;

/**
 *简单工厂模式---实现策略的选择
 * 意义
 * 1> 随着策略具体实现越来越多，客户要了解每个算法细节很不好。
 *    通过本类，客户端就可不必知晓具体算法类，就能使用；
 * 2> 客户端通过枚举【正常、打折、满减】，确定想要的策略即可；
 * 3> 通过本类，将【算法具体实现】和【算法的选择】代码上分开。(符合单一职责原则)
 */
public class ChargeSuperProxyAndFactory {

    //代理模式 + 简单工厂模式
    private ChargeSuper chargeSuper;


//    public ChargeSuperProxyAndFactory(ChargeTypeEnum chargeType) {
//        ChargeSuperProxyAndFactory(chargeType,0,0);
//    }

    /**
     * 构造函数-初始化具体策略
     * @param chargeType  策略枚举类
     * @param param1      满减初始金额、折扣率【0.8、0.9】
     * @param params2     满减扣除金额
     *
     */
    public ChargeSuperProxyAndFactory(ChargeTypeEnum chargeType, double param1, double params2){
        switch (chargeType){
            case NORMAL:
                chargeSuper = new ChargeNormal();
                break;
            case REBATE:
                chargeSuper = new ChargeRebate(param1);
                break;
            case RETURN:
                chargeSuper = new ChargeReturn(param1, params2);
                break;
        }
    }

    //不能是static的，只能实例化一个当前类。确定好具体策略才能代理使用
    public double chargeProxy(double money){
        return chargeSuper.charge(money);
    }
}
