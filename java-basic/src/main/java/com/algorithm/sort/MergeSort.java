package com.algorithm.sort;

/**
 * 归并排序
 * 描述：
 * 1.把长度为n的输入序列分成两个长度为n/2的子序
 * 2.分别对两个子序采用归并排序
 * 3.将两个排序好的子序合并
 */
public class MergeSort extends SortAlgorithm{

    public static void main(String[] args) {
        Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        Integer [] res=new Integer[arr.length];
        sortAndMerge(arr,res,0,arr.length-1);
        print(res);
    }

    private static void sortAndMerge(Integer [] arr,Integer [] res, int start,int end){
        if(start>=end){
            return;
        }
        int len=end-start,mid=(len>>1)+start;
        int start1=start,end1=mid;
        int start2=mid+1,end2=end;
        //分成两块，然后将两块又进行平分
        sortAndMerge(arr,res,start1,end1);
        sortAndMerge(arr,res,start2,end2);
        int k=start;
        while (start1<=end1&&start2<=end2){
            res[k++]=arr[start1]<arr[start2]?arr[start1++]:arr[start2++];
        }
        while (start1<=end1){
            res[k++]=arr[start1++];
        }
        while (start2<=end2){
            res[k++]=arr[start2++];
        }
        for(k=start;k<=end;k++){
            arr[k]=res[k];
        }
    }
}
