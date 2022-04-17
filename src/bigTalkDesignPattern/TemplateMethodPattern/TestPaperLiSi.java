package bigTalkDesignPattern.TemplateMethodPattern;

public class TestPaperLiSi extends TestPaperTemplate{
    @Override
    protected String answer1() {
        return "A";
    }

    @Override
    protected String answer2() {
        return "B";
    }

    @Override
    protected String answer3() {
        return "B";
    }
}
