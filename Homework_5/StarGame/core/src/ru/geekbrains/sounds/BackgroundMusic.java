package ru.geekbrains.sounds;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class BackgroundMusic {

    private static Music backgroundMusic;

    public static void initMusic(){
        backgroundMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/music.mp3"));
        backgroundMusic.setLooping(true);
        backgroundMusic.setVolume(1.0f);
        backgroundMusic.play();
    }

    public static Music getBackgroundMusic() {
        return backgroundMusic;
    }

    public static void dispose(){
        backgroundMusic.dispose();
    }
}
