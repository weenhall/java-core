## Java Collections Framework 集合框架
* "Collection" is the base interface
* Map is also part of Collections API
* List,Set,Queue,Iterator are the popular interfaces
* ArrayList,HashSet,HashMap,TreeSet,LinkedList,PriorityQueue are popular implementation classes
* "Collections" is a utility class

## Framework Consists 组成部分
* **Interfaces** : java.util.Collection 是 Collections 框架的顶部接口,其中比较重要的接口有  
  * java.util.List
  * java.util.Set
  * java.util.Queue 
  * java.util.Map  
  Map 接口其实是没有继承 Collection 接口的，但它仍然属于集合框架的一部分，所有的集合框架接口都位于 java.util 包下面  

* **Implementation Classes** : 一些重要的实现类有
  * ArrayList
  * LinkedList
  * HashMap
  * TreeMap
  * HashSet
  * TreeSet  
  JDK1.5出现了并发工具包,其中一些线程安全的集合类有
  * CopyOnWriteArrayList
  * ConcurrentHasMap
  * CopyOnWriteArraySet
  