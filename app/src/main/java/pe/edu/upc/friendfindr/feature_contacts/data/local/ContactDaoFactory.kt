package pe.edu.upc.friendfindr.feature_contacts.data.local

import pe.edu.upc.friendfindr.core_database.AppDatabase
import pe.edu.upc.friendfindr.MyApplication

class ContactDaoFactory private  constructor(){
    companion object{
        fun getContactDao(): ContactDao{
            return AppDatabase.getInstance(MyApplication.getContext()).getContactDao()
        }
    }
}