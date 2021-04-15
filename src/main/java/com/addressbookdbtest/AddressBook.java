package com.addressbookdbtest;

import java.util.List;

public class AddressBook {
    public enum IOService {
        DB_IO
    }

    private List<AddressBookDB> addressBookDBList;
    public final AddressBookDBService addressBookDBService;

    public AddressBook() {
        addressBookDBService = AddressBookDBService.getInstance();
    }

    public AddressBook(List<AddressBookDB> addressBookList) {
        this();
        this.addressBookDBList = addressBookList;
    }


}
