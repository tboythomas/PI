public class WordLadderII {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
     public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(start == null || end == null || dict == null || start.equals(end)){
          return result;
        }
        HashMap<String,Integer> counter = new HashMap<String, Integer>();
        HashMap<String, List<String>> neighbor = 
        new HashMap<String, List<String>>();
        dict.add(start);
        dict.add(end);
        // count the deepth for each word
        bfs(counter, neighbor, start, dict);
        // search for the result
        ArrayList<String> path = new ArrayList<String>();
        // start from the back to search path
        dfs(counter, neighbor, end, start, dict, result, path);
        return result;

    }

    private void bfs(HashMap<String,Integer> counter, HashMap<String, List<String>> neighbor, 
      String start, Set<String> dict){
      Queue<String> q = new LinkedList<String>();
      q.offer(start);
      counter.put(start, 0);
      // construct a list of neighbor for each word 
      for(String word: dict){
        neighbor.put(word, new ArrayList<String>());
      }
      // put the neighbor into the list and count the deepth
      while(!q.isEmpty()){
        String head = q.poll();
        // find the neighor of the word
        List<String> temp = find_neighbor(head, dict);
        // for every neighor, count the deepth and add into the neighbor list.
        for(String next: temp){
          neighbor.get(next).add(head);
          if(!counter.containsKey(next)){
            counter.put(next, counter.get(head) + 1);
            q.offer(next);
          }
        }
      }
    }

    // start dfs from back. makr the end string as root and start to search
    private void dfs(HashMap<String,Integer> counter, HashMap<String, List<String>> neighbor, 
      String start, String end, Set<String> dict, List<List<String>> result, ArrayList<String> path){
      // add current word
      path.add(start);
      // if the path is complete, add the reversed path into result
      if(start.equals(end)){
        Collections.reverse(path);
        result.add(new ArrayList<String>(path));
        Collections.reverse(path);
      }
      else{
        // for every neighbor of current word (1 deepth above), dfs search.
        for(String temp: neighbor.get(start)){
          if(counter.containsKey(temp) && counter.get(start) == counter.get(temp) + 1){
            dfs(counter,neighbor, temp,end, dict, result,path);            
          }
        }
      }
      // back tracking.
      path.remove(path.size() - 1);
    }

    // return all neighbor of a word. ('hit' is a neighbor of 'hot')
    private List<String> find_neighbor(String temp, Set<String> dict){
      List<String> result = new ArrayList<String>();
      for(int i = 0; i < temp.length(); i ++){
        for(char c = 'a'; c <= 'z'; c++){
          if(c == temp.charAt(i)){
            continue;
          }
          String word = replace(temp, c, i);
          if(dict.contains(word)){
            result.add(word);
          }
        }
      }
      return result;
    }


    private String replace(String word, char c, int index){
      char[] temp = word.toCharArray();
      temp[index] = c;
      return String.valueOf(temp);
    }
}
