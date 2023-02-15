import java.io.File

class contactList {
    var contacts = mutableListOf<Contact>()
    fun addContact(first_name: String, ) {

    }

    fun saveContactsToFile() {
        val fileObj = File("contacts_database.txt");
        for (contact: Contact in contacts) {
            fileObj.writeText("${contact.first_name},${contact.last_name}, ${contact.mail_address}, ${contact.phone_number}\n");
        }
        println("Successfully written to database");
    }

}