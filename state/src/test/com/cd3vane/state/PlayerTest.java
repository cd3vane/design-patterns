package test.com.cd3vane.state;

import main.com.cd3vane.state.application.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    static Player player;
    static List<String> currentPlaylist;

    @BeforeAll
    static void init(){
        player = new Player();
        currentPlaylist = player.getPlaylist();
    }
    @Test
    public void initializesWithTestTracks(){
        assertEquals(10, currentPlaylist.size());
    }

}