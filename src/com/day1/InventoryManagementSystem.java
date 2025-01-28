package com.day1;



class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagement {
    private Item head;

    // Add an item at the beginning
    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add an item at the end
    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Add an item at a specific position
    public void addAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        if (position == 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove an item based on Item ID
    public void removeByItemId(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item removed successfully.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }
        temp.next = temp.next.next;
        System.out.println("Item removed successfully.");
    }

    // Update the quantity of an item by Item ID
    public void updateQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID: " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    // Search for an item based on Item ID or Item Name
    public void searchItem(String nameOrId) {
        Item temp = head;
        while (temp != null) {
            if (String.valueOf(temp.itemId).equals(nameOrId) || temp.itemName.equalsIgnoreCase(nameOrId)) {
                System.out.println("Item Found: Name: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Calculate and display the total value of inventory
    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + totalValue);
    }

    // Display all items
    public void displayAllItems() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("Name: " + temp.itemName + ", ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }

    // Sort inventory based on Item Name in ascending order
    public void sortByName() {
        if (head == null || head.next == null) return;
        head = mergeSortByName(head);
    }

    private Item mergeSortByName(Item head) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextToMiddle = middle.next;
        middle.next = null;

        Item left = mergeSortByName(head);
        Item right = mergeSortByName(nextToMiddle);

        return mergeByName(left, right);
    }

    private Item mergeByName(Item left, Item right) {
        if (left == null) return right;
        if (right == null) return left;

        Item result;
        if (left.itemName.compareToIgnoreCase(right.itemName) <= 0) {
            result = left;
            result.next = mergeByName(left.next, right);
        } else {
            result = right;
            result.next = mergeByName(left, right.next);
        }
        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();

        // Adding items
        inventory.addAtEnd("Mobile Phones", 100, 17, 40000);
        inventory.addAtEnd("Computer", 200, 22, 5000);
        inventory.addAtBeginning("Keyboard", 300, 45, 80000);
        inventory.addAtPosition(3, "Mouse", 400, 7, 100000);

        // Displaying all items
        System.out.println("All items:");
        inventory.displayAllItems();

        // Searching for an item
        System.out.println("\nSearching for Item ID 102:");
        inventory.searchItem("22");

        // Updating quantity
        System.out.println("\nUpdating quantity for Item ID 101:");
        inventory.updateQuantity(100, 12);

        // Calculating total inventory value
        System.out.println("\nCalculating total inventory value:");
        inventory.calculateTotalValue();

        // Sorting items by name
        System.out.println("\nSorting items by name:");
        inventory.sortByName();
        inventory.displayAllItems();

        // Removing an item
        System.out.println("\nRemoving item with Item ID 103:");
        inventory.removeByItemId(103);
        inventory.displayAllItems();
    }
}
