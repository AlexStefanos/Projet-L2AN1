package fr.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;

/**
 * Classe qui permet de gérer l'utilisation et le réglage du son.
 * @author arthu
 *
 */
public class AppPreferences {
	private Music music;
	private Music pressbutton;
	public static String PREF_MUSIC_VOLUME = "volume";
	private static final String PREF_MUSIC_ENABLED = "music.enabled";
	private static final String PREF_SOUND_ENABLED = "sound.enabled";
	private static final String PREF_SOUND_VOL = "sound";
	private static final String JJ = "JJ";
	public static final String PREFS_NAME = "AudioSettings";
	public static float MVOLUME = getMusicVolume();
	public static float SVOLUME = getSoundVolume();
	public static int J = getJ();
	
	/**
	 * Cette fontion retourne le fichier ou va etre sauvegarde les options de l'utilisateur.
	 * @return Gdx.app.getPreferences(PREFS_NAME); 
	 */
	protected static Preferences getPrefs() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}
	
	/**
	 * Permet de savoir si  le volume des effet est mute.
	 * @return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
	 */
	public boolean isSoundEffectsEnabled() {
		return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
	}
	
	/**
	 * Permet de muter le volume des effets du jeu.
	 * @param soundEffectsEnabled
	 */
	public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
		if(soundEffectsEnabled) {
			SVOLUME = getSoundVolume();
		}
		else {
			SVOLUME = 0.00f;
			getPrefs().putFloat(PREF_SOUND_VOL, 0.00f);
			getPrefs().flush();
		}
		getPrefs().putBoolean(PREF_SOUND_ENABLED, soundEffectsEnabled);
		getPrefs().flush();
	}
	/**
	 * Retourne un booleen pour savoir si la musique est mute ou non.
	 * @return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
	 */
	public boolean isMusicEnabled() {
		return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
	}
	/**
	 * Permet de muter la musique du jeu.
	 * @param musicEnabled
	 */
	public void setMusicEnabled(boolean musicEnabled) {
		if(musicEnabled) {
			MVOLUME = getMusicVolume();
		}
		else {
			MVOLUME = 0.00f;
			getPrefs().putFloat(PREF_MUSIC_VOLUME, 0.00f);
			getPrefs().flush();
			
		}
		getPrefs().putBoolean(PREF_MUSIC_ENABLED, musicEnabled);
		getPrefs().flush();
	}
	/**
	 * Retourne le volume de la musique du jeu.
	 * @return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
	 */
	public static float getMusicVolume() {
		return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
	}
	/**
	 * Definie le volume de la musique du jeu.
	 * @param volume
	 */
	public void setMusicVolume(float volume) {
		music = Gdx.audio.newMusic(Gdx.files.internal("Optionmusic.mp3"));
		MVOLUME = volume; 
		music.setVolume(volume);
		getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
		getPrefs().flush();
	}
	/**
	 * Retroune le volume des effets du jeu.
	 * @return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
	 */
	public static float getSoundVolume() {
		return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
	}
	/**
	 * Definie le volume des effets du jeu.
	 * @param volume
	 */
	public void setSoundVolume(float volume) {
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("Optionmusic.mp3"));
		SVOLUME = volume;
		pressbutton.setVolume(volume);
		getPrefs().putFloat(PREF_SOUND_VOL, volume);
		getPrefs().flush();
	}
	/**
	 * Retourne J qui permet de gere la sauvegarde des parties.
	 * @return getPrefs().getInteger(JJ, 0);
	 */
	public static int getJ() {
		return getPrefs().getInteger(JJ, 0);
	}
	/**
	 * Defenie J qui est une variable permettant la sauvegarde des parties.
	 * @param i
	 */
	public void setJ(int i) {
		J = getPrefs().getInteger(JJ)+i;
		getPrefs().putInteger(JJ,getPrefs().getInteger(JJ)+i );
		getPrefs().flush();
		
	}
}