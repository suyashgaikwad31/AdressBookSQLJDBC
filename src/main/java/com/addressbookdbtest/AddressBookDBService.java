package com.addressbookdbtest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService {
    private static AddressBookDBService addressBookDBService;

    public static AddressBookDBService getInstance() {
        if (addressBookDBService == null)
            addressBookDBService = new AddressBookDBService();
        return addressBookDBService;
    }

    private Connection getConnection() throws SQLException {
        String jdbcURL = "jdbc:mysql://localhost:3306/ addressbookdb?useSSL=false";
        String userName = "root";
        String password = "Suy31@ash";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!" + connection);
        return connection;
    }

    public List<AddressBookDB> getAddressBookDataUsingDB() {
        String sql = "SELECT * FROM Address_Book";
        List<AddressBookDB> addressBookList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            addressBookList = getAddressBookDBList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    private List<AddressBookDB> getAddressBookDBList(ResultSet resultSet) {
        List<AddressBookDB> addressBookDataList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                long phone = resultSet.getLong("phoneNumber");
                String email = resultSet.getString("email");
                addressBookDataList.add(new AddressBookDB(firstName, lastName, address, city, state, zip, phone, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookDataList;
    }
}
