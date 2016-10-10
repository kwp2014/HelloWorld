package com.kwp.dp.observer;

import java.util.ArrayList;
import java.util.List;

public class Button implements Clickable {

	List<ClickableObserver> observers = new ArrayList<ClickableObserver>();
	String color;
	int x,y;
	
	@Override
	public void click() {
		System.out.println("按钮被单击");
		// 通知所有的观察者
		for(ClickableObserver observer:observers){
			observer.clicked(this);
		}
	}

	@Override
	public void addClickableObserver(ClickableObserver observer) {
		
		observers.add(observer);
	}

	@Override
	public void removeClickableObserver(ClickableObserver observer) {
		observers.remove(observer);

	}
	
	public String toString(){
		return "按钮颜色" + color + "；坐标" + x + "，" + y;
	}

}
