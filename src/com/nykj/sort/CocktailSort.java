package com.nykj.sort;

/**
 * @author chenlin
 */
public class CocktailSort implements Sort {

    /**
     * 鸡尾酒排序（钟摆）：冒泡排序的另一种优化
     * 时间复杂度：0（n²）
     * 空间复杂度：0(1)
     * 稳定排序
     * 测试用例 2,3,4,5,6,7,8,1
     * 需要维护两个有序区长度
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        /*
         交换的关键,使用绝对值的方式能够避免写很多重复代码
         使用算法细节：比如数组长度是8,那么i为0,经过排序后，无序区长度变为 7
         那么对应的就是从 0-7+1=6 开始遍历
         */
        int swapLoop = 0;
        //有序区1长度 从左往右算
        int orderedRegion1 = 0;
        //有序区2长度 从右往左算
        int orderedRegion2 = array.length;
        //当两个有序区的位置相同时，即循环停止点
        while (orderedRegion1 <= orderedRegion2) {
            boolean isSort = false;
            //内层循环
            for (int j = orderedRegion1; j < orderedRegion2 - 1; j++) {
                //如果当前的值大于下个值，那么就需要交换
                int comparedNum1 = array[Math.abs(j + swapLoop)];
                int comparedNum2 = array[Math.abs(j + swapLoop + 1)];
                boolean swapCondition = (swapLoop >= 0) ? comparedNum1 > comparedNum2
                        : comparedNum1 < comparedNum2;
                // 8 0 7 1 6
                if (swapCondition) {
                    //交换
                    array[Math.abs(j + swapLoop)] = comparedNum2;
                    array[Math.abs(j + 1 + swapLoop)] = comparedNum1;
                    isSort = true;
                }
            }
            //在这里更换
            if (swapLoop == 0) {
                //有序区2 长度-1
                orderedRegion2 -= 1;
                //索引位置要比长度少1，所以这里要+1
                swapLoop = -orderedRegion2 + 1;
            } else {
                swapLoop = 0;
                //有序区长度+1
                orderedRegion1 += 1;
            }
            //经过一轮排序后，没有交换，可以认为已经有序，跳出循环
            if (!isSort) { break; }
        }
        return array;
    }
}
