public class Threesum_closest {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */

    // note: just like 3 sum. take one num and then find the sum that is closest to target.
    // since every pair has only one solution, no needed to check duplicates
    // one more varible diff to keep track of the difference
    public static int threeSumClosest(int[] numbers ,int target) {
   		if(numbers == null){
   			return 0;
   		}
   		int sum = 0;
   		int diff = 999999999; // dummy value to get replaced
   		if(numbers.length < 2){
   			for(int temp: numbers){
   				sum += temp;
   			}
   		}else{
   			Arrays.sort(numbers);
   			for(int i = 0; i < numbers.length - 2; i ++){
          // skip the duplicates
   				if( i != 0 && numbers[i] == numbers[i - 1]){
   					continue;
   				}
   				int left = i + 1;
   				int right = numbers.length - 1;
   				while(left < right){
   					int count = numbers[i] + numbers[left] + numbers[right];
   					int temp = Math.abs(target - count);
   					if(target == count){
   						sum = target;
   						return sum;
   					}else if (count > target){
   						right--;
   					}else{
   						left++;
   					}
   					if(temp < diff){
   						diff = temp;
   						sum = count;
   					}
   				}
   			}
   		}
   		return sum;
    }
    
    public static void main(String[] args){
    	int[] r1 = {2,4,5,6,7,8};
    	int r = threeSumClosest(r1, 11);
    	System.out.print(r);
    }
}