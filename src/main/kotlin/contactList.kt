import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class contactList {
    var contacts = mutableListOf<Contact>();
    val filename: String = "contacts_database.txt";
    fun addContact(first_name: String,last_name: String, phone_number: String, mail: String) {
       contacts.add(Contact(first_name, last_name, phone_number, mail));
    }

    fun saveContactsToFile() {
        /*
        val fileObj: FileOutputStream = FileOutputStream("contacts_database.bin"); // Ändra till filename
        val stream = ObjectOutputStream(fileObj);

        val test = Contact("a", "a", "a", "a");
         */

        val fileObj = File(filename);
        for (contact: Contact in contacts) {
            fileObj.appendText("${contact.first_name}\n${contact.last_name}\n${contact.mail_address}\n${contact.phone_number}\n");
        }
        println("Successfully written to database");

    }

    fun readContactsFromFile() {
        var i = 0;
        val fileObj = File(filename);
        val fileContentString = fileObj.readText();

        var fileContent = fileContentString.split('\n');

        val amountOfContacts = fileContentString.count { it == '\n'} / 4;

        for (p in 0 until amountOfContacts)
        {
            contacts.add(Contact(fileContent[i], fileContent[i+1], fileContent[i+2], fileContent[i+3]));

            i += 4;

        }

    }

    fun printAll() {
        for (con in contacts)
        {
            println("Contact: ${con.first_name} | ${con.last_name} | ${con.phone_number} | ${con.mail_address}");
        }
    }
}