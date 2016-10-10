package com.kwp.acmcoder;

public class ReverseInteger {

	public static void main(String[] args) {
		int x = -2147483648;
		System.out.println(reverse(x));

	}

	public static int reverse(int x) {
		
		
		boolean sign = true; //正数
		long xx = x;
		if(x < 0){
			xx = -xx;
			int a = Integer.MIN_VALUE;
			int b = Integer.MAX_VALUE;
			sign = false;
		}


		if(xx<10){
			return (int) (sign? xx:-xx);
		}
		if(xx<100){
			return (int) (sign? xx/10 +(xx-(int)(xx/10)*10)*10:-(xx/10 +(xx-(int)(xx/10)*10)*10));
		}
		// 判断位数
		int digit = 3;
		for(int i=3;i<=12;i++){
			int a = (int) (xx/Math.pow(10, i));
			if(a==0){
				digit = i;
				break;
			}
		}
		
		long result = 0;
		for(int i=0;i<digit;i++){
			int a = (int) (xx/Math.pow(10, digit-i-1));
			result += a *Math.pow(10, i);
			xx -= a*Math.pow(10, digit-i-1);
			if(x==0){
				break;
			}
		}
		if(result >= Integer.MIN_VALUE && result <= Integer.MAX_VALUE){
		    return sign? (int)result:-(int)result;
		}
     
        else{
             return 0;
        }
        
    }
}
