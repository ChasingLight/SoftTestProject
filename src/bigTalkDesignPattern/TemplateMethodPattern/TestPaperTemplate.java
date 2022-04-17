package bigTalkDesignPattern.TemplateMethodPattern;


public abstract class TestPaperTemplate {

    //代码复用----相同的试卷---begin
    public void question1(){
        System.out.println("1+1等于() A:2 B:3 C:4 D:5");
        System.out.println("答案：" + answer1());
    }

    public void question2(){
        System.out.println("4的立方是多少() A:16 B:4 C:64 D:8");
        System.out.println("答案：" + answer2());
    }

    public void question3(){
        System.out.println("-9的绝对值是多少() A:9 B:-9 C:1 D:0");
        System.out.println("答案：" + answer3());
    }
    //代码复用----相同的试卷---end


    //方法拓展点---延迟到子类中定义
    protected abstract String answer1();
    protected abstract String answer2();
    protected abstract String answer3();





}
