import kotlin.contracts.contract

fun main() {
    val book = ContactList();

    book.addContact("Oliver","Fisk","123","oliver@fisk.se");
    book.saveContactsToFile()
    book.readContactsFromFile();

    /* FiskTest*/
    var newcontact = Contact("Oliver","Fisk","546","oliver@fisk.se")

    book.editContact(newcontact, "oliver@fisk.se")

    /* No more FiskTest*/

    book.printAll();
}