package bigTalkDesignPattern.ProtypePattern;

public class MainTest {
    public static void main(String[] args) {
        ProtypeResume a = new ProtypeResume("靳浩东","男",27,"计算机科学与技术");
        System.out.println(a);

        ProtypeResume b = (ProtypeResume) a.clone();  //核心地方
        System.out.println(b);

        //判断对象a和b是否是同一个对象【期望值为false】
        System.out.println(a == b);
    }
}
