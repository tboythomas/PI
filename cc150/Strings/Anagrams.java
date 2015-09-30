public class Anagrams{
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */

    // compart the sorted string to determine if two strings are anagrams or not.
    // use hashmap to store the anagram words, key is the sorted string, value is the 
    // list of words that are anagrams.
   public List<String> anagrams(String[] strs) {
  		if(strs == null || strs.length < 2){
  			return null;
  		}
  		HashMap<String, ArrayList<String>> result = new HashMap();

  		for(String str: strs){
  			char[] temp = str.toCharArray();
  			Arrays.sort(temp);
  			String key = String.copyValueOf(temp);
  			if(!result.containsKey(key)){
  				result.put(key, new ArrayList<String>());
  			}
  			ArrayList a1 = result.get(key);
  			a1.add(str);
  		}

  		ArrayList<String> list = new ArrayList();
  		for(String str: result.keySet()){
  			if(result.get(str).size() > 1){
  				list.addAll(result.get(str));
  			}
  		}
  		return list;
    }
}
