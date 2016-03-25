/**
 * 定义图的基本操作
 * @author Weiping
 *
 * @param <V>
 */
package com.kwp.ds;

public interface MyGraph<V> {
	
	/**
	 * 返回图中顶点的数目
	 */
	public int getSize();
	
	/**
	 * 返回所有的顶点
	 */
	public java.util.List<V> getVertices();
	
	/**
	 * return the object of the specified vertex index
	 * @param index
	 * @return
	 */
	public V getVertex(int index);
	
	/**
	 * return the index of the specified vertex object
	 */
	public int getIndex(V v);
	
	/**
	 * Return the neighbors of vertex with the specified index
	 * @param index
	 * @return
	 */
	public java.util.List<Integer> getNeighbors(int index);
	
	/**
	 * Return the degree for a specified vertex
	 * @param v
	 * @return
	 */
	public int getDegree(int v);
	
	/**
	 * Return the adjacency matrix
	 * @return
	 */
	public int[][] getAdjacencyMatrix();
	
	/**
	 * Print the adjacency matrix
	 */
	public void printAdjacencyMatrix();
	
	/**
	 * Print the edges
	 */
	public void printEdges();
	
	/** 
	 * Obtain a depth-first search tree
	 * @param v
	 * @return
	 */
	public MyAbstractGraph<V>.Tree dfs(int v);
	
	/**
	 * Obtain a breadth-first search tree
	 * @param v
	 * @return
	 */
	public MyAbstractGraph<V>.Tree bfs(int v);
}
