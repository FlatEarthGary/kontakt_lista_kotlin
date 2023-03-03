import java.io.File

class contactList {
    var contacts = mutableListOf<Contact>();
    val filename: String = "contacts_database.txt";
    fun addContact(first_name: String,last_name: String, phone_number: String, mail: String) {
       contacts.add(Contact(first_name, last_name, phone_number, mail));
    }

    fun saveContactsToFile() {
        val fileObj = File(filename);
        for (contact: Contact in contacts) {
            fileObj.appendText("${contact.first_name},${contact.last_name},${contact.mail_address},${contact.phone_number}\n");
        }
        println("Successfully written to database");
    }

    fun readContactsFromFile() {
        val fileObj = File(filename);
        val fileContentString = fileObj.readText();

        var fileContent = fileContentString.split(',');

        val amountOfContacts = fileContentString.count { it == ','} / 3;

        for (i in 0 until amountOfContacts)
        {
            for (i in fileContent)
            {
                println(i);
            }
            println("----------------------------");
            readln();

            contacts.add(Contact(fileContent[0], fileContent[1], fileContent[2], fileContent[3]));

            fileContent = fileContent.drop(4);

        }
    }

    fun printAll() {
        for (con in contacts)
        {
            println("Contact: ${con.first_name}");
        }
    }
}