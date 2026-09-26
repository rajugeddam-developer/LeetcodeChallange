import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        // Step 1: Map knowledge keys to their corresponding values
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;

        // Step 2: Iterate through the string s
        while (i < n) {
            char c = s.charAt(i);
            
            if (c == '(') {
                // Extract key inside brackets
                int start = i + 1;
                while (i < n && s.charAt(i) != ')') {
                    i++;
                }
                String key = s.substring(start, i);
                
                // Append mapped value or '?' if key is missing
                result.append(map.getOrDefault(key, "?"));
            } else {
                result.append(c);
            }
            i++;
        }

        return result.toString();
    }
}