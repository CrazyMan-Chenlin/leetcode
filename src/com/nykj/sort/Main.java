package com.nykj.sort;

import java.util.Arrays;

/**
 * 调用测试类
 *
 * @author chenlin
 */
public class Main {

    public static void main(String[] args) {
        //采用随机生成数组来产生测试用例
        int n = 10;
        int rangeL = 0;
        int rangeR = 40;
        //产生40个测试用例
        for (int i = 0; i < 20; i++) {
        // 生成有n个元素的随机数组,每个元素的随机范围为[rangeL, rangeR]
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = (int) (Math.random() * (rangeR - rangeL + 1) + rangeL);
            }
            Sort sort = new CocktailSort();
            System.out.println(Arrays.toString(sort.sort(arr)));
        }

    }
}
