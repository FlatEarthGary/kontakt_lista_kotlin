import kotlin.contracts.contract

fun main() {
    val book = ContactList();


    book.addContact("Oliver","Fisk","123","oliver@fisk.se");
    book.addContact("Jeff", "Jefferson", "+46 432453211", "jeff@jeff.se");
    book.addContact("Anders", "A", "123321", "anders@gmail.com");

    /*
    val yee = Contact("robban", "roberson", "12332131221", "robert@robban.se");
    book.editContact(yee, "anders@gmail.com");
    */

    //book.removeContact("oliver@fisk.se");
    book.printFullContactList();

    //book.addContact("Stefan", "Pung", "33333", "stefan@pung.com");

    /* FiskTest*/

    /*
    var newcontact = Contact("Oliver","Fisk","546","oliver@fisk.se")

    book.editContact(newcontact, "oliver@fisk.se")
     */
    /* No more FiskTest*/
}