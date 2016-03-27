/**
 * 
 */
package com.kwp.ds;

import java.util.*;
/**
 * @author Weiping
 *
 */
public class MyWeightedGraph<V> extends MyAbstractGraph<V> {

	//���ݽṹ���ڽ����Ա������ȶ���ʵ��
	private List<PriorityQueue<MyWeightedEdge>> queues;
	
	public MyWeightedGraph(int[][] edges, V[] vertices) {
		super(edges, vertices);
		createQueues(edges,vertices.length);
	}

	/**
	 * �ӱ߾����д������ȶ���
	 * @param edges
	 * @param numberOfVertices
	 */
	private void createQueues(int[][] edges, int numberOfVertices) {
		queues = new ArrayList<PriorityQueue<MyWeightedEdge>>();
		for(int i=0;i<numberOfVertices;i++){
			queues.add(new PriorityQueue<MyWeightedEdge>());
		}
		
		for(int i=0;i<edges.length;i++){
			int u = edges[i][0];
			int v = edges[i][1];
			int weight = edges[i][2];
			queues.get(u).offer(new MyWeightedEdge(u,v,weight));
		}
		
	}
	
	

}
