package com.algorithm.sort;

/**
 * 冒泡排序
 * 描述：
 * 1.依次比较相邻元素，如果第一个比第二个大，则交换两个的顺序
 * 2.重复n次后即可
 */
public class BubbleSort extends SortAlgorithm{

    public static void main(String[] args) {
        Integer [] arr=new Integer[]{4,31,3,51,1,7,5,9,49};
        int len=arr.length;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        print(arr);
    }
}
