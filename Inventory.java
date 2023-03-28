import java.util.LinkedList;

class Inventory {
    private LinkedList<Item> items = new LinkedList<Item>();

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

    public void printInventory() {
        for(Item obj : items) {
            System.out.println(obj.getName());
        }
    }
}
