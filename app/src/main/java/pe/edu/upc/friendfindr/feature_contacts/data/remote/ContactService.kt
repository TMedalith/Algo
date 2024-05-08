package pe.edu.upc.friendfindr.feature_contacts.data.remote

import pe.edu.upc.friendfindr.feature_contacts.data.local.ContactEntity
import pe.edu.upc.friendfindr.feature_contacts.domain.Contact
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ContactService {
    @GET("api/")
     fun getAll(@Query("results") number: Int): Call<ResultsResponse>
}