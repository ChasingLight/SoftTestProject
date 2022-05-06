package bigTalkDesignPattern.DecoratorPattern.decorator;

import bigTalkDesignPattern.DecoratorPattern.concreteCompent.Pancake;

//抽象装饰类---模板方法模式
public abstract class DecoratorPancake implements Pancake {

    private Pancake pancake;

    public Pancake getPancake() {
        return pancake;
    }

    public void setPancake(Pancake pancake) {
        this.pancake = pancake;
    }

    @Override
    public void cook() {
        if (pancake != null){
            pancake.cook();
        }else{
            System.out.println("请初始化Pancake");
        }
    }
}
