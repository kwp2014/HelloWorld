package com.kwp.dp.observer;

public class Test {

	public static void main(String[] args) {
		Button button = new Button();
		button.color = "black";
		button.x = button.y = 50;
		System.out.println(button);
		
		button.addClickableObserver(new ChangeColorObserver());
		button.addClickableObserver(new ChangeCoordinateObserver());
		
		button.click();
		System.out.println(button);
	}

}
