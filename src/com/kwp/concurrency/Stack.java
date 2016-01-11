/**
 * 
 */
package com.kwp.concurrency;

/**
 * @author Weiping
 *
 */
public class Stack {
	private String name;
	private String[] buffer = new String[100];
	int point = -1;
	
	public Stack(String name) {
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public synchronized int getPoint(){
		return point;
	}
	public synchronized String pop(){
		if(point > -1){
			Thread.yield();
		}
		String goods = buffer[point];
		buffer[point] = null;
		Thread.yield();
		point --;
		return goods;
	}

	public synchronized void push(String goods){
		point ++;
		Thread.yield();
		buffer[point] = goods;
	}
}
