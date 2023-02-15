fun main() {
    val con = Contact("Jonte", "Yee", "12231", "jonte@ye.com");

    val book = contactList();
    book.addContact("Jonte", "Yee", "123321", "jonte@yee.com");
    book.addContact("Stefan", "Pung", "222123", "stefan@ye.com");

    book.saveContactsToFile();
}