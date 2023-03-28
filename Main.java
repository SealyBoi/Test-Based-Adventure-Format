import java.io.File;
import java.util.Scanner;

class Main {
	static Scanner scan = new Scanner(System.in);
	static File f = new File("save.txt");
	static Game game = new Game();

	public static void main(String[] args) {
		if (f.exists()) {
			System.out.println("[*]Loading Save...");
			System.out.println("[*]Load Complete");
		}
		System.out.println("");
		System.out.println("============================");
		System.out.println("    _    _");
		System.out.println("   / \\  | | ___  _ __   ___");
		System.out.println("  / _ \\ | |/ _ \\| '_ \\ / _ \\");
		System.out.println(" / ___ \\| | (_) | | | |  __/");
		System.out.println("/_/   \\_\\_|\\___/|_| |_|\\___|");
		System.out.println("============================");
		System.out.println("Welcome to Alone. Select an option below to get started.");
		System.out.println(">Play Game (play)");
		System.out.println(">Quit (quit)");
		checkInput();
	}

	static void checkInput() {
		boolean badInput = true;
		System.out.print("$");
		String input = scan.nextLine();
		while (badInput) {
			switch(input.toLowerCase()) {
				case "play":
					game.start();
					badInput = false;
					break;
				case "quit":
					System.exit(0);
					break;
				default:
					System.out.println("[!]Command " + input + " not recognized");
					System.out.print("$");
					input = scan.nextLine();
					break;
			}
		}
	}
}
