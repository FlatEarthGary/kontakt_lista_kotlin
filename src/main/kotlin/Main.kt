import kotlin.contracts.contract

fun main() {
    val book = contactList();


/*    book.addContact("Jonte", "Yee", "123321123", "yee@gmail.com");
    book.addContact("Sven", "Pung", "321321321", "pung@gmail.com");
    book.addContact("Stefan", "Feg", "222222", "steffe@yahoo.com");
    book.saveContactsToFile() */
    book.addContact("Oliver","Fisk","123","oliver@fisk.se");
    book.saveContactsToFile()
    book.readContactsFromFile();

    /* FiskTest*/
    var newcontact = Contact("Oliver","Fisk","546","oliver@fisk.se")

    book.editContact(newcontact, "oliver@fisk.se")

    /* No more FiskTest*/

    book.printAll();

}