package com.addressbookdbtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookDBTest {
    @Test
    public void givenContactsInDB_WhenRetrieved_ShouldMatchCount() {
        AddressBookDB addressBookDB = new AddressBookDB();
       List<AddressBookDB> addressBookDBList = addressBookDB.readAddressBookData(AddressBook.IOService.DB_IO);
        Assertions.assertEquals(0, addressBookDBList.size());
    }
}
