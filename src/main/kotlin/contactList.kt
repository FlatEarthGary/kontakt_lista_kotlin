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
    fun removeContact(mail: String)
    {
        var tempcontacts = mutableListOf<Contact>();
        readContactsFromFile();
        for (contact: Contact in contacts)
        {
            if (contact.mail_address != mail)
            {
                tempcontacts.add(contact)
            }
        }
        contacts = tempcontacts;
        saveContactsToFile();
    }
    fun editContact(editedContact: Contact, oldEmailAdress: String)
    {
        readContactsFromFile();
        for (contact: Contact in contacts)
        {
            if (contact.mail_address == oldEmailAdress)
            {
                contact.first_name = editedContact.first_name
                contact.last_name = editedContact.last_name
                contact.phone_number = editedContact.phone_number
                contact.mail_address  = editedContact.mail_address
            }
        }
        saveContactsToFile();
    }

    fun saveContactsToFile() {
        /*
        val fileObj: FileOutputStream = FileOutputStream("contacts_database.bin"); // Ändra till filename
        val stream = ObjectOutputStream(fileObj);

        val test = Contact("a", "a", "a", "a");
         */

        val fileObj = File(filename);
        for (contact: Contact in contacts) {
            fileObj.appendText("${contact.first_name}\n${contact.last_name}\n${contact.phone_number}\n${contact.mail_address}\n");
        }
        println("Successfully written to database");

    }

    fun readContactsFromFile() {
        var i = 0;
        val fileObj = File(filename);
        val fileContentString = fileObj.readText();
        contacts.clear();
        var fileContent = fileContentString.split('\n');

        val amountOfContacts = fileContentString.count { it == '\n'} / 4;

        for (p in 0 until amountOfContacts)
        {
            contacts.add(Contact(fileContent[i], fileContent[i+1], fileContent[i+2], fileContent[i+3]));

            i += 4;

        }

    }

    fun printAll() {
        contacts.sortBy { it.first_name  }
        for (con in contacts)
        {
            println("Contact: ${con.first_name} | ${con.last_name} | ${con.phone_number} | ${con.mail_address}");
        }
    }
}