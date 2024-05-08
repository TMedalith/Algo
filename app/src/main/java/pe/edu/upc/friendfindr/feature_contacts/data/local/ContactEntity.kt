package pe.edu.upc.friendfindr.feature_contacts.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class ContactEntity(
    @PrimaryKey()
    val id: String,
)