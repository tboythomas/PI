class Strstr{
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */

    //compare the first char of target to source, then substring the source and compare the substring with target.
    public int strStr(String source, String target) {
        if(source == null ||target == null||target.length() > source.length()){
            return -1;
        }
        if(target.length() == 0){
            return 0;
        }
        int len = target.length();
        for(int i = 0; i< source.length();i++){
            if(source.charAt(i) == target.charAt(0)){
                String temp = source.substring(i, i + len);
                if(temp.equals(target)){
                    return i;
                }
            }
        }
        return -1;
    }
}