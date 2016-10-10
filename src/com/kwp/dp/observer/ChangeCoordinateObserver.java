package com.kwp.dp.observer;

public class ChangeCoordinateObserver  implements ClickableObserver {

	@Override
	public void clicked(Clickable clickable) {
		Button b = (Button) clickable;
		b.x += 100;
		b.y += 100;
	}

}
