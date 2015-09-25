// for any string that has palindormed permutations(char in that strings must appeared even times and one char could appear once)
public class Permutation Palindorme{
	public boolean Palindorme(String s){
		if(s.length() == 0){
			return true;
		}
		HashMap<Character, boolean> map = new HashMap<Character, boolean>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(!map.containsKey(c)){
				map.put(c, true);
			}else{
				map.put(c, !map.get(c));
			}
		}
		boolean res = false;
		for(char c: map.keySet()){
			boolean temp = map.get(c);
			// the odd val (can only appear once since there can be only one middle char)
			if(temp){
				// if it has appeared before
				if(res){
					return false;
				}
				// mark the counter to be true if the middle char has been checked
				else{
					res = true;
				}
			}
		}
		return true;
	}
}