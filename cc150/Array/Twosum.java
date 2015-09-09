public class 2sum {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */

    //notes:
    // Burtal Force: use 2 for loops to examine every pairs, when the result == target, return the results
    // use a hashmap to store the previous dif, O(n)
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null){
            return numbers;
        }
        
        HashMap<Integer,Integer> result = new HashMap<Integer,Integer>();
        int[] counter = new int[2];
        for(int i =0; i < numbers.length; i++){
            if(result.containsKey(numbers[i])){
                counter[0] = result.get(numbers[i]) + 1;
                counter[1] = i + 1;
                break;
            }else{
                result.put(target - numbers[i], i);
            }
        }
        return counter;
    }
}
