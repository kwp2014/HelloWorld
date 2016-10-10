package com.kwp.reflection;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// 代理的对象
		Target target = (Target) TargetFactory.createBean();
		// 代理的方法
		ProxyHander hander = new ProxyHander(target);
		// 结合创建动态代理
		Target proxy = (Target) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), hander);
		proxy.doSomthing();
		
		String s = "123456";
		System.out.println(s.substring(0,6));
		int[] a = {1,2};
		System.out.println(a.toString());
	}

}
