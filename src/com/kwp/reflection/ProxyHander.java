package com.kwp.reflection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHander implements InvocationHandler{
	
	private Object target;
	
	public ProxyHander(Object target){
		super();
		this.target = target;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();
		method.invoke(target, args);
		afer();
		return null;
	}


	private void afer() {
		System.out.println("------------\n调用后处理");
		
	}

	private void before() {
		System.out.println("调用前处理\n------------");
		
	}
	
}
