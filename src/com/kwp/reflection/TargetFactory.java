package com.kwp.reflection;

public class TargetFactory {
	
	private static Target target;
	private TargetFactory(){}
	
	public static Object createBean(){
		if(target == null){
			target = new TargetImpl(); 
		}
		return target;
	}
	
}
