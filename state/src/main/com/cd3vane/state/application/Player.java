package main.com.cd3vane.state.application;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;
    private boolean playing = false;
    private final List<String> playlist = new ArrayList<>();
    private int currentTrack = 0;

    public Player(){
        this.state = new ReadyState(this);
        setPlaying(true);
        for(int i = 0; i < 10; i++){
            playlist.add("Track " + i);
        }
    }

    public State getState(){
        return state;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void setPlaying(boolean isPlaying){
        this.playing = isPlaying;
    }

    public boolean isPlaying() {
        return playing;
    }

    public List<String> getPlaylist() {
        return playlist;
    }

    public void resetCurrentTrack() {
        this.currentTrack = 0;
    }

    public String startPlayback() {
        return "Playing " + playlist.get(currentTrack);
    }

    public String nextTrack(){
        currentTrack++;
        if(currentTrack > playlist.size() - 1){
            resetCurrentTrack();
        }
        return "Playing " + playlist.get(currentTrack);
    }

    public String previousTrack(){
        currentTrack--;
        if(currentTrack < 0){
            currentTrack = playlist.size() - 1;
        }
        return "Playing " + playlist.get(currentTrack);
    }
}
