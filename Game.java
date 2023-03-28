import java.util.Scanner;

public class Game {
    // Initialize Inventory
    static Inventory inv = new Inventory();

    // Initialize Evaluator
    static Eval eval = new Eval();

    // Initialize Rooms
    static Room garden = new Room("Garden", "desc", false);
    static Room kitchen = new Room("Kitchen", "desc", false);
    static Room diningRoom = new Room("Dining Room", "desc", false);
    static Room bedroom = new Room("Bedroom", "desc", false);
    static Room livingRoom = new Room("Living Room", "desc", false);
    static Room bathroom = new Room("Bathroom", "desc", false);
    static Room basement = new Room("Basement", "desc", true);
    static Room hallway = new Room("Hallway", "desc", false);
    static Room attic = new Room("Attic", "desc", false);
    static Room currRoom;

    static boolean playing;

    static Scanner scan = new Scanner(System.in);

    void start() {
        currRoom = garden;
        playing = true;
        System.out.println("[*]Loading game...");
        System.out.println("[*]Linking rooms...");

        // Linking Rooms
        garden.setNorth(hallway);
        hallway.setWest(kitchen);
        hallway.setNorth(diningRoom);
        hallway.setEast(livingRoom);
        hallway.setSouth(garden);
        hallway.setUpstairs(attic);
        kitchen.setEast(hallway);
        kitchen.setNorth(hallway);
        kitchen.setDownstairs(basement);
        diningRoom.setSouth(hallway);
        livingRoom.setWest(hallway);
        livingRoom.setNorth(bedroom);
        bedroom.setSouth(livingRoom);
        bedroom.setWest(bathroom);
        bathroom.setEast(bedroom);
        basement.setUpstairs(kitchen);
        attic.setDownstairs(hallway);

        System.out.println("[*]Creating items...");

        // Creating Items
        Item hoe = new Item("Hoe", "A gardening tool.", "Use dat hoe.", true);
        Item grass = new Item("Grass", "It's grass.", "", false);
        Item knife = new Item("Knife", "A dull knife.", "You've done the world a favor.", true);
        Item painting = new Item("Painting", "A creepy painting of a starfish.", "", false);
        Item key = new Item("Key", "A strange-looking key...I wonder what it opens.", "You unlock the basement door.", true);
        Item basementDoor = new Item("Hatch", "A strange hatch in the corner of the kitchen. It appears to be locked.", "", false);
        Item gun = new Item("Gun", "It's a gun", "BANG BANG", true);

        System.out.println("[*]Spawning items...");

        // Adding Items
        garden.addItem(hoe);
        garden.addItem(grass);
        kitchen.addItem(knife);
        hallway.addItem(painting);
        bedroom.addItem(key);
        kitchen.addItem(basementDoor);
        basement.addItem(gun);

        System.out.println("[*]Cutting keys...");

        // Setting key unlocks
        key.setUnlock(basement);

        System.out.println("[*]Rendering usables...");

        // Linking Usables
        hoe.addUsable(grass);
        knife.addUsable(painting);
        key.addUsable(basementDoor);

        System.out.println("[*]Loading Complete");
        play();
    }

    void play() {
        String[] input;
        System.out.print("\nYou are in the " + currRoom.getName() + ". " + currRoom.getDesc() + "\n");
        System.out.println("You see the following items in the room: ");
        currRoom.printItems();
        while (playing) {
            System.out.print("$");
            input = scan.nextLine().split(" ");
            switch (input[0].toLowerCase()) {
                case "walk":
                    if (input.length >= 2) {
                        eval.evalWalk(input[1]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: walk north)");
                    }
                    break;
                case "go":
                    if (input.length >= 2) {
                        eval.evalWalk(input[1]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: go north)");
                    }
                    break;
                case "look":
                    if (input.length >= 2) {
                        eval.evalLook(input[1]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: look north)");
                    }
                    break;
                case "examine":
                    if (input.length >= 2) {
                        eval.evalExamine(input[1]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: examine bowl)");
                    }
                    break;
                case "inspect":
                    if (input.length >= 2) {
                        eval.evalExamine(input[1]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: inspect bowl)");
                    }
                    break;
                case "grab":
                    if (input.length >= 2) {
                        eval.evalGrab(input[1]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: grab bowl)");
                    }
                    break;
                case "use":
                    if (input.length >= 4) {
                        eval.evalUse(input[1], input[2], input[3]);
                    } else {
                        System.out.println("[!]Command incomplete. (Ex: use key on door)");
                    }
                    break;
                case "inv":
                    inv.printInventory();
                    break;
                case "help":
                    System.out.println("walk {direction}: moves the player in the desired direction if a room is connected in that direction.");
                    System.out.println("look {direction}: tells the player what room is in the direction they are looking.");
                    System.out.println("{examine/inspect} {item}: gives a description of the item the player is examining/inspecting.");
                    System.out.println("grab {item}: if the item is grabbable, adds item to player's inventory.");
                    System.out.println("inv: prints the players inventory.");
                    System.out.println("use {item}: if item is usable on an object, uses item.");
                    break;
                case "spin":
                    System.out.println("You do a 360 degree spin. Not sure why. But you did it.");
                    break;
                case "chant":
                    System.out.println("BAUM BAUM BAUM BAUM");
                    break;
                case "quit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("[!]Command " + input[0] + " not recognized");
                    break;
            }
        }
    }
}
