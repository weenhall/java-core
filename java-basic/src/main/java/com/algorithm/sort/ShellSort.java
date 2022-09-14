package com.algorithm.sort;

/**
 * 希尔排序，插入排序的改进版，又称缩小增量排序
 * 描述：
 * 1.先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序
 * 2.选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；(增量的意思是间隔)
 * 3.按增量序列个数k，对序列进行k 趟排序；
 * 4.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 */
public class ShellSort extends SortAlgorithm {

    public static void main(String[] args) {
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        int len=arr.length;
        int gap=1;
        //计算子序间隔
        while (gap<len/3){
            gap=3*gap+1;
        }
        for(;gap>0;gap/=3){
            for(int i=gap;i<len;i++){
                int j;
                int temp=arr[i];
                for(j=i;j>=gap&&temp<arr[j-gap];j-=gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
        print(arr);
    }
}
