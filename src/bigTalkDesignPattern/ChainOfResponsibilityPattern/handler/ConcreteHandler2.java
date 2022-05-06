package bigTalkDesignPattern.ChainOfResponsibilityPattern.handler;

//人事经理---能处理[4,7]范围内请假
public class ConcreteHandler2 extends Handler{

    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays >= 4 && leaveDays <= 7){
            System.out.println("人事经理审批通过请假，天数为：" + leaveDays);
        }else if (super.getSuccessor() != null){
            //后继者处理请求
            super.getSuccessor().handleRequest(leaveDays);
        }
    }
}
