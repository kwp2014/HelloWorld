package com.kwp.acmcoder;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		String s = "aa";
		String p = ".*";
		System.out.println(isMatch(s,p));

	}

	
	/**
     *  s 待匹配的字符串
     *  p 匹配模式 从左到右，符号形式 + 符号连续次数
     * */
    public static boolean isMatch(String s, String p) {
        
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int sLength = sChar.length;
        int pLength = pChar.length;
        
        boolean isDot = false;
        boolean isStar = false;
        
        // 扫描数组pChar
        int pos = 0; //记录数组sChar当前判断的位置 
        int increase = 1; //or 2
        for(int i=0;i<pLength;i+=increase){
            if(pChar[i]=='.'){
                isDot = true;
            }
            if(i+1<pLength && pChar[i+1]=='*'){
                isStar = true;
                increase = 2;
            }else{
                increase = 1;
            }
            
            // 
            if(isDot && !isStar) {
                pos ++;  //?   aabdacfacd   .*acd
            }
            if(isDot && isStar) {
                continue;
            }
            if(!isDot && !isStar) {
                if(pos< sLength && pChar[i]==sChar[pos]){
                    pos ++;
                }else{
                    return false;
                }
            }
            if(!isDot && isStar) {
                while(pos <sLength){
                    if(pChar[i]==sChar[pos]){
                        pos ++;
                    }else{
                        break;
                    }
                }
            }
            
        }
        
        if(pos != sLength){
            return false;
        }
        
        return true;
        
        
    }
}
