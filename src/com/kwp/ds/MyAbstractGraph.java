/**
 * AbstractGraph类的部分
 */
package com.kwp.ds;

import java.util.*;
/**
 * @author Weiping
 *
 */
public abstract class MyAbstractGraph<V> implements MyGraph<V> {
	
	// --- 数据结构定义! ---
	protected List<V> vertices; // Store vertices
	protected List<List<Integer>> neighbors; // Store neighbors;
	
	// --- 构造函数定义 ---
	/**
	 * Construct a graph from edges and vertices stored in arrays
	 * @param edges  N行2列  每一行代表一条边
	 * @param vertices
	 */
	protected MyAbstractGraph(int[][] edges,V[] vertices){
		this.vertices = new ArrayList<V>();
		for(int i=0;i<vertices.length;i++){
			this.vertices.add(vertices[i]);
		}
		createAdjacencyLists(edges,vertices.length);
	}

	/**
	 * Construct a graph from edges and vertices stored in List
	 * @param edges
	 * @param vertices
	 */
	protected MyAbstractGraph(List<MyEdge> edges,List<V> vertices){
		this.vertices = vertices;
		createAdjacencyLists(edges,vertices.size());
	}
	/**
	 * only know the number of vertices and construct a graph
	 * @param edges
	 * @param numOfVertices
	 */
	@SuppressWarnings("unchecked")
	protected MyAbstractGraph(List<MyEdge> edges,int numOfVertices){
		vertices = new ArrayList<V>();
		for(int i=0;i<numOfVertices;i++){
			vertices.add((V)(new Integer(i)));
		}
		createAdjacencyLists(edges,numOfVertices);
	}
	
	@SuppressWarnings("unchecked")
	protected MyAbstractGraph(int[][]edges,int numOfVertices){
		vertices = new ArrayList<V>();
		for(int i=0;i<numOfVertices;i++){
			vertices.add((V)(new Integer(i)));
		}
		createAdjacencyLists(edges,numOfVertices);
	}
	
	/**
	 * Create adjacency lists for each vertex  邻接表创建
	 * @param edges
	 * @param numOfVertices
	 */
	private void createAdjacencyLists(int[][] edges, int numOfVertices) {
		neighbors = new ArrayList<List<Integer>>();
		for(int i=0;i<numOfVertices;i++){
			neighbors.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<edges.length;i++){
			int u = edges[i][0];
			int v = edges[i][1];
			neighbors.get(u).add(v);
		}
		
	}
	
	/**
	 * 
	 * @param edges
	 * @param numOfVertices
	 */
	private void createAdjacencyLists(List<MyEdge> edges, int numOfVertices) {
		neighbors = new ArrayList<List<Integer>>();
		for(int i=0;i<numOfVertices;i++){
			neighbors.add(new ArrayList<Integer>());
		}
		
		for(MyEdge edge:edges){
			neighbors.get(edge.u).add(edge.v);
		}
		
	}

	public int getSize(){
		return vertices.size();
	}
	
	public List<V> getVertices(){
		return vertices;
	}
	
	public V getVertex(int index){
		return vertices.get(index);
	}
		
	public int getIndex(V v){
		return vertices.indexOf(v);
	}
	
	public java.util.List<Integer> getNeighbors(int index){
		return neighbors.get(index);
	}
	
	/**
	 * Return the degree for a specified vertex
	 * @param v
	 * @return
	 */
	public int getDegree(int v){
		return neighbors.get(v).size();
	}
	
	/**
	 * Return the adjacency matrix
	 * @return
	 */
	public int[][] getAdjacencyMatrix(){
		int[][] adjacencyMatrix = new int[getSize()][getSize()];
		for(int i=0;i<neighbors.size();i++){
			for(int j=0;j<neighbors.get(i).size();j++){
				int v = neighbors.get(i).get(j);
				adjacencyMatrix[i][v] = 1; 
			}
		}
		
		return adjacencyMatrix;
	}
	
