public class ExcelColtoNumber {
    public static int titleToNumber(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }else{
            double ans = 0;
            int len = s.length();
            for(int i = 0; i < len; i ++){
                char c = s.toLowerCase().charAt(i);
                int temp = c - 'a';
                ans += Math.pow(26,len - 1 - i)*(temp + 1);
            }
            return (int)ans;
        }
    }
    public static void main(String[] args){
      String t = "AAA";
      System.out.print(titleToNumber(t));
    }
}