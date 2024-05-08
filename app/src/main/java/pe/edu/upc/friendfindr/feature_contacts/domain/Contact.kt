package pe.edu.upc.friendfindr.feature_contacts.domain
typealias Contacts = List<Contact>
data class Contact(
    val id: String,
    val title: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val cell: String,
    val gender: String,
    val location: String,
    val picture: String,
    var isFavorite: Boolean = false
)
