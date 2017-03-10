package cn.tju.scs.wyh;

public class Triangle {
	public static int isTri(int a, int b, int c){
		int sum;
		double pow;
		int max = Math.max(a, b);
		max = Math.max(max, c);
		if(max == a){
			sum = b + c;
			pow = Math.pow(b, 2) + Math.pow(c, 2);
		}
		else if(max == b){
			sum = a + c;
			pow = Math.pow(a, 2) + Math.pow(c, 2);
		}
		else{
			sum = b + a;
			pow = Math.pow(b, 2) + Math.pow(a, 2);
		}
		
		if(Math.pow(max, 2) == pow){
			//直角三角形
			return 3;
		}
		else{
			if(max < sum){
				if(a==b && b==c){
					//等边三角形
					return 1;
				}
				
				if(a==b || b==c || a==c){
					//等腰三角形
					return 2;
				}
				else
					//斜边三角形
					return 0;
			}	
		}
		//不是三角形
		return -1;
	}
}
