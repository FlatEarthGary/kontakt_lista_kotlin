class contactList {
    var contacts = mutableListOf<Contact>()
    fun addContact(first_name: String,last_name: String, phone_number: String, mail: String) {
       contacts.add(Contact(first_name, last_name, phone_number, mail))

    }
    fun removeContact(first_name: String, last_name: String, phone_number: String, mail: String){
        contacts.remove(Contact(first_name, last_name, phone_number, mail))
    }

}