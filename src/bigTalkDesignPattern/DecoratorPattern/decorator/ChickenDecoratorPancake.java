package bigTalkDesignPattern.DecoratorPattern.decorator;

//煎饼-加鸡柳
public class ChickenDecoratorPancake extends DecoratorPancake {

    @Override
    public void cook() {
        super.cook();
        System.out.println("额外加-鸡柳");
    }
}
