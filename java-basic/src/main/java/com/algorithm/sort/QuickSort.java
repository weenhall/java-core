package com.algorithm.sort;

/**
 * 快速排序
 * 描述:
 * 1.从序列中挑出一个元素，称为基准(pivot)
 * 2.对序列排序，大于基准的值放于后面，小于基准的值放置前面(称之为分区操作partition)
 * 3.递归的进行第2步
 *
 */
public class QuickSort extends SortAlgorithm{

    public static void main(String[] args) {
        Integer[] array = {3, 4, 1, 32, 0, 1, 5, 12, 2, 5, 7, 8, 9, 2, 44, 111, 5};
        quickSort(array,0,array.length-1);
        print(array);
    }

    static void quickSort(Integer arr[],int start,int end){
        if(start>=end){
            return;
        }
        int mid=arr[end];
        int left=start,right=end-1;
        while (left<right){
            while (arr[left]<=mid&&left<right){
                left++;
            }
            while (arr[right]>=mid&&left<right){
                right--;
            }
            swap(arr,left,right);
        }
        if(arr[left]>=arr[end]){
            swap(arr,left,end);
        }else{
            left++;
        }
        quickSort(arr,start,left-1);
        quickSort(arr,left+1,end);
    }
}
