package bigTalkDesignPattern.DecoratorPattern.concreteCompent;

//鸡蛋灌饼
public class ConcreteEggPancake implements Pancake{

    @Override
    public void cook() {
        System.out.println("烹饪-基础鸡蛋灌饼【包括生菜、甜面酱】");
    }
}
