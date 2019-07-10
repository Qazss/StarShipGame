package ru.geekbrains.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.geekbrains.game.StarShipGame;

public class DesktopLauncher {
	private static final int windowHeight = 512;
	private static final int windowWidth = 512;

	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "StarShipGame";
		config.height = windowHeight;
		config.width = windowWidth;
		new LwjglApplication(new StarShipGame(), config);
	}
}
