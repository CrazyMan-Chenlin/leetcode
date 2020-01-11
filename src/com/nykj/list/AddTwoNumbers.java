package com.nykj.list;

import java.util.Scanner;

/**
 * @author chenlin
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //由于不知道长度，所以使用死循环，等到有一方为空就跳出循环
        int preValue = 0;
        //存储值
        ListNode listNode = new ListNode(0);
        ListNode tempListNode = listNode;
        while (true) {
            int value;
            //加法计算
            if (l1 != null && l2 != null) {
                value = l2.val + l1.val;
                l1 = l1.next;
                l2 = l2.next;
            }else if (l1 == null) {
                value = l2.val;
                l2 = l2.next;
            }else {
                value = l1.val;
                l1 = l1.next;
            }
            //拿到进位值
            if (preValue != 0) {
                value += preValue;
                preValue = 0;
            }
            if (value > 9) {
                preValue = 1;
                value = value - 10;
            }
            //赋值
            listNode.val = value;
            if (l1 == null && l2 == null){
                if (preValue != 0 ){
                    listNode.next = new ListNode(preValue);
                }
                return tempListNode;
            }
            listNode.next = new ListNode(0);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode listNode1 = getListNode(sc);
        ListNode listNode2 = getListNode(sc);
        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        sc.close();
    }

    private static ListNode getListNode(Scanner sc) {
        System.out.println("请输入一个整数。。。");
        String num1 = sc.next();
        String[] num1Array = num1.split("");
        ListNode listNode = new ListNode(Integer.parseInt(num1Array[0]));
        //通过一个临时变量来指定节点1
        ListNode tempListNode = listNode;
        for (int i = 1; i < num1.length(); i++) {
            listNode.next = new ListNode(Integer.parseInt(num1Array[i]));
            listNode = listNode.next;
        }
        return tempListNode;
    }

}
