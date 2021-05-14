package fr.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import fr.mygdx.game.Options;
import fr.mygdx.game.BLACKJACKCity;

/**
 * C'est grâce a cette classe que le jeu se lance
 * @author arthu
 *
 */
public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new BLACKJACKCity(), config);
		config.title = BLACKJACKCity.TITLE;
		config.vSyncEnabled = true;
		config.useGL30 = true;
		config.fullscreen = Options.FULLSCREEN;
	    config.width = 1920;
	    config.height = 1080;
	}
}
