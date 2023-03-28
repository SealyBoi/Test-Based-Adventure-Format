public class Eval extends Game{

    void printNewRoom() {
        System.out.print("\nYou are in the " + currRoom.getName() + ". " + currRoom.getDesc() + "\n");
        System.out.println("You see the following items in the room: ");
        currRoom.printItems();
    }

    void evalWalk(String input) {
        switch (input.toLowerCase()) {
            case "north":
                if (currRoom.getNorth() != null) {
                    if (!currRoom.getNorth().isLocked()) {
                        currRoom = currRoom.getNorth();
                        printNewRoom();
                    } else {
                        System.out.println("The door is locked.");
                    }
                } else {
                    System.out.println("You can't go that way.");
                }
                break;
            case "south":
                if (currRoom.getSouth() != null) {
                    if (!currRoom.getSouth().isLocked()) {
                        currRoom = currRoom.getSouth();
                        printNewRoom();
                    } else {
                        System.out.println("The door is locked.");
                    }
                } else {
                    System.out.println("You can't go that way.");
                }
                break;
            case "east":
                if (currRoom.getEast() != null) {
                    if (!currRoom.getEast().isLocked()) {
                        currRoom = currRoom.getEast();
                        printNewRoom();
                    } else {
                        System.out.println("The door is locked.");
                    }
                } else {
                    System.out.println("You can't go that way.");
                }
                break;
            case "west":
                if (currRoom.getWest() != null) {
                    if (!currRoom.getWest().isLocked()) {
                        currRoom = currRoom.getWest();
                        printNewRoom();
                    } else {
                        System.out.println("The door is locked.");
                    }
                } else {
                    System.out.println("You can't go that way.");
                }
                break;
            case "upstairs":
                if (currRoom.getUpstairs() != null) {
                    if (!currRoom.getUpstairs().isLocked()) {
                        currRoom = currRoom.getUpstairs();
                        printNewRoom();
                    } else {
                        System.out.println("The door is locked.");
                    }
                } else {
                    System.out.println("There is no staircase in the room.");
                }
                break;
            case "downstairs":
                if (currRoom.getDownstairs() != null) {
                    if (!currRoom.getDownstairs().isLocked()) {
                        currRoom = currRoom.getDownstairs();
                        printNewRoom();
                    } else {
                        System.out.println("The door is locked.");
                    }
                } else {
                    System.out.println("There is no staircase in the room.");
                }
                break;
            default:
                System.out.println("[!]Command " + input + " not recognized");
                break;
        }
    }

    void evalLook(String input) {
        switch (input.toLowerCase()) {
            case "north":
                if (currRoom.getNorth() != null) {
                    System.out.println("You see a door leading to the " + currRoom.getNorth().getName() + ".");
                } else {
                    System.out.println("You don't see anything special that way.");
                }
                break;
            case "south":
                if (currRoom.getSouth() != null) {
                    System.out.println("You see a door leading to the " + currRoom.getSouth().getName() + ".");
                } else {
                    System.out.println("You don't see anything special that way.");
                }
                break;
            case "east":
                if (currRoom.getEast() != null) {
                    System.out.println("You see a door leading to the " + currRoom.getEast().getName() + ".");
                } else {
                    System.out.println("You don't see anything special that way.");
                }
                break;
            case "west":
                if (currRoom.getWest() != null) {
                    System.out.println("You see a door leading to the " + currRoom.getWest().getName() + ".");
                } else {
                    System.out.println("You don't see anything special that way.");
                }
                break;
            default:
                System.out.println("[!]Command " + input + " not recognized");
                break;
        }
    }

    void evalExamine(String input) {
        Item itemR = currRoom.hasItem(input);
        Item itemI = inv.hasItem(input);
        if (itemR != null) {
            System.out.println(itemR.getDesc());
        } else if (itemI != null) {
            System.out.println(itemI.getDesc());
        } else {
            System.out.println("There isn't a " + input + " in the room.");
        }
    }

    void evalGrab(String input) {
        Item item = currRoom.hasItem(input);
        if (item != null) {
            if (item.isGrabbable()) {
                inv.addItem(item);
                currRoom.removeItem(item);
                System.out.println("You grabbed the " + item.getName());
            } else {
                System.out.println("You can't pick that up.");
            }
        } else {
            System.out.println("There isn't a " + input + " in the room.");
        }
    }

    void evalUse(String useObj, String trans, String useOnObj) {
        Item item = inv.hasItem(useObj);
        if (item != null) {
            if (trans.toLowerCase().equals("on")) {
                Item obj = currRoom.hasItem(useOnObj);
                if (obj != null) {
                    if (item.canUseOn(obj)) {
                        item.useItem();
                        inv.removeItem(item);
                        if (item.getUnlock() != null) {
                            item.getUnlock().cycleLock();
                        }
                    } else {
                        System.out.println("Nothing happens.");
                    }
                } else {
                    System.out.println("There isn't a " + useOnObj + " in the room.");
                }
            } else {
                System.out.println("[!]Command incomplete. (Ex: use key on door)");
            }
        } else {
            System.out.println("You don't have a " + useObj + ".");
        }
    }
}
