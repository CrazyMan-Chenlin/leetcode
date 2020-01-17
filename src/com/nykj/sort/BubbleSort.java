package com.nykj.sort;

/**
 * @author chenlin
 */
public class BubbleSort implements Sort {

    /**
     * 冒泡排序:稳定排序
     * 时间复杂度 0(n²)
     * 空间复杂度O(1)
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {

        //外层循环
        for (int i = 0; i < array.length; i++) {
            //内层循环
            for (int j = 0; j < array.length - 1; j++) {
                //如果当前的值大于下个值，那么就需要交换
                if (array[j] > array[j + 1]) {
                    //用一个临时变量来存储值
                    int temp = array[j];
                    //交换
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 优化冒泡排序
     *
     * @param array
     * @return
     */
    public int[] sort2(int[] array) {
        //外层循环
        for (int i = 0; i < array.length; i++) {
            boolean isSort = false;
            //内层循环
            for (int j = 0; j < array.length - 1; j++) {
                //如果当前的值大于下个值，那么就需要交换
                if (array[j] > array[j + 1]) {
                    //用一个临时变量来存储值
                    int temp = array[j];
                    //交换
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = true;
                }
            }
            //经过一轮排序后，没有交换，可以认为已经有序，跳出循环
            if (!isSort) {
                break;
            }
        }
        return array;
    }

    /**
     * 如果数组存在一部分有序，会造成一些无意义的交换
     * 优化手段，记录最后一次元素交换的位置,那个位置就是无序区，再往后就是有序区
     * 测试用例：3 4 2 1 5 6 7 8
     * @param array
     * @return
     */
    public int[] sort3(int[] array) {
        int index = array.length;
        //外层循环
        for (int i = 0; i < index; i++) {
            boolean isSort = false;
            //内层循环
            for (int j = 0; j < index - 1; j++) {
                //如果当前的值大于下个值，那么就需要交换
                if (array[j] > array[j + 1]) {
                    //用一个临时变量来存储值
                    int temp = array[j];
                    //交换
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = true;
                    index = j + 1;
                }
            }
            //经过一轮排序后，没有交换，可以认为已经有序，跳出循环
            if (!isSort) {
                break;
            }
        }
        return array;
    }
}
