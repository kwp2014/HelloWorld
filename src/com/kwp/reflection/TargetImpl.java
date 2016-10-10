package com.kwp.reflection;

public class TargetImpl implements Target {
	
	protected TargetImpl(){
		super();
	} 
	
	@Override
	public void doSomthing() {
		System.out.println("具体业务逻辑实现");
		
	}

}
