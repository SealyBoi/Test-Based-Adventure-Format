import java.util.LinkedList;

class Item {
    private String name;
    private String desc;
    private String use;
    private boolean isGrabbable;
    private Room unlocks;
    LinkedList<Item> usables = new LinkedList<Item>();

    Item(String name, String desc, String use, boolean isGrabbable) {
        this.name = name;
        this.desc = desc;
        this.use = use;
        this.isGrabbable = isGrabbable;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setUnlock(Room room) {
        unlocks = room;
    }

    public Room getUnlock() {
        return unlocks;
    }

    public void useItem() {
        System.out.println(use);
    }

    public boolean isGrabbable() {
        return isGrabbable;
    }

    public void addUsable(Item item) {
        usables.add(item);
    }

    public boolean canUseOn(Item item) {
        if (usables.contains(item)) {
            return true;
        }
        return false;
    }

    public boolean isUsable() {
        return false;
    }
}
