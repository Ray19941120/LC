package mytest;

import java.util.LinkedList;

public class MyHashMap<K,V> {
    private LinkedList[] arr = new LinkedList[1024];
    private Integer size ;
    public Integer getSize(){
        return size;
    }

    /**
     * 存入一个key-value对
     */
    public void put(K key,V value){
        //把这个数据塞到数据结构存储
        MyEntry<K, V> myEntry = new MyEntry<>(key, value);
        int num = Math.abs(key.hashCode() % arr.length);
        if (arr[num] == null) {
            LinkedList list = new LinkedList();
            list.add(myEntry);
            arr[num] = list;
        } else {
            //此处使用链表，而java8中还加入了红黑树
            LinkedList list = arr[num];
            //进入else分支，说明散列中了，取出这条链，对这条链做遍历
            //如果Key相同，那么替换其value值
            for (Object obj : list) {
                MyEntry<K,V> myEntry1 = (MyEntry) obj;
                if (myEntry1.key.equals(key)) {
                    myEntry1.value = value;
                    return;
                }
            }
            arr[num].add(myEntry);
        }
    }

    public V get(K key) {
        int i = Math.abs(key.hashCode() % arr.length);
        if (arr[i] != null) {
            LinkedList list = arr[i];
            for (Object object : list) {
                MyEntry <K,V>myEntry = (MyEntry) object;
                if (myEntry.key.equals(key)) {
                    return myEntry.value;
                }
            }
        }
        return null;
    }

    static class MyEntry<K,V>{
        K key;
        V value;

        private MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
