package sourceCodeLearn;


//Integer类中有一个IntegerCache内部类，默认缓存了[-128,127]的Integer。
//-XX:AutoBoxCacheMax=200 在JVM参数中动态设置上限
public class IntegerCacheTest {
    public static void main(String[] args) {
        //-XX:AutoBoxCacheMax=200
        Integer aa = 127;
        Integer bb = 127;
        Integer cc = 128;
        Integer dd = 128;

        System.out.println(aa == bb);
        System.out.println(cc == dd);
    }
}
