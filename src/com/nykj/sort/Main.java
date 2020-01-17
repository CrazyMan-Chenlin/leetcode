package com.nykj.sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 调用测试类
 * @author chenlin
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字，用逗号隔开");
        String arrStr = sc.next();
        //用逗号切割
        String[] arrSplit = arrStr.split(",");
        //构建新的int数组
        int[] arr = new int[arrSplit.length];
        for (int i = 0; i < arrSplit.length; i++) {
            arr[i] = Integer.parseInt(arrSplit[i]);
        }
        BubbleSort sort = new BubbleSort();
        System.out.println(Arrays.toString(sort.sort3(arr)));
        sc.close();
    }
}
