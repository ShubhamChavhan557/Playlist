package playlist;

import org.junit.jupiter.api.Test;

import dev.failsafe.internal.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
	public class RecentlyPlayedStoreTest {

	    @Test
	    public void testSingleUser() {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
	        store.playSong("user1", "S1");
	        store.playSong("user1", "S2");
	        store.playSong("user1", "S3");
	       Asserts.assertEquals(List.of("S1", "S2", "S3"), store.getRecentlyPlayed("user1"));
       
	        store.playSong("user1", "S4");
	        assertEquals(List.of("S2", "S3", "S4"), store.getRecentlyPlayed("user1"));

	        store.playSong("user1", "S2");
	        assertEquals(List.of("S3", "S4", "S2"), store.getRecentlyPlayed("user1"));

	        store.playSong("user1", "S1");
	        assertEquals(List.of("S4", "S2", "S1"), store.getRecentlyPlayed("user1"));
	    }

	    @Test
	    public void testMultipleUsers() {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
	        store.playSong("user1", "S1");
	        store.playSong("user2", "S4");
	        assertEquals(List.of("S1"), store.getRecentlyPlayed("user1"));
	        assertEquals(List.of("S4"), store.getRecentlyPlayed("user2"));

	        store.playSong("user1", "S2");
	        assertEquals(List.of("S1", "S2"), store.getRecentlyPlayed("user1"));

	        store.playSong("user2", "S5");
	        assertEquals(List.of("S4", "S5"), store.getRecentlyPlayed("user2"));
	    }
	}	

