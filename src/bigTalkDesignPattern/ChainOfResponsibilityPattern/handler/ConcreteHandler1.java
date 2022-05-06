package bigTalkDesignPattern.ChainOfResponsibilityPattern.handler;

//项目经理---能处理[1,3]范围内请假
public class ConcreteHandler1 extends Handler{

    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays >= 1 && leaveDays <= 3){
            System.out.println("项目经理审批通过请假，天数为：" + leaveDays);
        }else if (super.getSuccessor() != null){
            //后继者处理请求
            super.getSuccessor().handleRequest(leaveDays);
        }
    }
}
