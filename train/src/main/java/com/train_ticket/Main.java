package com.train_ticket;


import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicketBooking booking = new TicketBooking();
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Train Ticket Booking System");
            System.out.println("1. Add User");
            System.out.println("2. Update User");
            System.out.println("3. Add Train");
            System.out.println("4. Book Ticket");
            System.out.println("5. List Bookings by User ID");
            System.out.println("6. List Bookings by User Email");
            System.out.println("7. List All Users");
            System.out.println("8. List All Trains");
            System.out.println("9. List All Bookings");
            System.out.println("10. List All Tickets by Train ID");
            System.out.println("11. Cancel Ticket");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    User user = new User(username, email);
                    userManager.addUser(user);
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    int updateUserId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    User updatedUser = new User(newUsername, newEmail);
                    updatedUser.setId(updateUserId);
                    userManager.updateUser(updatedUser);
                    break;
                case 3:
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.nextLine();
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter departure time (HH:MM:SS): ");
                    String departureTime = scanner.nextLine();
                    System.out.print("Enter departure: ");
                    String departure = scanner.nextLine(); // Prompt for departure
                    Train train = new Train(trainNumber, destination, departureTime, departure);
                    booking.addTrain(train);
                    break;

                // case 4:
                //     System.out.print("Enter user ID: ");
                //     int userId = scanner.nextInt();
                //     System.out.print("Enter train ID: ");
                //     int trainId = scanner.nextInt();
                //     scanner.nextLine(); // Consume newline
                //     System.out.print("Enter date of journey (YYYY-MM-DD): ");
                //     String dateOfJourney = scanner.nextLine();
                //     System.out.print("Enter seat number: ");
                //     int seatNumber = scanner.nextInt();
                //     Ticket ticket = new Ticket(userId, trainId, dateOfJourney, seatNumber);
                //     booking.bookTicket(ticket);
                //     break;
                case 4:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter train ID: ");
                    int trainId = scanner.nextInt();
                    scanner.nextLine();
                    String dateOfJourney;
                    do {
                        System.out.print("Enter date of journey (YYYY-MM-DD): ");
                        dateOfJourney = scanner.nextLine();
                        if (!ValidationUtil.isValidDate(dateOfJourney)) {
                            System.out.println("Invalid date format. Please try again.");
                        }
                    } while (!ValidationUtil.isValidDate(dateOfJourney));

                    do {
                        System.out.print("Enter departure time (HH:mm:ss): ");
                        departureTime = scanner.nextLine();
                        if (!ValidationUtil.isValidTime(departureTime)) {
                            System.out.println("Invalid time format. Please try again.");
                        }
                    } while (!ValidationUtil.isValidTime(departureTime));

                    System.out.print("Enter seat number: ");
                    int seatNumber = scanner.nextInt();
                    Ticket ticket = new Ticket(userId, trainId, dateOfJourney, seatNumber);
                    booking.bookTicket(ticket);
                    break;
                case 5:
                    System.out.print("Enter user ID: ");
                    int uId = scanner.nextInt();
                    List<Ticket> ticketsByUserId = booking.listBookingsByUserId(uId);
                    if (ticketsByUserId.isEmpty()) {
                        System.out.println("No bookings found for this user.");
                    } else {
                        System.out.println("Bookings for user ID " + uId + ":");
                        for (Ticket t : ticketsByUserId) {
                            System.out.println("Ticket ID: " + t.getId());
                            System.out.println("Train ID: " + t.getTrainId());
                            System.out.println("Date of Journey: " + t.getDateOfJourney());
                            System.out.println("Seat Number: " + t.getSeatNumber());
                            System.out.println();
                        }
                    }
                    break;
                case 6:
                    System.out.print("Enter user email: ");
                    String userEmail = scanner.nextLine();
                    List<Ticket> ticketsByUserEmail = booking.listBookingsByUserEmail(userEmail);
                    if (ticketsByUserEmail.isEmpty()) {
                        System.out.println("No bookings found for this user.");
                    } else {
                        System.out.println("Bookings for user email " + userEmail + ":");
                        for (Ticket t : ticketsByUserEmail) {
                            System.out.println("Ticket ID: " + t.getId());
                            System.out.println("Train ID: " + t.getTrainId());
                            System.out.println("Date of Journey: " + t.getDateOfJourney());
                            System.out.println("Seat Number: " + t.getSeatNumber());
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    List<User> users = userManager.listAllUsers();
                    if (users.isEmpty()) {
                        System.out.println("No users registered.");
                    } else {
                        System.out.println("Registered users:");
                        for (User u : users) {
                            System.out.println("User ID: " + u.getId());
                            System.out.println("Username: " + u.getUsername());
                            System.out.println("Email: " + u.getEmail());
                            System.out.println();
                        }
                    }
                    break;
                case 8:
                    List<Train> allTrains = booking.listAllTrains();
                    if (allTrains.isEmpty()) {
                        System.out.println("No trains found.");
                    } else {
                        System.out.println("All trains:");
                        for (Train t : allTrains) {
                            System.out.println("Train ID: " + t.getId());
                            System.out.println("Train Number: " + t.getTrainNumber());
                            System.out.println("Destination: " + t.getDestination());
                            System.out.println("Departure: " + t.getDeparture());
                            System.out.println("Departure Time: " + t.getDepartureTime());
                            System.out.println();
                        }
                    }
                    break;
                case 9:
                    List<Ticket> allTickets = booking.listAllBookings();
                    if (allTickets.isEmpty()) {
                        System.out.println("No bookings found.");
                    } else {
                        System.out.println("All bookings:");
                        for (Ticket t : allTickets) {
                            System.out.println("Ticket ID: " + t.getId());
                            System.out.println("User ID: " + t.getUserId());
                            System.out.println("Train ID: " + t.getTrainId());
                            System.out.println("Date of Journey: " + t.getDateOfJourney());
                            System.out.println("Seat Number: " + t.getSeatNumber());
                            System.out.println();
                        }
                    }
                    break;
                case 10:
                    System.out.print("Enter train ID: ");
                    int searchTrainId = scanner.nextInt();
                    List<Ticket> ticketsByTrainId = booking.listTicketsByTrainId(searchTrainId);
                    if (ticketsByTrainId.isEmpty()) {
                        System.out.println("No tickets found for this train.");
                    } else {
                        System.out.println("Tickets for train ID " + searchTrainId + ":");
                        for (Ticket t : ticketsByTrainId) {
                            System.out.println("Ticket ID: " + t.getId());
                            System.out.println("User ID: " + t.getUserId());
                            System.out.println("Date of Journey: " + t.getDateOfJourney());
                            System.out.println("Seat Number: " + t.getSeatNumber());
                            System.out.println();
                        }
                    }
                    break;
                case 11:
                    System.out.print("Enter ticket ID: ");
                    int cancelTicketId = scanner.nextInt();
                    booking.cancelTicket(cancelTicketId);
                    break;
                case 12:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.gc();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
