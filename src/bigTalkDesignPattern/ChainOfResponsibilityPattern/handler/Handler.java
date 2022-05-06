package bigTalkDesignPattern.ChainOfResponsibilityPattern.handler;

//模板方法模式
public abstract class Handler {
    private Handler successor;  //后继者、继承者

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(int leaveDays);
}
