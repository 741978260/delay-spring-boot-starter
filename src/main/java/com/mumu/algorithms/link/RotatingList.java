package com.mumu.algorithms.link;

/**
 * @Description 旋转链表
 * @Author Created by Mumu
 * @Date on 2020/10/30
 */
public class RotatingList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        listNode.next = node2;
        node2.next = node3;
        node3.next = null;

        final ListNode result = rotatingListNode(listNode, 2);
        System.out.println(result);
    }

    public static ListNode rotatingListNode(ListNode head, int k) {
        if (head == null || k < 0) return null;
        //计算链表数目并使链表成环
        ListNode p = head;
        int length = 1;
        while (p.next != null) {
            length++;
            p = p.next;
        }

        k = k % length;
        if (k == 0) return head;
        p.next = head;

        //p前进length-k步即得起始结点
        p = head;
        int num = length - k - 1;
        while (num != 0) {
            p = p.next;
            num--;
        }
        ListNode newhead = p.next;
        p.next = null;

        return newhead;
    }


    static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

}
