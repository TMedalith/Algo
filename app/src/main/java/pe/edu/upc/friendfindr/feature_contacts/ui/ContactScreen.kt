package pe.edu.upc.friendfindr.feature_contacts.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.glide.GlideImage
import pe.edu.upc.friendfindr.feature_contacts.data.repository.ContactRepository
import pe.edu.upc.friendfindr.feature_contacts.domain.Contact

@Composable
fun ContactScreen( contactRepository: ContactRepository = ContactRepository()) {
    val contacts = remember { mutableStateOf(emptyList<Contact>()) }
    val inputNumber = remember { mutableStateOf("") }

    Column {
        TextField(
            value = inputNumber.value,
            onValueChange = { inputNumber.value = it },
            label = { Text("Enter number of contacts") }
        )
        Button(onClick = {
            val number = inputNumber.value.toIntOrNull() ?: 0
            contactRepository.getAll({it -> contacts.value = it},number)
        }) {
            Text("Show Contacts")
        }

        LazyColumn {
            items(contacts.value) { contact ->
                ContactItem(contact, contactRepository)
            }
        }
    }

}

@Composable
fun ContactItem(contact: Contact, contactRepository: ContactRepository) {
    Row(modifier = Modifier.fillMaxWidth()) {
        GlideImage(
            modifier = Modifier.size(50.dp),
            imageModel = { contact.picture },
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = contact.firstName)
            Text(text = contact.lastName)
            Text(text = contact.email)
            Text(text = contact.cell)
        }
        IconButton(onClick = {
            if (contact.isFavorite) {
                contactRepository.delete(contact.id)
            } else {
                contactRepository.insert(contact.id)
            }
        }) {
            Icon(
                imageVector = if (contact.isFavorite) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
                contentDescription = "Favorite Icon"
            )
        }
    }

}

