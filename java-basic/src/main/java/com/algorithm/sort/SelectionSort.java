package com.algorithm.sort;

/**
 *选择排序
 * 描述：
 * 1.第一趟排序找到序列中最大（最小）的元素，放在序列起始位置
 * 2.重复上述步骤，每次选出一个元素，直到所有元素排序完毕
 */
public class SelectionSort extends SortAlgorithm{

    public static void main(String[] args) {
        Integer [] arr=new Integer[]{4,23,6,78,1,54,231,9,12};
        int len=arr.length;
        for(int i=0;i<len-1;i++){
            int minIndex=i;
            for(int j=i+1;j<len;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                int temp=arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
        }
        print(arr);
    }
}
