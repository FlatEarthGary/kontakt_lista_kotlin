fun main() {
    val book = ContactList();

    /*
    book.addContact("Jonte", "Yee", "123321123", "yee@gmail.com");
    book.addContact("Sven", "Pung", "321321321", "pung@gmail.com");
    book.addContact("Stefan", "Feg", "222222", "steffe@yahoo.com");

    book.saveContactsToFile();
     */

    book.readContactsFromFile();

    book.editContact("123321123");


}