package pe.edu.upc.friendfindr.feature_contacts.data.remote

import pe.edu.upc.friendfindr.core_network.ApiClient
import pe.edu.upc.friendfindr.core_network.RetrofitFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ContactServiceFactory private constructor(){
   companion object{
       fun getContactService(): ContactService {
           return RetrofitFactory.getRetrofit().create(ContactService::class.java)
       }
   }
}