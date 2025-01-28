package com.day1;

class User {
    int userID;
    String name;
    int age;
    FriendNode friendList;
    User next;

    public User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}
//class FriendNode
class FriendNode {
    int friendID;
    FriendNode next;

    public FriendNode(int friendID) {
        this.friendID = friendID;
        this.next = null;
    }
}
//class socialMedia
class SocialMedia {
    private User head;

    public SocialMedia() {
        head = null;
    }

    // Add a new user
    public void addUser(int userID, String name, int age) {
        User newUser = new User(userID, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newUser;
        }
    }

    // Add a friend connection
    public void addFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            addFriendToList(user1, userID2);
            addFriendToList(user2, userID1);
            System.out.println("Friend connection added between " + userID1 + " and " + userID2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    private void addFriendToList(User user, int friendID) {
        FriendNode newFriend = new FriendNode(friendID);
        if (user.friendList == null) {
            user.friendList = newFriend;
        } else {
            FriendNode current = user.friendList;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newFriend;
        }
    }

    // Remove a friend connection
    public void removeFriend(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            user1.friendList = removeFriendFromList(user1.friendList, userID2);
            user2.friendList = removeFriendFromList(user2.friendList, userID1);
            System.out.println("Friend connection removed between " + userID1 + " and " + userID2);
        } else {
            System.out.println("One or both users not found.");
        }
    }

    private FriendNode removeFriendFromList(FriendNode head, int friendID) {
        if (head == null) return null;

        if (head.friendID == friendID) {
            return head.next;
        }

        FriendNode current = head;
        while (current.next != null && current.next.friendID != friendID) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }

        return head;
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userID1, int userID2) {
        User user1 = findUserByID(userID1);
        User user2 = findUserByID(userID2);

        if (user1 != null && user2 != null) {
            System.out.print("Mutual friends between " + userID1 + " and " + userID2 + ": ");
            FriendNode friends1 = user1.friendList;
            while (friends1 != null) {
                if (isFriend(user2.friendList, friends1.friendID)) {
                    System.out.print(friends1.friendID + " ");
                }
                friends1 = friends1.next;
            }
            System.out.println();
        } else {
            System.out.println("One or both users not found.");
        }
    }

    private boolean isFriend(FriendNode friendList, int friendID) {
        while (friendList != null) {
            if (friendList.friendID == friendID) {
                return true;
            }
            friendList = friendList.next;
        }
        return false;
    }

    // Display all friends of a specific user
    public void displayFriends(int userID) {
        User user = findUserByID(userID);
        if (user != null) {
            System.out.print("Friends of " + userID + ": ");
            FriendNode current = user.friendList;
            while (current != null) {
                System.out.print(current.friendID + " ");
                current = current.next;
            }
            System.out.println();
        } else {
            System.out.println("User not found.");
        }
    }

    // Search for a user by Name or User ID
    public User findUserByID(int userID) {
        User current = head;
        while (current != null) {
            if (current.userID == userID) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void searchUser(String name) {
        User current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                System.out.println("User found: " + current.userID + " - " + current.name);
                return;
            }
            current = current.next;
        }
        System.out.println("User not found.");
    }

    // Count the number of friends for each user
    public void countFriends() {
        User current = head;
        while (current != null) {
            int count = 0;
            FriendNode friend = current.friendList;
            while (friend != null) {
                count++;
                friend = friend.next;
            }
            System.out.println("User " + current.userID + " has " + count + " friends.");
            current = current.next;
        }
    }
}

class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia sm = new SocialMedia();

        sm.addUser(3, "Alice", 45);
        sm.addUser(2, "Bob", 35);
        sm.addUser(1, "John", 20);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);
        sm.addFriend(2, 3);

        sm.displayFriends(1);
        sm.displayFriends(2);

        sm.findMutualFriends(1, 2);

        sm.countFriends();

        sm.removeFriend(1, 2);
        sm.displayFriends(1);
        sm.displayFriends(2);
    }
}
