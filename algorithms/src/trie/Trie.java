package trie;

public class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
   
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode node = root;
        for(int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if(!node.containsKey(c)){
                node.set(c,new TrieNode());  
            }
            node = node.get(c);
        }
        node.setEndTrue();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return (node!=null) && (node.isEnd());
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return (node!=null);

    }
    
    public TrieNode searchPrefix(String word){
         TrieNode node = root;
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            if(node.containsKey(ch)){
                   node = node.get(ch);
            }
            else return null;
        }
        return node;
    }
}