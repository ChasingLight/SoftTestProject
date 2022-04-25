package bigTalkDesignPattern.StrategyPattern.chargeStrategies;

/**
 * 收费抽象类，定义-管理策略集
 * 1.正常收费
 * 2.打折
 * 3.满xxx返xxx
 *
 * 意义：
 * 1>通过【抽象类继承】，将多种策略思维逻辑上的可替换行，体现-维护在代码中；
 * 2>可扩展：新增策略，直接新建一个策略继承抽象类即可。(符合开发-封闭原则)
 * 3>可维护：修改某一个已有策略，不会对其他策略产生任何影响。
 * 4>面向接口编程：直接依赖抽象类，而非具体实现。可利用【里氏代换原则】灵活切换想用的算法
 */
public abstract class ChargeSuper {
    public abstract double charge(double money);
}
