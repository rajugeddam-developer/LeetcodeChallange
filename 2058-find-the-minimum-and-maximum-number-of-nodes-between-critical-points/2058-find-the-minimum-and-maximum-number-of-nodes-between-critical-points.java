class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;
        
        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        int currentIndex = 1; // 0-indexed: head is 0, head.next is 1

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            // Check if current node is a local maxima or minima
            if ((curr.val > prev.val && curr.val > nextNode.val) || 
                (curr.val < prev.val && curr.val < nextNode.val)) {
                
                if (firstCritical == -1) {
                    firstCritical = currentIndex;
                } else {
                    minDistance = Math.min(minDistance, currentIndex - lastCritical);
                }
                lastCritical = currentIndex;
            }

            prev = curr;
            curr = nextNode;
            currentIndex++;
        }

        // If less than 2 critical points were found
        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, lastCritical - firstCritical};
    }
}

