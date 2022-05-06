package bigTalkDesignPattern.ChainOfResponsibilityPattern.context;

import bigTalkDesignPattern.ChainOfResponsibilityPattern.handler.ConcreteHandler1;
import bigTalkDesignPattern.ChainOfResponsibilityPattern.handler.ConcreteHandler2;
import bigTalkDesignPattern.ChainOfResponsibilityPattern.handler.ConcreteHandler3;
import bigTalkDesignPattern.ChainOfResponsibilityPattern.handler.Handler;

public class ChainHandlerContext {

    /**
     * 组装职责链，同时返回头部具体的handler即可
     * @return
     */
    public static Handler constructChainHandler(){

        //职责链：handler1--->handler2--->handler3
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();
        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);
        handler3.setSuccessor(null);  //说明handler3是职责链的最后一个处理者

        return handler1;
    }
}
