
public class D20161008N389FindtheDifference {
    public char findTheDifference(String s, String t) {
        int n = t.length();
        char result = t.charAt(n-1);
        for(int i = 0;i < s.length(); ++i){
        	result ^= s.charAt(i);
        	result ^= t.charAt(i);
        }
        return result;
    }
}
