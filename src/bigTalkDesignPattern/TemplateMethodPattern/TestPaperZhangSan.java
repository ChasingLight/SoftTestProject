package bigTalkDesignPattern.TemplateMethodPattern;

public class TestPaperZhangSan extends TestPaperTemplate{

    @Override
    protected String answer1() {
        return "A";
    }

    @Override
    protected String answer2() {
        return "C";
    }

    @Override
    protected String answer3() {
        return "A";
    }
}
