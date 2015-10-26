public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int i = 0;
        while(i < len){
            // if the A[i] == i + 1, or A[i] out of range, jump to next
            if(nums[i] <= 0 || nums[i] >= len || nums[i] == i + 1){
                i++;
            }
            // deal with duplicates ( nums[i] != i + 1 cant handle dups)
            else if(nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }else{
                i++;
            }
        }
        i = 0;
        while(i < len && nums[i] == i + 1){
            i++;
        }
        return i + 1;
    }
    
    private void swap(int[] nums, int a, int b){
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }
}