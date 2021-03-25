package fr.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class AppPreferences {
	private Music music;
	private Music pressbutton;
	public static String PREF_MUSIC_VOLUME = "volume";
	private static final String PREF_MUSIC_ENABLED = "music.enabled";
	private static final String PREF_SOUND_ENABLED = "sound.enabled";
	private static final String PREF_SOUND_VOL = "sound";
	public static final String PREFS_NAME = "AudioSettings";
	public static float MVOLUME = getMusicVolume();
	public static float SVOLUME = getSoundVolume();
	
	
	protected static Preferences getPrefs() {
		return Gdx.app.getPreferences(PREFS_NAME);
	}

	public boolean isSoundEffectsEnabled() {
		return getPrefs().getBoolean(PREF_SOUND_ENABLED, true);
	}

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

	public boolean isMusicEnabled() {
		return getPrefs().getBoolean(PREF_MUSIC_ENABLED, true);
	}

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

	public static float getMusicVolume() {
		return getPrefs().getFloat(PREF_MUSIC_VOLUME, 0.5f);
	}

	public void setMusicVolume(float volume) {
		music = Gdx.audio.newMusic(Gdx.files.internal("Optionmusic.mp3"));
		MVOLUME = volume; 
		music.setVolume(volume);
		getPrefs().putFloat(PREF_MUSIC_VOLUME, volume);
		getPrefs().flush();
	}
	
	public static float getSoundVolume() {
		return getPrefs().getFloat(PREF_SOUND_VOL, 0.5f);
	}

	public void setSoundVolume(float volume) {
		pressbutton = Gdx.audio.newMusic(Gdx.files.internal("Optionmusic.mp3"));
		SVOLUME = volume;
		pressbutton.setVolume(volume);
		getPrefs().putFloat(PREF_SOUND_VOL, volume);
		getPrefs().flush();
	}
	public void constantVolumeMusic() {
		
	}
}