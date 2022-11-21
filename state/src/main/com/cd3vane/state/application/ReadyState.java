package main.com.cd3vane.state.application;

public class ReadyState extends State {

    public ReadyState(Player player) {
        super(player);
    }

    @Override
    public String onLock() {
        player.changeState(new LockedState(player));
        return "Locked";
    }

    @Override
    public String onPlay() {
        var action = player.startPlayback();
        player.changeState(new PlayingState(player));
        return action;
    }

    @Override
    public String onNext() {
        return "Nothing is playing";
    }

    @Override
    public String onPrevious() {
        return "Nothing is playing";
    }
}
