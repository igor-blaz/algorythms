package com.algorythms.leetcode.addTwoSum;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Solution {
    private static final Logger log = LoggerFactory.getLogger(Solution.class);

    public static void main(String[] args) {
        log.info("Привет");
        ListNode node1 = new ListNode(1, new ListNode(9, new ListNode(8, new ListNode(5))));
        ListNode node2 = new ListNode(8, new ListNode(4, new ListNode(7)));
        ListNode result = addTwoNumbers(node1, node2);
        StringBuilder sb = new StringBuilder();

        while (result.next != null) {
            String valStr = Integer.toString(result.val);
            sb.append(valStr);
            result = result.next;
        }
        sb.append(result.val);
        String resultString = sb.reverse().toString();
        int resultInt = Integer.parseInt(resultString);
        System.out.println(resultInt);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(); // фиктивная голова
        ListNode tail = dummyHead;           // хвост результирующего списка
        int carry = 0;


        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;

            carry = sum / 10;
            int digit = sum % 10; //цифра которую мы вставили
            log.info("digit = {}", digit);
            tail.next = new ListNode(digit);
            tail = tail.next;

            // сдвиги по исходным спискам — только если не null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next; // пропускаем фиктивную голову
    }

}

