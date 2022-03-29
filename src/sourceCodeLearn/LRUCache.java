package sourceCodeLearn;

import java.util.LinkedHashMap;
import java.util.Map;

/*
* 第146题
* 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。

实现 LRUCache 类：
LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？【需要使用到Hash算法】

参考介绍链接：https://blog.csdn.net/justloveyou_/article/details/71713781
* */
public class LRUCache extends LinkedHashMap<Integer, Integer>{

    private int capacity;

    LRUCache(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }

    int get(int key){
        return super.getOrDefault(key,-1);
    }

    void put(int key, int value){
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);

        //get 或者 put覆盖已有key的值 afterNodeAccess将当前Entry放在在双向链表的尾部
        //cache.get(1);
        cache.put(1,11);

        cache.put(3,3);
        System.out.println(cache);

    }
}
