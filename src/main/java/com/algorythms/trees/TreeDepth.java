package com.algorythms.trees;

import java.util.Random;

public class TreeDepth {
    static boolean lonely7Found = false;

    static class Node {
        int val;
        Node left,
                right;
        boolean is7;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        Random random = new Random();
        Node root =
                new Node(random.nextInt(10),
                        new Node(random.nextInt(10),
                                new Node(random.nextInt(10)),
                                new Node(random.nextInt(10), new Node(random.nextInt(10)), null)
                        ),
                        new Node(random.nextInt(10),
                                new Node(random.nextInt(10)),
                                new Node(random.nextInt(10), new Node(random.nextInt(10)),
                                        new Node(random.nextInt(10)))
                        )

                );

        int depth = maxDepth(root);
        System.out.println("IS LONELY SEVEN HERE??? " + lonely7Found);
        System.out.println("Depth = " + depth);
    }

    static int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.val == 7) {
            if (root.right == null && root.left == null) {
                lonely7Found = true;
            }
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }

}
