package com.kwp.acmcoder;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(convert(s,numRows));
	}
	
	public static String convert(String s, int numRows) {
		 int length = s.length();
		 if(length <= numRows ||numRows ==1){
	            return s;
	        }
	        char[] str = s.toCharArray();
	        String result = "";
	 
	        // 依次对应的行号 0123210123210123210...
	        // 第n个0的索引号为： 0 + (2*numRows-2)*(n-1)
	        //  n  1              0 + (2*numRows-2)*(n-1) +- distance   distance = 1
	        
	        for(int num=0;num < numRows;num++){//对应行号
	        	int currIndex1 = 0;
	        	int currIndex2 = 0;
	        	int n = 1; // 标记

	            	if(num == 0 || num== numRows-1){
	            		do{
	            			currIndex1 = num + (2*numRows-2)*(n-1);
		            		if(0<=currIndex1 && currIndex1< length){
		            			result += str[currIndex1];
		            		}
		            		n++;
	            		}while(currIndex1 < length);
	            		
	            	}else{
	            		do{
	            			currIndex1 = 0 + (2*numRows-2)*(n-1)-num;
			                currIndex2 = 0 + (2*numRows-2)*(n-1)+num;
			                if(0<=currIndex1 && currIndex1< length){
			                    result += str[currIndex1];
			                }
			                if(num!=0 && currIndex2< length){
			                    result += str[currIndex2];
			                }
			                n ++;
	            		}while(currIndex1 < length || currIndex2 < length);
	            		
	            	}

	            }
	                
	        
	        
	        return result;
    }
	



}
