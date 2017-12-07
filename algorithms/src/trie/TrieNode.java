package trie;

public class TrieNode {
	  private TrieNode[] links;
	    private boolean isEnd;
	    private final int R = 26;
	    
	    public TrieNode() {
	        links = new TrieNode[R];
	    }
	    
	    public boolean containsKey(char ch){
	        return links[ch-'a']!=null;
	    }
	    
	    public TrieNode get(char ch){
	        return links[ch-'a'];
	    }
	    
	    public void set(char ch, TrieNode node){
	        links[ch-'a'] = node;
	    }
	    
	    public void setEndTrue(){
	        this.isEnd = true;
	    }
	    
	    public boolean isEnd(){
	        return isEnd;
	    }

	    
}
