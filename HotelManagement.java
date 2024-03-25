import java.util.ArrayList;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isOccupied;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupyRoom() {
        isOccupied = true;
    }

    public void vacateRoom() {
        isOccupied = false;
    }
}

class Guest {
    private String name;
    private int roomNumber;

    public Guest(String name, int roomNumber) {
        this.name = name;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public int getRoomNumber() {
        return roomNumber;
    }
}

class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Guest> guests;

    public Hotel(int numRooms) {
        rooms = new ArrayList<>();
        guests = new ArrayList<>();

        for (int i = 1; i <= numRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isOccupied()) {
                System.out.println("Room " + room.getRoomNumber());
            }
        }
    }

    public void bookRoom(String guestName, int roomNumber) {
        Room room = findRoom(roomNumber);

        if (room != null && !room.isOccupied()) {
            room.occupyRoom();
            guests.add(new Guest(guestName, roomNumber));
            System.out.println("Room booked successfully for " + guestName);
        } else {
            System.out.println("Room is already occupied or does not exist.");
        }
    }

    public void displayGuests() {
        System.out.println("Guests:");
        for (Guest guest : guests) {
            System.out.println("Name: " + guest.getName() + ", Room: " + guest.getRoomNumber());
        }
    }

    private Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

public class HotelManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Management Application!");

        System.out.print("Enter the number of rooms in the hotel: ");
        int numRooms = sc.nextInt();

        Hotel hotel = new Hotel(numRooms);

        while (true) {
            System.out.println("\n1. Display available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Display guests");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter guest name: ");
                    String guestName = sc.next();
                    System.out.print("Enter room number to book: ");
                    int roomNumber = sc.nextInt();
                    hotel.bookRoom(guestName, roomNumber);
                    break;
                case 3:
                    hotel.displayGuests();
                    break;
                case 4:
                    System.out.println("Exiting the Hotel Management Application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
}