	/**
	 * Print the adjacency matrix
	 */
	public void printAdjacencyMatrix(){
		int[][] adjacencyMatrix = getAdjacencyMatrix();
		for(int i=0;i<adjacencyMatrix.length;i++){
			for(int j=0;j<adjacencyMatrix[0].length;j++){
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Print the edges
	 */
	public void printEdges(){
		for(int u=0;u<neighbors.size();u++){
			System.out.print("Vertex "+ u + ": ");
			for(int v=0;v<neighbors.get(u).size();u++){
				System.out.print("("+ u + "," + neighbors.get(u).get(v) + ")");
			}
			System.out.println();
		}
	}
	
	
	public static class MyEdge {
		int u;
		int v;
		
		public MyEdge(int u,int v){
			this.u = u;
			this.v = v;
		}
	}
	
	/**
	 * Obtain a DFS tree starting from vertex v
	 */
	public Tree dfs(int v){
		List<Integer> searchOrders = new ArrayList<Integer>();
		int[] parent = new int[vertices.size()];
		for(int i=0;i<parent.length;i++){
			parent[i] = -1; // Initialize parent[i] to -1
		}
		boolean[] isVisited = new boolean[vertices.size()];
		
		//Recursively search
		dfs(v,parent,searchOrders,isVisited);
		
		return new Tree(v,parent,searchOrders);
	}
	
	private void dfs(int v, int[] parent, List<Integer> searchOrders, boolean[] isVisited) {
		searchOrders.add(v);
		isVisited[v] = true;
		
		for(int i: neighbors.get(v)){
			if(!isVisited[i]){ //深入下一层搜索之前，先记录当前点的父节点
				parent[i] = v;
				dfs(i,parent,searchOrders,isVisited);
			}
		}
	}

	/**
	 * Obtain a DFS tree starting from vertex v
	 * 用队列实现：先进先出,依次访问
	 */
	public Tree bfs(int v){
		List<Integer> searchOrders = new ArrayList<Integer>();
		int[] parent = new int[vertices.size()];
		for(int i=0;i<parent.length;i++){
			parent[i] = -1; // Initialize parent[i] to -1
		}
		
		// Create an empty queue for storing vertices to be visited
		java.util.LinkedList<Integer> queue = new java.util.LinkedList<Integer>();
		boolean[] isVisited = new boolean[vertices.size()];
		queue.offer(v);
		isVisited[v] = true;
		
		while(!queue.isEmpty()){
			int u = queue.poll();  // 出队列
			searchOrders.add(u);
			for(int w: neighbors.get(u)){
				if(!isVisited[w]){
					queue.offer(w); // 入队列
					parent[w] = u;
					isVisited[w] = true;
				}
			}
		}
		
		return new Tree(v,parent,searchOrders);
	}

	/**
	 * 描述节点的父子关系
	 * 图的生成树的建立
	 * Properties： Only one path from any node to the root
	 * @author Weiping
	 *
	 */
	public class Tree{
		// 数据结构定义
		private int root; // The root of the tree
		private int[] parent; //Store the parent of each vertex
		private List<Integer> searchOrders; // Store the search order 搜索顺序
		
		// 构造器定义
		public Tree(int root,int[] parent,List<Integer> searchOrders){
			this.root = root;
			this.parent = parent;
			this.searchOrders = searchOrders;
		}
		
		public Tree(int root,int[] parent){
			this.root = root;
			this.parent = parent;
		
		}
		
		public int getRoot(){
			return root;
		}
		
		public int getParent(int v){
			return parent[v];
		}

		public List<Integer> getSearchOrders(){
			return searchOrders;
		}
		
		/**
		 * Return number of vertices found
		 * @return
		 */
		public int getNumberOfVerticesFound(){
			return searchOrders.size();
		}
		
		/**
		 * Return the path of vertices from a vertex index to the root
		 * Using the 'parent[]' for only one path from any node to the root
		 * @param index
		 * @return
		 */
		public List<V> getPath(int index){
			ArrayList<V> path = new ArrayList<V>();
			do{
				path.add(vertices.get(index));
				index = parent[index];
			}while(index != -1);
			
			return path;
		}
		
		public void printPath(int index){
			List<V> path = getPath(index);
			System.out.print("A path from" + vertices.get(root) + "to" + vertices.get(index) + ": " );
			for (int i = path.size()-1;i>=0;i--){
				System.out.print(path.get(i)+ " ");
			}
			System.out.println();
		}
		
		/**
		 * Print the whole tree
		 */
		public void printTree(){
			System.out.println("Root is: " + vertices.get(root));
			System.out.print("Edges: ");
			for(int i=0;i<parent.length;i++){
				if(parent[i] != -1){
					System.out.print("(" + vertices.get(parent[i]) + "," + vertices.get(i) + ")");
				}
			}
			System.out.println();
		}
		
		
		
	}
	
	
	
}
