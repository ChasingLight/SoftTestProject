package bigTalkDesignPattern.ChainOfResponsibilityPattern.handler;

//总经理---能处理[8,30]范围内请假
public class ConcreteHandler3 extends Handler{

    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays >= 8 && leaveDays <= 30){
            System.out.println("总经理审批通过请假，天数为：" + leaveDays);
        }else {
            if (super.getSuccessor() != null){
                super.getSuccessor().handleRequest(leaveDays);
            }else{
                System.out.println("总经理需要慎重考虑一下，请假天数为：" + leaveDays);
            }
        }
    }
}
