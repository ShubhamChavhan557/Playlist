package playlist;

	import java.util.*;

	public class RecentlyPlayedStore {
	    private final int capacity;
	    private final Map<String, LinkedList<String>> store;

	    public RecentlyPlayedStore(int capacity) {
	        this.capacity = capacity;
	        this.store = new HashMap<>();
	    }

	    public void playSong(String user, String song) {
	        store.putIfAbsent(user, new LinkedList<>());
	        LinkedList<String> userSongs = store.get(user);

	        if (userSongs.contains(song)) {
	            userSongs.remove(song);
	        } else if (userSongs.size() == capacity) {
	            userSongs.removeFirst();
	        }

	        userSongs.addLast(song);
	    }

	    public List<String> getRecentlyPlayed(String user) {
	        return store.getOrDefault(user, new LinkedList<>());
	    }

	    public static void main(String[] args) {
	        RecentlyPlayedStore store = new RecentlyPlayedStore(3);
	        store.playSong("user1", "S1");
	        store.playSong("user1", "S2");
	        store.playSong("user1", "S3");
	        System.out.println(store.getRecentlyPlayed("user1")); // [S1, S2, S3]

	        store.playSong("user1", "S4");
	        System.out.println(store.getRecentlyPlayed("user1")); // [S2, S3, S4]

	        store.playSong("user1", "S2");
	        System.out.println(store.getRecentlyPlayed("user1")); // [S3, S4, S2]

	        store.playSong("user1", "S1");
	        System.out.println(store.getRecentlyPlayed("user1")); // [S4, S2, S1]
	    }
	}


