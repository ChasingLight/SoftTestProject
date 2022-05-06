package bigTalkDesignPattern.DecoratorPattern.decorator;

//煎饼-加鸡柳
public class PeanutDecoratorPancake extends DecoratorPancake {

    @Override
    public void cook() {
        super.cook();
        System.out.println("额外加-花生碎");
    }
}
