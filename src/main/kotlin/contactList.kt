import java.io.File

class contactList {
    var contacts = mutableListOf<Contact>();
    val filename: String = "contacts_database.txt";
    fun addContact(first_name: String, ) {

    }

    fun saveContactsToFile() {
        val fileObj = File(filename);
        for (contact: Contact in contacts) {
            fileObj.writeText("${contact.first_name},${contact.last_name}, ${contact.mail_address}, ${contact.phone_number}\n");
        }
        println("Successfully written to database");
    }

    fun readContactsFromFile() {
        val fileObj = File(filename);
        val fileContent: String = fileObj.readText();
        val amountOfContacts: Int = fileContent.count {it == ';'}
        for (i: Int in 0 until 4) {

        }
    }

}