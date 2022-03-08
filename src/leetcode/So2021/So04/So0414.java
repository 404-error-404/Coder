package leetcode.So2021.So04;

import java.util.HashMap;
import java.util.Map;

class Trie {
	// 当前结点的字符
	Character val = null;
	// 当前结点的后续字符
	Map<Character, Trie> trieMap = new HashMap<>();
	// 标记到当前节点是否为单词的末字符
	boolean endWord = false;
	
    /** Initialize your data structure here. */
    public Trie() {

    }
    
    public Trie(Character c) {
    	val = c;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	Trie pTrie = this;
    	int len = word.length();
    	for(int i = 0; i < len; i++) {
    		char cWord = word.charAt(i);
    		if(!pTrie.trieMap.containsKey(cWord)) {
    			pTrie.trieMap.put(cWord, new Trie(cWord));
    		}
    		pTrie = pTrie.trieMap.get(cWord); 
    	}
    	pTrie.endWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie pTrie = this;
    	int len = word.length();
    	for(int i = 0; i < len; i++) {
    		char cWord = word.charAt(i);
    		if(pTrie.trieMap.containsKey(cWord)) {
    			pTrie = pTrie.trieMap.get(cWord);
    		}
    		else {
    			return false;
    		}
    	}
    	return pTrie.endWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie pTrie = this;
    	int len = prefix.length();
    	for(int i = 0; i < len; i++) {
    		char cWord = prefix.charAt(i);
    		if(pTrie.trieMap.containsKey(cWord)) {
    			pTrie = pTrie.trieMap.get(cWord);
    		}
    		else {
    			return false;
    		}
    	}
    	return true;
    }
}

public class So0414 {
	static Trie trie = new Trie();
	public static void main(String[] args) {
		trie.insert("word");
		trie.search("word");
		trie.search("word2");
		trie.startsWith("wor");
	}
}
