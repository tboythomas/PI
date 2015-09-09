public class WordSearchII {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
// note: build up a trie node first, then build up a trie with insert, searchword and start with prefix
// since this time, have to add every word into the list, dfs will cuz TLE, so we have to check if the word
// is in the trie first(check every word in the list will also cuz TLE), use a boolean [][] to save the visited
// char and then perfrom a dfs,(if no words start with prefix also returns, then add the word, dfs, remark the vistied
// pos at the end)

    Set<String> result = new HashSet<String>();

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
};

class Trie{
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
            // go to next level
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
};
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        Trie counter = new Trie();
        for(String word: words){
            counter.insert(word);
        }
        int len = board.length;
        int wid = board[0].length;
        boolean[][] visited = new boolean[len][wid];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < wid; j++){
                dfs(visited, counter, "", board,i,j);
            }
        }
        return new ArrayList<String>(result);
    }

    private void dfs(boolean[][] visited, Trie counter, String word, char[][] board, int x, int y){
        if(x < 0 || x >= board.length|| y < 0 || y >= board[0].length){
            return;
        }
        if(visited[x][y]){
            return;
        }
        word += board[x][y];
        if(!counter.startWithPrefix(word)){
            return;
        }
        if(counter.search(word)){
            result.add(word);
        }
        visited[x][y] = true;
        dfs(visited, counter, word, board, x, y - 1);
        dfs(visited, counter, word, board, x, y + 1);
        dfs(visited, counter, word, board, x + 1, y);
        dfs(visited, counter, word, board, x - 1, y);
        visited[x][y] = false;
    }
}


