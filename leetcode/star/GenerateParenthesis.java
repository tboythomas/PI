public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<String>();
        if(n < 0){
        	return ans;
        }
        helper(ans, n , n, "");
        return ans;
    }

    // num of left pars is always >= num of right pars
    // if left > 0, we can still print left pars, when we print right pars, we have to check
    // both right > 0 and left < right
    private void helper(List<String> ans, int left, int right, String cur){
    	if(left == 0 && right == 0){
    		ans.add(cur);
    		return;
    	}
    	if(left > 0){
    		helper(ans, left - 1, right, cur + "(");
    	}
    	if(right > left){
    		helper(ans, left, right - 1, cur + ")");
    	}
    }
}