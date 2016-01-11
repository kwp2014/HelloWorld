/**
 * 
 */
package com.kwp.concurrency;

/**
 * @author Weiping
 *
 */
public class Consumer extends Thread{

	private Stack theStack;
	
	public Consumer(Stack s, String name) {
		super(name);
		theStack = s;
		start();
	}
	
	public void run(){
		String goods;
		for(int i=0;i<200;i++){
			goods = theStack.pop();
			System.out.println(getName() + ": pop " + goods + " from " + theStack.getName());
			yield();
		}
	}

}
