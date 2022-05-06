package bigTalkDesignPattern.DecoratorPattern;


import bigTalkDesignPattern.DecoratorPattern.concreteCompent.ConcreteBakedPancake;
import bigTalkDesignPattern.DecoratorPattern.concreteCompent.ConcreteEggPancake;
import bigTalkDesignPattern.DecoratorPattern.decorator.ChickenDecoratorPancake;
import bigTalkDesignPattern.DecoratorPattern.decorator.MeatFlossDecoratorPancake;
import bigTalkDesignPattern.DecoratorPattern.decorator.PeanutDecoratorPancake;

public class MainTest {
    public static void main(String[] args) {
        //核心代码实现
        ConcreteEggPancake eggPancake = new ConcreteEggPancake();
        ConcreteBakedPancake bakedPancake = new ConcreteBakedPancake();

        //装饰部分代码【后置增强】
        ChickenDecoratorPancake chickenDecorator = new ChickenDecoratorPancake();
        MeatFlossDecoratorPancake meatFlossDecorator = new MeatFlossDecoratorPancake();
        PeanutDecoratorPancake peanutDecorator = new PeanutDecoratorPancake();

        //链式组合-装饰
        // 【基础鸡蛋灌饼->加鸡柳->加肉松->加花生碎】
        chickenDecorator.setPancake(bakedPancake);  //bakedPancake  eggPancake
        meatFlossDecorator.setPancake(chickenDecorator);
        peanutDecorator.setPancake(meatFlossDecorator);

        peanutDecorator.cook();
    }
}
