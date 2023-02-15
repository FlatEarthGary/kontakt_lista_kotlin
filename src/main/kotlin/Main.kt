fun main() {
    val con = Contact("Jonte", "Yee", "12231", "jonte@ye.com");
    val name = contactList()
    name.addContact("Fisk", "Ett", "1337", "fisk@dx.com")
    name.removeContact("Fisk", "Ett", "1337", "Fisk@dx.com")
}