package com.example.barivara.Data.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.barivara.Data.Dao.DataAccessObject
import com.example.barivara.Data.Entities.*

@Database(
    entities = [Owner::class, Renter::class, Earned::class, FlatRentAmount::class, Remain::class],
    version = 9
)
abstract class BariVaraDB: RoomDatabase() {

    abstract fun getDao() :DataAccessObject

    companion object{
        val migration_1_to_2 = object : Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `Earned` (`monthWithYear` TEXT NOT NULL, `date` INTEGER NOT NULL, `renterId` INTEGER NOT NULL, `ownerID` INTEGER NOT NULL, PRIMARY KEY(`monthWithYear`))")
                database.execSQL("ALTER TABLE Earned ADD COLUMN amount INTEGER NOT NULL DEFAULT(0)")


            }

        }
        val migration_2_to_3 = object : Migration(2, 3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Earned ADD COLUMN flatId INTEGER NOT NULL DEFAULT(0)")


            }

        }
        val migration_3_to_4 = object : Migration(3, 4){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Owner RENAME COLUMN id TO ownerId")
                database.execSQL("ALTER TABLE Renter RENAME COLUMN id TO renterId")


            }

        }
        val migration_4_to_5 = object : Migration(4, 5){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE FlatRentAmount ADD COLUMN flatRenterId INTEGER NOT NULL")
                database.execSQL("DROP TABLE Renter")
                database.execSQL("CREATE TABLE IF NOT EXISTS `Remain` (`remainId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `renterId` INTEGER NOT NULL, `ownerId` INTEGER NOT NULL, `remainAmount` INTEGER NOT NULL, `note` TEXT NOT NULL)")



            }

        }
        val migration_5_to_6 = object : Migration(5, 6){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `Renter` (`renterId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT NOT NULL, `age` INTEGER NOT NULL, `phonse` TEXT NOT NULL, `nId` TEXT NOT NULL, `email` TEXT NOT NULL, `rentedFlatId` INTEGER NOT NULL, `ownerId` INTEGER NOT NULL)")


            }

        }
        val migration_6_to_7 = object : Migration(6, 7){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Renter ADD COLUMN startingMonthYear TEXT NOT NULL default(0)")
                database.execSQL("ALTER TABLE FlatRentAmount ADD COLUMN isRented INTEGER NOT NULL default(0)")
                database.execSQL("ALTER TABLE Remain ADD COLUMN flatId INTEGER NOT NULL default(0)")


            }

        }
        val migration_7_to_8 = object : Migration(7, 8){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DROP TABLE Earned")


            }

        }
        val migration_8_to_9 = object : Migration(8, 9){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS `Earned` (`earnedId` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date` INTEGER NOT NULL, `renterId` INTEGER NOT NULL, `ownerID` INTEGER NOT NULL, `amount` INTEGER NOT NULL, `flatId` INTEGER NOT NULL)")

            }

        }
        @Volatile
        private var INSTANCE: BariVaraDB? = null
        fun getInstance(context: Context):BariVaraDB{
            synchronized(this){
                if(INSTANCE==null){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        BariVaraDB::class.java,
                        "BariVara"
                    ).addMigrations(
                        migration_1_to_2,
                        migration_2_to_3,
                        migration_3_to_4,
                        migration_4_to_5,
                        migration_5_to_6,
                        migration_6_to_7,
                        migration_7_to_8,
                        migration_8_to_9
                    ).build()
                }
                return INSTANCE!!
            }
        }
    }
}