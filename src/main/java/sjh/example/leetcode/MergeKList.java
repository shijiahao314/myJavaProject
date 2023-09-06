package sjh.example.leetcode;

import java.util.*;

public class MergeKList {

    public static void main(String[] args) {
        class Solution {
              class ListNode {
                  int val;
                  ListNode next;
                  ListNode() {}
                  ListNode(int val) { this.val = val; }
                  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
              }
            public ListNode mergeKLists(ListNode[] lists) {
                PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode n1, ListNode n2) {
                        return n1.val - n2.val;
                    }
                });

                Map<Character, Integer> map = new HashMap<>();
                map.keySet();
                String a = "asd";


                return null;
            }
        }
    }
}
