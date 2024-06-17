package com.train_ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketBooking {

    // Method to add a user
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());

            pstmt.executeUpdate();
            System.out.println("User added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a train
    public void addTrain(Train train) {
        String sql = "INSERT INTO trains (train_number, destination, departure_time) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, train.getTrainNumber());
            pstmt.setString(2, train.getDestination());
            pstmt.setString(3, train.getDepartureTime());

            pstmt.executeUpdate();
            System.out.println("Train added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to book a ticket
    public void bookTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (user_id, train_id, date_of_journey, seat_number) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, ticket.getUserId());
            pstmt.setInt(2, ticket.getTrainId());
            pstmt.setString(3, ticket.getDateOfJourney());
            pstmt.setInt(4, ticket.getSeatNumber());

            pstmt.executeUpdate();
            System.out.println("Ticket booked successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to list bookings by user ID
    public List<Ticket> listBookingsByUserId(int userId) {
        String sql = "SELECT * FROM tickets WHERE user_id = ?";
        List<Ticket> tickets = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setTrainId(rs.getInt("train_id"));
                ticket.setDateOfJourney(rs.getString("date_of_journey"));
                ticket.setSeatNumber(rs.getInt("seat_number"));
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    // Method to list bookings by user email
    public List<Ticket> listBookingsByUserEmail(String email) {
        String sql = "SELECT t.* FROM tickets t JOIN users u ON t.user_id = u.id WHERE u.email = ?";
        List<Ticket> tickets = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setTrainId(rs.getInt("train_id"));
                ticket.setDateOfJourney(rs.getString("date_of_journey"));
                ticket.setSeatNumber(rs.getInt("seat_number"));
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }

    // Method to list all users
    public List<User> listAllUsers() {
        String sql = "SELECT * FROM users";
        List<User> users = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    // Method to list all bookings
    public List<Ticket> listAllBookings() {
        String sql = "SELECT * FROM tickets";
        List<Ticket> tickets = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt("id"));
                ticket.setUserId(rs.getInt("user_id"));
                ticket.setTrainId(rs.getInt("train_id"));
                ticket.setDateOfJourney(rs.getString("date_of_journey"));
                ticket.setSeatNumber(rs.getInt("seat_number"));
                tickets.add(ticket);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }
}
