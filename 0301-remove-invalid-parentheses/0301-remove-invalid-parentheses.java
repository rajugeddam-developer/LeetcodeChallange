import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null) return res;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> levelRes = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                
                // If the current string is valid, add it to the level results
                if (isValid(curr)) {
                    levelRes.add(curr);
                    found = true;
                }

                // If we haven't found a valid string yet, generate next states by removing one parenthesis
                if (!found) {
                    for (int j = 0; j < curr.length(); j++) {
                        char c = curr.charAt(j);
                        if (c != '(' && c != ')') continue;

                        String next = curr.substring(0, j) + curr.substring(j + 1);
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }

            // If we found valid strings at this depth, return them
            if (found) {
                res.addAll(levelRes);
                return res;
            }
        }

        return res;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}