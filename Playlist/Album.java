import java.util.ArrayList;

public class Album {
	private String title;
	private ArrayList<Song> songs;

	public Album(String title) {
		this.title = title;
		songs = new ArrayList<Song>();
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void addSong(String title, double duration) {
		songs.add(new Song(title, duration));
	}
}