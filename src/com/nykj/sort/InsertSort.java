package com.nykj.sort;

/**
 * @author chenlin
 */
public class InsertSort implements Sort {

    /**
     * 插入排序: 维护一个有序区，类似于扑克牌插入
     * 时间复杂度：O(n²)
     * 空间复杂度：0(1)
     * 稳定排序
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        //遍历循环 i代表有序区长度
        for (int i = 0; i < array.length; i++) {
            //在有序区里排序
            for (int j = 0; j < i; j++) {
                //使用两两对比比较排序
                if (array[i] < array[j]) {
                    //互换
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}
