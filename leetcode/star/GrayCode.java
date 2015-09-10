public class GrayCode{
	// Gray Code formula: G(i) = i ^(i / 2)
	// for n bits there will n * 2 numbers
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new LinkedList<Integer>();
        for(int i = 0; i < (1 << n); i ++){
        	ans.add(i ^ (i >> 1));
        }
        return ans;
    }
}