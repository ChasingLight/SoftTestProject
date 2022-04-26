package bigTalkDesignPattern.ObserverPattern.abstractSubjectObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    // 状态变化集合---延迟到具体的Subject中实现

    // 待通知的---多个观察者
    List<Observer> observers = new ArrayList<>();

    // 增加观察者
    public void addObserver(Observer observer){
        observers.add(observer);
    }

    // 删除观察者
    public void deleteObserver(Observer observer){
        observers.remove(observer);
    }

    // Subject状态变化，通知所有观察者-进行更新
    public void notifyObs(){
        for (Observer temp : observers) {
            temp.update();
        }
    }

}
