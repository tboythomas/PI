public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(nums == 0 || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<Integer>();
        helper(nums, res, cur, 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> cur, int pos){
        //add every current state
        res.add(new ArrayList(cur));
        
        for(int i = pos; i < nums.length; i++){
            cur.add(nums[i]);
            helper(nums, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    } 
}
