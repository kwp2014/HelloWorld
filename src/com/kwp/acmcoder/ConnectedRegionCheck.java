package com.kwp.acmcoder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ConnectedRegionCheck {

	public static void main(String[] args) throws IOException {
//		int[][] grid = {{1,1,0,0,0},{0,0,0,0,0},{0,0,1,1,1},{0,0,1,1,0},{1,0,0,0,0}};
		int [][] grid = gridGenerate(4);
		System.out.println("连通区域个数：" + regionCount(grid));
		print(grid);// 打印二值图像
		System.in.read();

	}
	 
	/**
	 * 随机产生二值图像
	 * @param n  n*n
	 * @return 返回二值数组
	 */
	private static int[][] gridGenerate(int n){
		int [][] grid = new int[n][n];
		Random rand = new Random(); 
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(rand.nextFloat() < 0.6){
					grid[i][j] = 0;
				}else{
					grid[i][j] = 1;
				}
			}
		}
		
		return grid;
	}
	
	private static void print(int[][] grid){
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				System.out.print(grid[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	private static int regionCount(int[][] grid) {
		int [][] image = expand(grid);
		int [][] isMarked = new int[image.length][image[0].length];
		int mark = 0;
		for(int i=0;i<image.length;i++){
			for(int j=0;j<image[0].length;j++){
				if(image[i][j]==0){
					continue;
				}
				if(image[i][j]==1 && isMarked[i][j] != 0){
					continue;
				}
				mark++;
				mark(mark, i, j, image, isMarked);
			}
		}
		
		print(isMarked);
		return mark;
	}
	
	/**
	 * 扩展图像 各边增长1个单位
	 * @param grid
	 * @return
	 */
	private static int[][] expand(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int [][] image = new int[row+2][col+2];
		for(int i=0;i<row+2;i++){
			for(int j=0;j<col+2;j++){
				if(i==0 || j==0 || i==row+1 || j == col+1){
					image[i][j] = 0;
				}else{
					image[i][j] = grid[i-1][j-1];
				}
				
			}
		}
		return image;
	}

	/** 
	 * 检测连通区域并标记
	 * @param tag 当前连通区域的标记
	 * @param row  当前行位置
	 * @param col  当前列位置
	 * @param isMarked  标记二值矩阵
	 * @return
	 */
	private static void mark(int tag,int row,int col,int[][] image,int[][] isMarked){
		
		if(image[row][col]==0 || isMarked[row][col] == 1){
			return;
		}
		
		isMarked[row][col] = tag;
		
		// left
		if(image[row][col-1]==1 && isMarked[row][col-1]==0){
			mark( tag, row, col-1,image, isMarked);
		}
		// right
		if(image[row][col+1]==1 && isMarked[row][col+1]==0){
			mark( tag, row, col+1,image, isMarked);
		}
		//up
		if(image[row-1][col]==1 && isMarked[row-1][col]==0){
			mark( tag, row-1, col,image, isMarked);
		}
		// down
		if(image[row+1][col]==1 && isMarked[row+1][col]==0){
			mark( tag, row+1, col,image, isMarked);
		}
		
		return;
	}

	
}
