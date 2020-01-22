package com.nykj.sort;

/**
 * @author chenlin
 */
public class QuickSort implements Sort {

    /**
     * 快速排序
     * 时间复杂度0（nlogn）这里的底为2
     * 空间复杂度0（1）
     * 不稳定算法
     * 使用递归实现（挖坑法）
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        return recursiveSort(0,array.length -1,array);
}

    private int[] recursiveSort(int left, int right, int[] array) {
        //跳出递归条件
        if (left >= right) {
            return array;
        }
        int leftIndex = left;
        int rightIndex = right;
        //坑位置
        int pivotIndex = (int) (Math.random() * rightIndex);
        int pivot = array[pivotIndex];
        while (rightIndex >= leftIndex) {
            //这里的条件借鉴漫画算法的比较
            while (rightIndex >= leftIndex) {
                //如果右指针大于基准值，则右指针左移
                if (array[rightIndex] <= pivot) {
                    array[pivotIndex] = array[rightIndex];
                    //将坑的位置变为交换的位置
                    pivotIndex = rightIndex;
                    rightIndex--;
                    break;
                }
                //左移
                rightIndex--;
            }
            //如果左指针大于基准值，左指针直接左移
            while (rightIndex >= leftIndex) {
                if (array[leftIndex] >= pivot) {
                    array[pivotIndex] = array[leftIndex];
                    //将坑的位置变为交换的位置
                    pivotIndex = leftIndex;
                    //右移
                    leftIndex++;
                    break;
                }
                leftIndex++;
            }
        }
        //把最后坑的位置填上基准值
        array[pivotIndex] = pivot;
        //递归(分治法)
        recursiveSort(left, pivotIndex -1, array);
        recursiveSort(pivotIndex + 1, right, array);
        return array;
    }
}
