package JavaConcurrencyInPractice.chap4;

import JavaConcurrencyInPractice.annotation.GuardedBy;
import JavaConcurrencyInPractice.annotation.ThreadSafe;

import java.util.*;

//实例封闭：在不修改类的基础上，保证操作类对象的线程安全性
@ThreadSafe
public class PersonSet {

    //1.私有封闭，保证不逸出
    @GuardedBy("this")
    private final Set<Person> mySet = new HashSet<>();

    //2.提供【公共&&同步协同】，的访问的方法
    public synchronized void addPerson(Person p){
        mySet.add(p);
    }
    public synchronized boolean containsPerson(Person p){
        return mySet.contains(p);
    }
}
