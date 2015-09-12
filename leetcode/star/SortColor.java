// O(n + k). Sort an array with limited number. Counting Sort.
// k is the biggest number in the array(in this case, k is 2)

public class SortColor {
	// two pass solution:
	// first pass count the number of 0 and 1, then the second pass overwrite the nums
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int zero = 0;
        int one = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 0){
                zero++;
            }else if (nums[i] == 1){
                one++;
            }
        }
        for(int i = 0; i < nums.length; i ++){
            if(i < zero){
                nums[i] = 0;
            }else if (i < zero + one){
                nums[i] = 1;
            }else{
                nums[i] = 2;
            }
        }
    }

    // one pass algo. 
    // use two pointer, one to separate 0 and 1, all 0s go left on this counter. another one
    // to separate 1 and 2, all 2s go right on this counter.
    public void sortColors(int[] nums){
    	if(nums == null || nums.length < 2){
    		return ;
    	}
    	int len = nums.length;
    	// separate 0 and 1
    	int left = 0;
    	// separate 1 and 2
    	int right = len - 1;
    	for(int i = 0; i <= right; i++){
    		// swap and since there is one 0, we have to increament left
    		if(nums[i] == 0){
    			swap(nums, i, left);
    			left++;    			
    		}
    		// swap and since there is one 2, we have to 
    		// decreament both i and right(in case after swap nums[i] is still 2)
    		/*由于left记录第一个1的位置，因此A[left]与A[i]交换后，A[left]为0,A[i]为1，因此i++；
				而right记录第一个非2的位置，可能为0或1，因此A[right]与A[i]交换后，A[right]为2,
				A[i]为0或1，i不能前进，要后续判断
			*/
    		else if(nums[i] == 2){
    			swap(nums, i, right);
    			right --;
    			i --;
    		}
    	}
    }

    private void swap(int[] nums, int a, int b){
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
}