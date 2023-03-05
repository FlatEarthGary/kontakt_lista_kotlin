import java.io.File

class ContactList {
    // lista som innehåller alla kontakter
    private var contacts = mutableListOf<Contact>();
    // Namn på fil som kontakterna är sparade/skrivs till
    private val filename: String = "contacts_database.txt";
    // Funktion som lägger till en kontakt i filen
    fun addContact(first_name: String,last_name: String, phone_number: String, mail: String) {
        // Skapar ett File objekt som låter oss skriva till filen med vårt filename
        // Vi lägger till alla parametrar som funktionen har tagit emot i filen och separerar varje parameter
        // med en newline character (\n)
        File(filename).appendText("${first_name}\n${last_name}\n${phone_number}\n${mail}\n");
    }
    // Funktion som tar bort kontakten med den tillgivna mail adressen
    fun removeContact(mail: String)
    {
        // Skapar en tempoärar lista av kontakter
        var temp_contacts = mutableListOf<Contact>();
        // Läser in alla kontakter och sparar dom i contacts listan
        readContactsFromFile();
        // Itererar över alla kontakter vi nyss läste in
        for (contact: Contact in contacts)
        {
            // Om mail adressen av kontakten inte stämmer överens med mail adressen vi fick som parameter
            if (contact.mail_address != mail)
            {
                temp_contacts.add(contact) // så lägger vi till kontakten i vår temporära lista
            }
        }
        contacts = temp_contacts; // När vi har itererat över alla kontakter och hoppat över dom som stämmer
                                  // med mail adressen så för vi över temp_contacts till contacts
        saveContactsToFile(); // Sparar vår contacts lista til fil
    }
    // Funktion som redigerar en kontakt genom att ta emot mail adressen av kontakten
    fun editContact(editedContact: Contact, oldEmailAdress: String)
    {
        readContactsFromFile() // Läser in kontakterna från filen
        for (contact: Contact in contacts) // Itererar över kontakterna
        {
            if (contact.mail_address == oldEmailAdress) // Om kontaktens mail adress stämmer överens med den tillgivna
                                                        // så ändras alla kontaktens fält till den kontakten som gavs till funktionen
            {
                contact.first_name = editedContact.first_name
                contact.last_name = editedContact.last_name
                contact.phone_number = editedContact.phone_number
                contact.mail_address  = editedContact.mail_address
            }
        }
        saveContactsToFile(); // Sparar till fil
    }

    // Privat funktion som skriver till fil
    private fun saveContactsToFile() { //
        val fileObj = File(filename); // Öppnar filen som vi sparar/skriver till
        fileObj.writeText(""); // Rensar filen
        for (contact: Contact in contacts) { // Itererar över dom nyss inlästa kontakerna
            fileObj.appendText("${contact.first_name}\n${contact.last_name}\n${contact.phone_number}\n${contact.mail_address}\n");
            // Lägger till i filen kontaktens fält separerade med newline
        }
    }

    // Privat funktion som läser från fil och sparar innehållet i vår contacts lista
    private fun readContactsFromFile() {
        var attr = 0; // Variabel som håller koll på hur många fält som skrivits av Contact objektet
        val contact_attr = 4;
        val fileObj = File(filename); // Öppnar filen
        val fileContentString = fileObj.readText(); // Läser in allt innehåll
        contacts.clear(); // Rensar contacts listan
        var fileContent = fileContentString.split('\n'); // Separerar det inlästa innehållet där varje
                                                                   // newline separerar ett fält till Contact klassen

        val amountOfContacts = fileContentString.count { it == '\n'} / contact_attr; // Räknar hur många newline det finns i filen
                                                                                     // och då vi vet att varje Contact objekt består av
                                                                                     // fyra stycken fält så får vi antalet kontakter skrivna
                                                                                     // till filen genom att dividera med fyra

        for (p in 0 until amountOfContacts) // Itererar över mängden kontakter
        {
            // Skapar en ny Contact instans och lägger till den till contacts listan.
            contacts.add(Contact(fileContent[attr], fileContent[attr+1], fileContent[attr+2], fileContent[attr+3]));
            // attr börjar på 0 vilket ger att vi får första värdet i filen, andra värdet genom attr+1 o.s.v

            attr += contact_attr;
            // Vi har skrivit fyra värden vilket ger att vi nu måste hoppa fyra värden framåt för att inte
            // skriva samma värden som innan.

        }
    }

    // Funktion som redigerar en kontakt genom att ta emot ett telefonnummer
    fun editContact(phone_number: String) {
        readContactsFromFile(); // Läser in alla kontakter från fil
        for (contact: Contact in contacts) { // Itererar över kontakterna
            if (phone_number == contact.phone_number) // Om det angivna telefonnumret stämmer med kontaktens telefonnummer
            {
                print("Vad vill du ändra?\n[1] Förnamn\n[2] Efternamn\n[3] Telefonnummer\n[4] Mail adress\n\n[>] ");
                val choice = readln(); // Läser in från användaren
                if (choice == "1")
                {
                    print("Förnamn: ${contact.first_name}\nNytt förnamn: "); // Ger det gamla namnet och sedan frågar efter det nya
                    contact.first_name = readln(); // Läser in det nya värdet och tillger det kontaktens fält
                }
                else if (choice == "2") {
                    print("Efternamn: ${contact.last_name}\nNytt efternamn: ");
                    contact.last_name = readln();
                }
                else if (choice == "3") {
                    print("Telefonnummer: ${contact.phone_number}\nNytt telefonnummer: ");
                    contact.phone_number = readln();
                }
                else if (choice == "4") {
                    print("Mail adress: ${contact.mail_address}\nNy mail adress: ");
                    contact.mail_address = readln();
                }
                else { // Om inget icke valbart alternativ finns
                    println("Icke valbart alternativ!");
                    return;
                }
                saveContactsToFile(); // Skriver förändringarna till fil
                return;
            }
        }
        println("Kunde inte hitta kontakten :(");
    }

    // Funktion som skriver ut hela telefonlistan
    fun printFullContactList() {
        readContactsFromFile(); // Läser in alla kontakter från fil
        contacts.sortBy { it.first_name }; // Sorterar dom efter förnamn
        for (con: Contact in contacts) // Itererar över kontakterna
        {
            // Skriver ut värdena
            println("First name: ${con.first_name} | Last name: ${con.last_name} | Phone number: ${con.phone_number} | Mail address: ${con.mail_address}");
        }
    }
}