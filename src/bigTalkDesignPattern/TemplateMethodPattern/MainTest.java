package bigTalkDesignPattern.TemplateMethodPattern;

/**
 * 模板方法模式，依赖技术核心点：抽象类。
 * 1>代码复用【继承】：每个学生的试卷题目是相同的。
 * 2>功能拓展【方法重写父类抽象方法】：每个学生有各自的试题答案。
 */
public class MainTest {

    public static void main(String[] args) {

        System.out.println("---张三的试卷及答案---");
        TestPaperTemplate zhangsanPaper = new TestPaperZhangSan();
        zhangsanPaper.question1();
        zhangsanPaper.question2();
        zhangsanPaper.question3();

        System.out.println("---李四的试卷及答案---");
        TestPaperTemplate lisiPaper = new TestPaperLiSi();
        lisiPaper.question1();
        lisiPaper.question2();
        lisiPaper.question3();
    }
}
