import java.util.ArrayList;

public class SubarraySum {
  /**
  * @param nums: A list of integers
  * @return: A list of integers includes the index of the first number 
  *          and the index of the last number
  */

  // notes: map the sum and the index, add 0 and -1 first, if the sum has been seen before,
  // which means the sum of the subarray bewtween those two same sum is 0. Get the index from
  // from the map and then return it.
  // (take LARGER space. TIME: O(n))
  public static ArrayList<Integer> subarraySum(int[] nums) {
    ArrayList<Integer> result = new ArrayList<Integer>();
      if(nums.length == 0 || nums == null){
        return result;
    }

    HashMap<Integer,Integer> counter = new HashMap<Integer,Integer>();
    counter.put(0,-1);
    int sum = 0 ;
    for (int i = 0; i < nums.length; i ++){
      sum += nums[i];
      if(counter.containsKey(sum)){
        result.add(counter.get(sum) + 1);
        result.add(i);
        break;// only take the first pair
      }else{
        counter.put(sum, i);
      }
    }
    return result;
  }

  public static void main(String [] args){
    int[] nums = {101,33,44,55,67,78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,100,200,1000,22};
    ArrayList<Integer> temp = subarraySum(nums);
    for(int i =0; i< temp.size(); i++){
    System.out.print(temp.get(i));
    }
  }
}