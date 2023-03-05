import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class ContactList {
    private var contacts = mutableListOf<Contact>();
    private val filename: String = "contacts_database.txt";
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
        fileObj.writeText("");
        for (contact: Contact in contacts) {
            fileObj.appendText("${contact.first_name}\n${contact.last_name}\n${contact.phone_number}\n${contact.mail_address}\n");
        }

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

    fun editContact(phone_number: String) {
        for (contact: Contact in contacts) {
            if (phone_number == contact.phone_number)
            {
                println("Vad vill du ändra?\n[1] Förnamn\n[2] Efternamn\n[3] Telefonnummer\n[4] Mail adress\n\n[>] ");
                val choice = readln();
                if (choice == "1")
                {
                    println("Förnamn: ${contact.first_name}\nNytt förnamn: ");
                    contact.first_name = readln();
                }
                else if (choice == "2") {
                    println("Efternamn: ${contact.last_name}\nNytt efternamn: ");
                    contact.last_name = readln();
                }
                else if (choice == "3") {
                    println("Telefonnummer: ${contact.phone_number}\nNytt telefonnummer: ");
                    contact.phone_number = readln();
                }
                else if (choice == "4") {
                    println("Mail adress: ${contact.mail_address}\nNy mail adress: ");
                    contact.mail_address = readln();
                }
                else {
                    println("Icke valbart alternativ!");
                    return;
                }
                saveContactsToFile();
                return;
            }
        }
        println("Kunde inte hitta kontakten :(");
    }

    fun printFullContactList() {
        for (con in contacts)
        {
            println("First name: ${con.first_name} | Last name: ${con.last_name} |Phone number: ${con.phone_number} | Mail address: ${con.mail_address}");
        }
    }
}