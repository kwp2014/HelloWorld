package com.kwp.dp.observer;

public interface Clickable {
	void click();
	
	void addClickableObserver(ClickableObserver observer);
	
	void removeClickableObserver(ClickableObserver observer);
}
