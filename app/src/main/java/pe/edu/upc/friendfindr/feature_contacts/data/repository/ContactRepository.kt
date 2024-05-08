package pe.edu.upc.friendfindr.feature_contacts.data.repository

import android.util.Log
import pe.edu.upc.friendfindr.feature_contacts.data.local.ContactDao
import pe.edu.upc.friendfindr.feature_contacts.data.local.ContactDaoFactory
import pe.edu.upc.friendfindr.feature_contacts.data.local.ContactEntity
import pe.edu.upc.friendfindr.feature_contacts.data.remote.ContactService
import pe.edu.upc.friendfindr.feature_contacts.data.remote.ContactServiceFactory
import pe.edu.upc.friendfindr.feature_contacts.data.remote.ResultsResponse
import pe.edu.upc.friendfindr.feature_contacts.domain.Contact
import pe.edu.upc.friendfindr.feature_contacts.domain.Contacts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactRepository(
    private val contactService: ContactService = ContactServiceFactory.getContactService(),
    private val contactDao: ContactDao = ContactDaoFactory.getContactDao()
) {

    fun insert(id: String) {
        contactDao.insert(ContactEntity(id))
    }

    fun delete(id: String) {
        contactDao.delete(ContactEntity(id))
    }

    fun isFavorite(id: String): Boolean {
        return (contactDao.fetchById(id) != null)
    }

    fun getAll(callback: (Contacts) -> Unit, number: Int) {
        val getAll = contactService.getAll(number)

        getAll.enqueue(object : Callback<ResultsResponse> {
            override fun onResponse(
                call: Call<ResultsResponse>,
                response: Response<ResultsResponse>
            ) {
                if (response.isSuccessful) {
                    val contactsResponse = response.body() as ResultsResponse
                    var contacts: Contacts = arrayListOf()
                    for (contactResponse in contactsResponse.results) {
                        val id = contactResponse.id.value
                        if (id != null) {
                            contacts = contacts + Contact(
                                id,
                                contactResponse.name.title,
                                contactResponse.name.first,
                                contactResponse.name.last,
                                contactResponse.email,
                                contactResponse.cell,
                                contactResponse.gender,
                                contactResponse.location.city,
                                contactResponse.picture.thumbnail,
                                isFavorite(id)
                            )
                        } else {
                            // Handle the situation where id is null
                        }
                    }
                    callback(contacts)
                }
            }

            override fun onFailure(call: Call<ResultsResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("RestaurantRepository", it)
                }
            }
        })
    }
}