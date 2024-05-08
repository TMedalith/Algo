package pe.edu.upc.friendfindr.core_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pe.edu.upc.friendfindr.feature_contacts.data.local.ContactDao
import pe.edu.upc.friendfindr.feature_contacts.data.local.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getContactDao(): ContactDao

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "database")
                    .allowMainThreadQueries()
                    .build()
            }
            return appDatabase as AppDatabase
        }
    }
}