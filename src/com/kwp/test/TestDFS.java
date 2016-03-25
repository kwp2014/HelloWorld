/**
 * 
 */
package com.kwp.test;

import com.kwp.ds.*;
/**
 * @author Weiping
 *
 */
public class TestDFS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] vertices = {
				"Se","Sa","Lo","De","Ka","Ch","Bo","Ne","At","Mi","Da","Ho"
		};
		int[][] edges = {
				{0,1},{0,3},{0,5},
				{1,0},{1,2},{1,3},
				{2,1},{2,3},{2,4},{2,10},
				{3,0},{3,1},{3,2},{3,4},{3,5},
				{4,2},{4,3},{4,5},{4,7},{4,8},{4,10},
				{5,0},{5,3},{5,4},{5,6},{5,7},
				{6,5},{6,7},
				{7,4},{7,5},{7,6},{7,8},
				{8,4},{8,7},{8,9},{8,10},{8,11},
				{9,8},{9,11},
				{10,2},{10,4},{10,8},{10,11},
				{11,8},{11,9},{11,10}
		};
		MyGraph<String> graph = new MyUnweightedGraph<String>(edges,vertices);
		
		MyAbstractGraph<String>.Tree dfs = graph.dfs(5);
		java.util.List<Integer> searchOrders = dfs.getSearchOrders();
		for(int i=0;i<searchOrders.size();i++){
			System.out.print(graph.getVertex(searchOrders.get(i))+ " ");
		}
		System.out.println();
		
	}

}
