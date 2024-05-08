package pe.edu.upc.friendfindr.feature_contacts.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
 interface ContactDao {
     @Insert()
     fun insert(contact: ContactEntity)

     @Delete
     fun delete(contact: ContactEntity)

     @Query("select * from contacts")
     fun fetchAll(): List<ContactEntity>

     @Query("select * from contacts where id=:id")
     fun fetchById(id: String): ContactEntity?


 }