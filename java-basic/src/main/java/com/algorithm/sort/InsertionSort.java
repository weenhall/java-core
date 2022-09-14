package com.algorithm.sort;

/**
 * 插入排序
 * 描述：
 * 1.从第一个元素开始，认为改元素已被排序
 * 2.取出下一个元素，在已排序的元素中从后向前扫描
 * 3.如果该元素大于大于新元素，则将该元素下移
 * 4.重复步骤1-3
 */
public class InsertionSort extends SortAlgorithm{

    public static void main(String[] args) {
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        int len=arr.length;
        int preIndex,current;
        for(int i=1;i<len;i++){
            preIndex=i-1;
            current=arr[i];
            while (preIndex>=0&&arr[preIndex]>current){
                arr[preIndex+1]=arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1]=current;
        }
        print(arr);
    }
}
