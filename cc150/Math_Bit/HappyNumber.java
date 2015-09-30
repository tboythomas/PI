public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1){
        	int temp = 0;
        	int sum = 0;
        	while(n > 0){
        		temp = n % 10;
        		sum += temp * temp;
        		n = n / 10;
        	}
        	n = sum;
        	if(set.contains(n)){
        		return false;
        	}else{
        		set.add(n);
        	}
        }
        return true;
    }
}