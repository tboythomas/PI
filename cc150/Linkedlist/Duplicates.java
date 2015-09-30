public class Duplicates {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> counter = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i ++){
            if(counter.contains(nums[i])){
                return true;
            }else{
                counter.add(nums[i]);
            }
        }
        return false;
    }
}