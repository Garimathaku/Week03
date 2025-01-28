package com.day1;

class Ticket {
    int ticketID;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket reservation
    public void addTicket(int ticketID, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket added: " + ticketID);
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket prev = tail;
        do {
            if (current.ticketID == ticketID) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                System.out.println("Ticket removed: " + ticketID);
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        System.out.println("Ticket ID " + ticketID + " not found.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets to display.");
            return;
        }

        Ticket current = head;
        System.out.println("Current Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(query) || current.movieName.equalsIgnoreCase(query)) {
                System.out.println("Ticket Found - Ticket ID: " + current.ticketID + ", Customer Name: " + current.customerName + ", Movie Name: " + current.movieName + ", Seat Number: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tickets found for query: " + query);
        }
    }

    // Calculate the total number of booked tickets
    public int totalTickets() {
        if (head == null) {
            return 0;
        }

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);

        return count;
    }
}

class TicketReservationApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(1, "John", "My movie", "A112", "10:00 AM");
        system.addTicket(2, "Bob", "Your movie", "B212", "12:00 PM");
        system.addTicket(3, "Alice", "Movies123", "C312", "2:00 PM");

        system.displayTickets();

        system.searchTicket("John");
        system.searchTicket("Batman");

        System.out.println("Total Tickets: " + system.totalTickets());

        system.removeTicket(2);
        system.displayTickets();

        System.out.println("Total Tickets: " + system.totalTickets());
    }
}