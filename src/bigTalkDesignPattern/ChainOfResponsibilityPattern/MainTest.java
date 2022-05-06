package bigTalkDesignPattern.ChainOfResponsibilityPattern;

import bigTalkDesignPattern.ChainOfResponsibilityPattern.context.ChainHandlerContext;
import bigTalkDesignPattern.ChainOfResponsibilityPattern.handler.Handler;

import java.util.ArrayList;
import java.util.List;


/*
* 职责链模式：
* 1>具体处理类ConcreteHandler处理它所负责的请求，可访问它的后继者successor；
* 2>如果可处理当前请求，就处理之；如果不可以将请求转发给后继者处理。
*
* 需求：IT程序员请假leaveDay
* 1> [1,3]天，项目经理直接审批；
* 2> [4,7]天，人事经理直接审批；
* 3> [8,30]天，总经理直接审批；
* 如果大于30天，则需要慎重考虑之后，再决定。
*
* */
public class MainTest {
    public static void main(String[] args) {

        Handler firstChainHandler = ChainHandlerContext.constructChainHandler();

        //不同的请假天数
        List<Integer> leaveDays = new ArrayList<>();
        leaveDays.add(2);
        leaveDays.add(7);
        leaveDays.add(15);
        leaveDays.add(40);

        for (Integer temp : leaveDays){
            firstChainHandler.handleRequest(temp);
        }

    }
}
