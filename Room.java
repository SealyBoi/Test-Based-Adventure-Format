import java.util.LinkedList;

public class Room {
    private String name;
    private String desc;
    private boolean locked;
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private Room upstairs;
    private Room downstairs;
    private LinkedList<Item> items = new LinkedList<Item>();

    public Room (String name, String desc, boolean locked) {
        this.name = name;
        this.desc = desc;
        this.locked = locked;
    }
    
    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isLocked() {
        return locked;
    }

    public void cycleLock() {
        locked = !locked;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Item hasItem(String item) {
        for (Item obj : items) {
            if (obj.getName().toLowerCase().equals(item.toLowerCase())) {
                return obj;
            }
        }
        return null;
    }

    public void printItems() {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i).getName());
        }
    }

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public Room getUpstairs() {
        return upstairs;
    }

    public void setUpstairs(Room upstairs) {
        this.upstairs = upstairs;
    }

    public Room getDownstairs() {
        return downstairs;
    }

    public void setDownstairs(Room downstairs) {
        this.downstairs = downstairs;
    }
}
