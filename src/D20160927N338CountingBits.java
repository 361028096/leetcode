
public class D20160927N338CountingBits {
	public static void main(String args[]){
		Solution solution=new Solution();
		int[] bits = new int[9];
		bits=solution.countBits(8);
		for(int i=0;i<8;i++){
			System.out.println(bits[i]);
		}
	}
}

class Solution {
    public int[] countBits(int num) {
    	int[] bits = new int[num + 1];
    	for(int i=0;i <= num;i++){
    		if(i % 2 == 0){
    			bits[i] = bits[i / 2];
    		}else{
    			bits[i] = bits[i / 2] + 1;
    		}
    	}
    	return bits;
    }
}
