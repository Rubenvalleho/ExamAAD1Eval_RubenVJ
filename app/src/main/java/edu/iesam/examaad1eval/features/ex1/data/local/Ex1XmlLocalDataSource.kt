package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(context: Context) {

    val sharedPreferences = context.getSharedPreferences("db-exam", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveUsers(users: List<User>) {
        val userListJson = gson.toJson(users)
        sharedPreferences.edit().putString("users", userListJson).apply()
    }

    fun getUsers(): List<User>? {
        val userListJson = sharedPreferences.getString("users", null)
        if (userListJson != null) {
            return gson.fromJson(userListJson, Array<User>::class.java).toList()
        } else {
            return null
        }
    }

    fun saveItems(items: List<Item>) {
        val itemListJson = gson.toJson(items)
        sharedPreferences.edit().putString("items", itemListJson).apply()
    }

    fun getItems(): List<Item>? {
        val itemListJson = sharedPreferences.getString("items", null)
        if (itemListJson != null) {
            return gson.fromJson(itemListJson, Array<Item>::class.java).toList()
        } else {
            return null
        }
    }

    fun saveServices(services: List<Services>) {
        val servicesListJson = gson.toJson(services)
        sharedPreferences.edit().putString("services", servicesListJson).apply()
    }

    fun getServices(): List<Services>? {
        val servicesListJson = sharedPreferences.getString("services", null)
        if (servicesListJson != null) {
            return gson.fromJson(servicesListJson, Array<Services>::class.java).toList()
        } else {
            return null
        }
    }
}