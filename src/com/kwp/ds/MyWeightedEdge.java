package com.kwp.ds;

import com.kwp.ds.MyAbstractGraph.MyEdge;

/**
 * 有向图的边的定义 
 * 基本属性：起点 终点  权值  边号(附加)
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
