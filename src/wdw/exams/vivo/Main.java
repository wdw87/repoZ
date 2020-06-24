package wdw.exams.vivo;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {

                // write your code here


            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // TODO output
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(n -- > 0){
            lines.add(sc.nextLine());
        }

        List<ListNode> heads = new ArrayList<>();
        for(String line : lines){
            ListNode tmpHead = new ListNode(0);
            ListNode p = tmpHead;
            String[] strs = line.split(" ");
            for(String str : strs){
                ListNode tmpNode = new ListNode(Integer.valueOf(str));
                p.next = tmpNode;
                p = p.next;
            }
            heads.add(tmpHead.next);
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

        for(ListNode head : heads){
            pq.offer(head);
        }

        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            System.out.print(tmp.val + " ");
            if(tmp.next != null){
                pq.offer(tmp.next);
            }
        }

        System.out.println();


    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


//    private static ListNode mergeNodes(ListNode head ) {
//
//        // write your code here
//
//    }


}