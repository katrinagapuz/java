import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

public class Playlist {

	private static Scanner sc = new Scanner(System.in);
	private static LinkedList<Song> myPlaylist;
	private static ListIterator<Song> li;
	
	public static void main(String[] args) {
		
		Album the1975 = new Album("The 1975");
		the1975.addSong("Somebody Else", 4.5);
		the1975.addSong("Medicine", 5.5);
		the1975.addSong("Robbers", 3.5);
		the1975.addSong("If I Believe You", 4.0);
		
		Album edSheeran = new Album("Ed Sheeran");
		edSheeran.addSong("Perfect", 3.0);
		edSheeran.addSong("Sunburn", 4.0);
		edSheeran.addSong("You", 3.5);


		myPlaylist = new LinkedList<Song>();
		myPlaylist.add(the1975.getSongs().get(0));
		myPlaylist.add(the1975.getSongs().get(1));
		myPlaylist.add(the1975.getSongs().get(3));
		myPlaylist.add(edSheeran.getSongs().get(2));

		li = myPlaylist.listIterator();
		li.next().playSong();

		printMenu();
		boolean flag = true;
		int option;

		while(flag) {
			System.out.println("Enter command: ");
			option = sc.nextInt();
			sc.nextLine();

			switch(option) {
				case 0:
					flag = false;
					break;
				case 1:
					printMenu();
					break;
				case 2:
					nextSong();
					break;
				case 3:
					replaySong();
					break;
				case 4:
					previousSong();
					break;
				case 5:
					printSongs();
					break;
				case 6:
					deleteSong();
					break;
			}
		}
	}

	public static void printMenu() {
		System.out.println("Playlist Menu: ");
		System.out.println("[0] Quit");
		System.out.println("[1] Print menu");
		System.out.println("[2] Next song");
		System.out.println("[3] Replay song");
		System.out.println("[4] Previous song");
		System.out.println("[5] Print songs");
		System.out.println("[6] Delete song");

	}

	public static void nextSong() {
		if(li.hasNext())
			li.next().playSong();
		else
			System.out.println("End of playlist");
	}

	public static void replaySong() {
		if(li.hasPrevious())
			li.previous();

		if(li.hasNext())
			li.next().playSong();
	}

	public static void previousSong() {
		if(li.hasPrevious())
			li.previous();
		else {
			System.out.println("Top of playlist");
			return;
		}

		if(li.hasPrevious()) {
			li.previous();
			li.next().playSong();
		}
		else
			System.out.println("Top of playlist");
	}

	public static void printSongs() {
		ListIterator<Song> it = myPlaylist.listIterator();
		int ctr = 1;
		System.out.println("This playlist contains: ");

		while(it.hasNext()) {
			System.out.println("[" + ctr + "] " + it.next().getTitle());
			ctr++;
		}
	}

	public static void deleteSong() {
		System.out.println("Enter number of song to delete: ");
		int song = sc.nextInt();

		if(song > 0 && song < myPlaylist.size())
			myPlaylist.remove(song-1);
		else
			System.out.println("Song number invalid.");
	}
}