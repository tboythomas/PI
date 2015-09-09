public class WordLadder{
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */

    // Think this problem as BFS. for one word, the word that has one char different from it is its neighbor
    // first add the root(start), then from the start, start to traversal the set, from length=1, for each word,
    // use two for loops to change every char on every index(O(26 * n)), then if the word is the end, return length + 1
    // else if it is in the set, remove it from the set and add it into the queue. After finish traversaling
    // this level, update the length++, and then go to next level.
    public int ladderLength(String start, String end, Set<String> dict) {
    	if(start.equals(end) || start == null || end == null || dict == null || dict.size() == 0){
    		return 0;
    	}
    	// perform a bfs
    	Queue<String> counter = new LinkedList<String>();
    	counter.offer(start);
    	dict.remove(start);
    	int len = 1;
    	while(!counter.isEmpty()){
    		int size = counter.size();
    		for(int i = 0; i < size; i++){
    			String word = counter.poll();
    			//compare every possible combination
    			for(int j = 0; j < word.length(); j++){
    				for(char c = 'a'; c <= 'z'; c++){
    					// (optional) skip itself
    					//if(c == word.charAt(j)){
    					//	continue;
    					//}
    					String temp = change_word(word, j, c);
    					// if transformation is over
    					if(temp.equals(end)){
    						return len + 1;
    					}
    					//if it is a word in the dic
    					if(dict.contains(temp)){
    						counter.offer(temp);
    						dict.remove(temp);
    					}
    				}
    			}
    		}
			len++;
    	}
    	return len;
    }


    // change one char for each word
    private String change_word(String word, int index, char c){
    	char[] temp = word.toCharArray();
    	temp[index] = c;
    	return String.valueOf(temp);
    }
}
