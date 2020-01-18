package com.nykj.sort;

/**
 * @author chenlin
 */
public class SelectSort implements Sort {

    /**
     * 选择排序:每次选择最小的值放到最左边（右边）
     * 时间复杂度：0（n²）
     * 空间复杂度：0（1）
     * 不稳定排序
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        //外层控制遍历次数
        for (int i = 0; i < array.length; i++) {
            int minValue = array[i];
            int minIndex = i;
            //内层寻找最小值
            for (int j = i; j < array.length - 1; j++) {
                if (minValue >= array[j + 1]) {
                    minValue = array[j + 1];
                    //记录最小值位置
                    minIndex = j + 1;
                }
            }
            //进行交换
            if (minIndex != i) {
                int tempValue = array[i];
                array[i] = array[minIndex];
                array[minIndex] = tempValue;
            }
        }
        return array;
    }
}
