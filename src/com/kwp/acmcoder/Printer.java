package com.kwp.acmcoder;

public class Printer {

	public static void main(String[] args) {
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

		print(clockwisePrint(mat,3,3));
	}
	
	private static void print(int[] input) {
		for(int arr:input){
			System.out.print(arr+" ");
		}
		System.out.println();
	}
	
	
	public static int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
       
        int[] out = new int[n*m];
        
        int count = 0;
        int[][] mask = new int[n][m];
        int[] position = {0,0,0}; // state row col 三个参数
        while(count<n*m){
                out[count++] = mat[position[1]][position[2]];
            	mask[position[1]][position[2]] = 1;
				updatePosition(mask,position, n, m);
               
        }
        
        return out;
    }
    
    private static void updatePosition(int[][] mask,int[] position,int n,int m){
        // state 0 1 2 3  right down left up
    	int state = position[0];
        int row = position[1];
        int col = position[2];
        
        if(state==0 ){
            if(col+1<m && mask[row][col+1]==0){
                col ++;
            }else{
                row ++;
                state = 1;
            }
        }
        
        else if(state==1){
            if(row+1<n && mask[row+1][col]==0){
                row ++;
            }else{
                col --;
                state = 2;
            }
        }
        
        else if(state==2){
          if(col-1>=0 && mask[row][col-1]==0){
                col --;
            }else{
                row --;
                state = 3;
            } 
        }
        
        else{
            if(row-1>=0 && mask[row-1][col]==0){
                row --;
            }else{
                col ++;
                state = 0;
            }
        }
        position[0] = state;
        position[1] = row;
        position[2] = col;
        		
    }

}
