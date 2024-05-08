package pe.edu.upc.friendfindr.feature_contacts.data.remote


data class ResultsResponse(
    val results: List<ContactResponse>,
    val info: Info
)

data class Info(
    val seed: String,
    val results: Int,
    val page: Int,
    val version: String
)

data class ContactResponse(
    val id: Id,
    val name: Name,
    val email: String,
    val cell: String,
    val gender: String,
    val location: Location,
    val picture: Picture
)
data class Id(
    val value: String
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Location(
    val city: String
)

data class Picture(
    val thumbnail: String
)