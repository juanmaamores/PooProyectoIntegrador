package poo.Otros;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;

    URL soundURL[] = new URL[10];

    public Sound(){
        soundURL[0] = getClass().getResource("/sounds/musicaNivel1.wav");
        soundURL[1] = getClass().getResource("/sounds/disparo1.wav");
        soundURL[2] = getClass().getResource("/sounds/col.wav");
        soundURL[3] = getClass().getResource("/sounds/sea-battle.wav");
        soundURL[4] = getClass().getResource("/sounds/muerte.wav");
        soundURL[5] = getClass().getResource("/sounds/bonus.wav");
        soundURL[6] = getClass().getResource("/sounds/tsunami.wav");
        soundURL[7] = getClass().getResource("/sounds/relampago.wav");
        soundURL[8] = getClass().getResource("/sounds/colHeroe.wav");

    }

    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void play(){
        clip.start();
    }

    public void stop(){
        clip.stop();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}
