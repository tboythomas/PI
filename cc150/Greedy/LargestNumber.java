public class LargestNumber{
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */

    // note: practice with Java comparator and Arrays.sort function.
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "0";
        }
        String result = "";
        int len = nums.length;
        String[] counter = new String[len];
        for(int i = 0; i < nums.length; i ++){
            counter[i] = String.valueOf(nums[i]);
        }
        // sort the array, compare every two number
        Arrays.sort(counter,new Cmp());
        //generate the new string
        for(String temp : counter){
            result += temp;
        }
        //corner case, 09, 08 etc..
        int i = 0;
        while( i < len && Integer.parseInt(counter[i]) == 0){
            i++;
        }
        if(i == len){
            return "0";
        }
        return result.substring(i);
    }

class Cmp implements Comparator<String>{

    // if a is greater than b, return positive int
    public int compare(String a, String b){
        return (b+a).compareTo(a+b) ;
    }
}