package com.collections.list;

import java.util.*;

public class ArrayListExample {


    public static void main(String[] args) {
//        basicOperation();
//        forEach();
        sort();
    }

    //ArrayList基本操作
    public static void basicOperation() {
        List<String> letters = new ArrayList<String>();
        //添加
        letters.add("A");
        letters.add("B");
        letters.add("D");
        //指定位置添加
        letters.add(2, "C");
        System.out.println(letters);

        List<String> letters1 = new ArrayList<String>();
        letters1.add("E");
        letters1.add("F");
        //将letters1全部添加到letters中
        letters.addAll(letters1);
        System.out.println(letters);
        //清空集合
        letters1.clear();
        letters1.add("G");
        letters1.add("H");
        letters.addAll(6, letters1);
        System.out.println(letters);

        //是否包含元素
        System.out.println("是否包含元素E:" + letters.contains("E"));
        System.out.println("是否包含元素Z:" + letters.contains("Z"));

        //指定List大小
        ArrayList<String> tempList = new ArrayList<>();
        tempList.ensureCapacity(1000);

        //获取指定位置元素
        String element = letters.get(4);
        System.out.println("第5个元素的值为：" + element);

        //判断List是否为空
        System.out.println(tempList.isEmpty());

        //查找元素位置
        System.out.println("元素E出现的位置:" + letters.indexOf("E"));
        System.out.println("元素E最后出现的位置:" + letters.lastIndexOf("E"));

        //移除指定元素（只移除第一个）
        boolean isRemoved = letters.remove("H");
        System.out.println(isRemoved);
        //移除所有符合的元素
        isRemoved = letters.removeAll(tempList);
        System.out.println(isRemoved);

        //取两个List的交集
        letters1.clear();
        letters1.add("A");
        letters1.add("B");
        letters1.add("C");
        letters1.add("Z");
        System.out.println("letters取letters1的交集:" + letters.retainAll(letters1));
        System.out.println(letters);

        //获取List大小
        System.out.println("letters的大小是:" + letters.size());

        //替换元素set
        letters.set(2, "D");
        System.out.println(letters);

        //List转Array
        String[] arr = new String[letters.size()];
        arr = letters.toArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    //ArrayList遍历
    public static void forEach() {
        List<String> stocks = new ArrayList<>();
        stocks.add("Google");
        stocks.add("Apple");
        stocks.add("Yahoo");
        System.out.println("使用JDK8遍历");
        stocks.forEach(System.out::println);

        System.out.println("使用Iterator遍历");
        Iterator<String> it = stocks.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("使用for循环遍历");
        for (int i = 0; i < stocks.size(); i++) {
            System.out.println(stocks.get(i));
        }

        System.out.println("使用for-each增强循环");
        for (String element : stocks) {
            System.out.println(element);
        }

        System.out.println("使用ListIterator遍历");
        ListIterator<String> lit=stocks.listIterator(stocks.size());
        while (lit.hasNext()){
            System.out.println(lit.next());
        }
    }

    //ArrayList排序
    public static void sort(){
        List<Integer> list=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i <10 ; i++) {
            list.add(random.nextInt(1000));
        }

        System.out.println("排序前:"+list);

        //JDK1.8之前
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        System.out.println("排序按升序:"+list);
        //JDK1.8
        list.sort((o1,o2)->{
            return o2-o1;
        });
        System.out.println("排序按降序:"+list);
    }

    //ArrayList线程安全类
    public static void threadSafe(){
        List<Integer> list=new ArrayList<>();
        List<Integer> synchronizedList=Collections.synchronizedList(list);
    }
}
