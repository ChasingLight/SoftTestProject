package bigTalkDesignPattern.DecoratorPattern.concreteCompent;

//烙馍
public class ConcreteBakedPancake implements Pancake{

    @Override
    public void cook() {
        System.out.println("烹饪-基础烙馍");
    }
}
