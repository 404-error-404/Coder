package leetcode.SoByNumber;

import java.util.List;

public class So139 {
    public boolean wordBreak(String s, List<String> wordDict) {
    	if(s.length() == 0) {
    		return true;
    	}
    	for(String word: wordDict) {
    		if (word.length() <= s.length() && s.substring(0, word.length()).equals(word)) {
				if (wordBreak(s.substring(word.length()), wordDict)) {
					return true;
				}
			}
    	}
        return false;
    }
}
