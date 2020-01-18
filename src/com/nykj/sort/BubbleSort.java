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
     * 优化思路：不断缩小无序区长度,不用每次都去遍历整个数组的长度
     * 测试用例：3 4 2 1 5 6 7 8
     * @param array
     * @return
     */
    public int[] sort3(int[] array) {
        int index = array.length;
        //外层循环,大于1代表无序区的长度为1时，即排序完成
        while (index > 1 ){
            boolean isSort = false;
            int len = index;
            //内层循环
            for (int j = 0; j < len - 1; j++) {
                //如果当前的值大于下个值，那么就需要交换
                if (array[j] > array[j + 1]) {
                    //用一个临时变量来存储值
                    int temp = array[j];
                    //交换
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSort = true;
                    /*
                    index 代表无序区的长度
                    比如测试用例中最后交换的位置是4,无序区长度是2
                    而这个时候j为2，所以要让 index = 2
                     */
                    index = j + 2;
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
