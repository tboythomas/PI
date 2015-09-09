import java.util.*;

class Node{
	// val of node
	char c;
	// store the children of current node
	HashMap<Character, Node> children;
	// check if there is a word at current level
	boolean hasWord;

	public Node(){
      this(' ');
	}
	public Node(char c){
		this.c = c;
      children = new HashMap<Character, Node>();
		hasWord = false;
	}
}

public class Trie{
	private Node root;

	public Trie(){
		root = new Node();
	}

	// think this dt as a tree, but every level is a hashmap.
	public void insert(String word){
		Node current = root;
		HashMap<Character, Node> curChildren = root.children;
		for(int i = 0; i < word.length(); i ++){
			char current_char = word.charAt(i);
			if(curChildren.containsKey(current_char)){
				current = curChildren.get(current_char);
			}else{
				Node temp = new Node(current_char);
				curChildren.put(current_char, temp);
				current = temp;
			}
			//go to next level
			curChildren = current.children;
			// mark the lowest node, hasWord is true
			if(i == word.length() - 1){
				current.hasWord = true;
			}
		}
	}

	public boolean search(String word){
		Node bottom_node = searchPos(word);
		if(bottom_node != null){
			return bottom_node.hasWord;
		}else{
			return false;
		}
	}

	// return the lowest level node
	public Node searchPos(String word){
		HashMap<Character, Node> curChildren = root.children;
		Node current = null;
		for(int i = 0; i < word.length(); i++){
			char current_char = word.charAt(i);
			if(curChildren.containsKey(current_char)){
				current = curChildren.get(current_char);
				curChildren = current.children;
			}else{
				return null;
			}
		}
		return current;
	}

	public boolean startWithPrefix(String prefix){
		HashMap<Character, Node> curChildren = root.children;
		Node current = null;
		for(int i = 0; i < prefix.length(); i ++){
			char temp = prefix.charAt(i);
			if(curChildren.containsKey(temp)){
				current = curChildren.get(temp);
				curChildren = current.children;
			}else{
				return false;
			}
		}
		return true;
	}	
}