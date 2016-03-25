/**
 * 
 */
package com.kwp.ds;

/**
 * @author Weiping
 *
 */
public class MyUnweightedGraph<V> extends MyAbstractGraph<V> {

	
	public MyUnweightedGraph(int[][] edges,V[] vertices){
		super(edges,vertices);
	}
	
	public MyUnweightedGraph(java.util.List<MyEdge> edges,java.util.List<V> vertices){
		super(edges,vertices);
	}
	
	public MyUnweightedGraph(java.util.List<MyEdge> edges,int numberOfVertices){
		super(edges,numberOfVertices);
	}
	public MyUnweightedGraph(int[][] edges,int numberOfVertices){
		super(edges,numberOfVertices);
	}
	
	
	
}
