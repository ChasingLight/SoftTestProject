package bigTalkDesignPattern.ObserverPatternImplByEventHandler.concreteSubjectObserver;


import java.util.Objects;

public class ObserverOne {

    private String name;
    public void oneUpdate(){
        System.out.println("已通知观察者"+name+"：观察者"+name+"的oneUpdate方法执行了");
    }

    public ObserverOne(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObserverOne that = (ObserverOne) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
