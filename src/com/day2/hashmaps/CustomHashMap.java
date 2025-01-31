package com.day2.hashmaps;

import java.util.*;

class CustomHashMap<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = getHash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getHash(key);
        if (buckets[index] == null) return null;

        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getHash(key);
        if (buckets[index] == null) return;

        Iterator<Entry<K, V>> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove();
                size--;
                return;
            }
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomHashMap<Integer, String> map = new CustomHashMap<>();

        while (true) {
            System.out.println("\n===== Custom HashMap Operations =====");
            System.out.println("1. Insert (put)");
            System.out.println("2. Retrieve (get)");
            System.out.println("3. Remove (delete)");
            System.out.println("4. Check if key exists");
            System.out.println("5. Get size");
            System.out.println("6. Print HashMap");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int key = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter value (string): ");
                    String value = scanner.nextLine();
                    map.put(key, value);
                    System.out.println("Inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter key to retrieve value: ");
                    int getKey = scanner.nextInt();
                    String retrievedValue = map.get(getKey);
                    System.out.println(retrievedValue != null ? "Value: " + retrievedValue : "Key not found!");
                    break;

                case 3:
                    System.out.print("Enter key to remove: ");
                    int removeKey = scanner.nextInt();
                    map.remove(removeKey);
                    System.out.println("Removed successfully (if existed)!");
                    break;

                case 4:
                    System.out.print("Enter key to check existence: ");
                    int checkKey = scanner.nextInt();
                    System.out.println(map.containsKey(checkKey) ? "Key exists!" : "Key not found!");
                    break;

                case 5:
                    System.out.println("Size of HashMap: " + map.size());
                    break;

                case 6:
                    System.out.println("Current HashMap:");
                    map.printMap();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
