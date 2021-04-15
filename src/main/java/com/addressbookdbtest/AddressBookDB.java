package com.addressbookdbtest;

import java.util.List;
import java.util.Objects;

public class AddressBookDB {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private int zip;
    private long phone;
    private String email;
    private Object addressBookList;


    public AddressBookDB(String firstName, String lastName, String address, String city, String state, int zip, long phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public AddressBookDB() {

    }


    @Override
    public String toString() {
        return "AddressBookData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBookDB that = (AddressBookDB) o;
        return zip == that.zip && phone == that.phone && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(address, that.address) && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(email, that.email);
    }


    public List<AddressBookDB> readAddressBookData(AddressBook.IOService ioService) {
        AddressBookDBService addressBookDBService = new AddressBookDBService();
        if (ioService.equals(AddressBook.IOService.DB_IO))
            return (List<AddressBookDB>) (this.addressBookList = addressBookDBService.getAddressBookDataUsingDB());
        return null;
    }
}
