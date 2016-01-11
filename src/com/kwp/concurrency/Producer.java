/**
 * 
 */
package com.kwp.concurrency;

/**
 * @author Weiping
 *
 */
public class Producer extends Thread{

	private Stack theStack;
	
	public Producer(Stack s, String name) {
		super(name);
		theStack = s;
		start();
	}
	public void run(){
		String goods;
		for(int i=0;i<200;i++){
			goods = "goods" + (theStack.getPoint()+1);
			theStack.push(goods);
			System.out.println(getName() + ": push " + goods + " to " + theStack.getName());
			yield();
		}
	}

}
