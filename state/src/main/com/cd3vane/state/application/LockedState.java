package main.com.cd3vane.state.application;

public class LockedState extends State {

    LockedState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        if(player.isPlaying()){
            player.changeState(new ReadyState(player));
            return "Stop Playing";
        }else{
            return "Player off";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready to play";
    }

    @Override
    public String onNext() {
        return "Player off";
    }

    @Override
    public String onPrevious() {
        return "Player off";
    }
}
