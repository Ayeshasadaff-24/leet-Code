import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        // Track the minimum frequency of each character ('a' - 'z')
        int[] minFreq = new int[26];
        
        // Initialize frequency count with the first word
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }
        
        // Update frequencies with the rest of the words
        for (int i = 1; i < words.length; i++) {
            int[] charCount = new int[26];
            for (char c : words[i].toCharArray()) {
                charCount[c - 'a']++;
            }
            
            // Keep the minimum frequency found across all words
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], charCount[j]);
            }
        }
        
        // Build the result list
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }
        
        return result;
    }
}
