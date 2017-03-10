package cn.tju.scs.wyh;

public class Triangle {
	public static int isTri(int a, int b, int c){
		int min_sum;
		double min_pow;
		int max = Math.max(a, b);
		max = Math.max(max, c);
		if(max == a){
			min_sum = b + c;
			min_pow = Math.pow(b, 2) + Math.pow(c, 2);
		}
		else if(max == b){
			min_sum = a + c;
			min_pow = Math.pow(a, 2) + Math.pow(c, 2);
		}
		else{
			min_sum = b + a;
			min_pow = Math.pow(b, 2) + Math.pow(a, 2);
		}
		
		if(Math.pow(max, 2) == min_pow){
			return 3;
		}
		else{
			if(max < min_sum){
				if(a==b && b==c){
					return 1;
				}
				
				if(a==b || b==c || a==c){
					return 2;
				}
				else
					return 0;
			}	
		}
		return -1;
	}
}
