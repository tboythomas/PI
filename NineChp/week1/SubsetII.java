public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> cur = new ArrayList<Integer>();
        helper(res, cur, nums, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int pos){
        res.add(new ArrayList<Integer>(cur));
        for(int i = pos; i < nums.length; i ++){
            // i = pos, add cur number and skip duplicates
            if(i > pos && nums[i] != nums[i - 1]){
                continue;
            }else{
                cur.add(nums[i]);
                helper(res, cur, nums, i+1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
