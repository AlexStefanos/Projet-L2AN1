package fr.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import fr.mygdx.game.ProjetL2AN1;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new ProjetL2AN1(), config);
		config.title = ProjetL2AN1.TITLE + " v " + ProjetL2AN1.VERSION;
		config.vSyncEnabled = true;
		config.useGL30 = true;
		config.fullscreen = true;
	    config.width = 1920;
	    config.height = 1080;
	}
}
