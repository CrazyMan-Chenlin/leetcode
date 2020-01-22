package com.nykj.sort;

import java.util.Arrays;

/**
 * 调用测试类
 *
 * @author chenlin
 */
public class Main {
    /**
     * 手动输入数组
     *
     * @return
     */
    private static int[] manualInputArray() {
        return new int[]{30, 35, 27, 27, 33, 40, 39, 14, 13, 4};
    }

    public static void main(String[] args) {
        //采用随机生成数组来产生测试用例
        int n = 10;
        int rangeL = 0;
        int rangeR = 40;
        Sort sort = new CocktailSort();
        int[] array = manualInputArray();
        //手动测试用例
        if (array.length != 0) {
            System.out.println(Arrays.toString(sort.sort(array)));
        }
        //产生40个测试用例
        for (int i = 0; i < 10; i++) {
            // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
            }
            /*System.out.println("原数组：" + Arrays.toString(arr))*/;
            System.out.println("排序后：" + Arrays.toString(sort.sort(arr)));
        }
    }
}
