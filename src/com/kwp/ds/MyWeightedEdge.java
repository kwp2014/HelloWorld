package com.kwp.ds;

import com.kwp.ds.MyAbstractGraph.MyEdge;

/**
 * ����ͼ�ıߵĶ��� 
 * �������ԣ���� �յ�  Ȩֵ  �ߺ�(����)
 * @author Weiping
 *
 */
public class MyWeightedEdge extends MyEdge implements Comparable<MyWeightedEdge> {

	public int weight;
	
	public MyWeightedEdge(int u, int v,int weight) {
		super(u, v);
		this.weight = weight;
	}
	
	public int compareTo(MyWeightedEdge edge){
		if(weight > edge.weight){
			return 1;
		}else if(weight == edge.weight){
			return 0;
		}else{
			return -1;
		}
	}
	

}
