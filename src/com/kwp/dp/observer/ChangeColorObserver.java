package com.kwp.dp.observer;

public class ChangeColorObserver implements ClickableObserver {

	@Override
	public void clicked(Clickable clickable) {
		Button b = (Button) clickable;
		b.color = "red";

	}

}
