package bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver;

import java.util.Objects;

public class ObserverTwo {

    private String name;
    public void twoUpdate(String str){
        System.out.println("已通知观察者"+name+"：观察者"+name+"的twoUpdate方法执行了,接收到的参数为:"+str);
    }

    public ObserverTwo(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObserverTwo that = (ObserverTwo) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
