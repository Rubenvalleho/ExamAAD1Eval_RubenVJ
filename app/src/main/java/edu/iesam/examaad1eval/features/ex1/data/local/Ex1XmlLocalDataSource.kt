package edu.iesam.examaad1eval.features.ex1.data.local

import android.content.Context
import com.google.gson.Gson
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1XmlLocalDataSource(context: Context, private val gson: Gson) {

    private val sharedPreferences = context.getSharedPreferences("db-exam", Context.MODE_PRIVATE)

    fun saveUsers(users: List<User>) {
        sharedPreferences.edit().putStringSet("users", users.map { gson.toJson(it) }.toSet())
            .apply()
    }

    fun getUserList(): List<User> {
        val userList = ArrayList<User>()
        sharedPreferences.getStringSet("users", null)?.let {
            val list = gson.fromJson(it.toString(), Array<User>::class.java).toList()
            list.forEach {
                userList.add(it)
            }
        }
        return userList
    }

    fun saveItems(items: List<Item>) {
        sharedPreferences.edit().putStringSet("items", items.map { gson.toJson(it) }.toSet())
            .apply()
    }

    fun getItemList(): List<Item> {
        val itemList = ArrayList<Item>()
        sharedPreferences.getStringSet("items", null)?.let {
            val list = gson.fromJson(it.toString(), Array<Item>::class.java).toList()
            list.forEach {
                itemList.add(it)
            }
        }
        return itemList
    }


    fun saveServices(services: List<Services>) {
        sharedPreferences.edit().putStringSet("services", services.map { gson.toJson(it) }.toSet())
            .apply()
    }

    fun getServiceList(): List<Services> {
        val serviceList = ArrayList<Services>()
        sharedPreferences.getStringSet("services", null)?.let {
            val list = gson.fromJson(it.toString(), Array<Services>::class.java).toList()
            list.forEach {
                serviceList.add(it)
            }
        }
        return serviceList

    }
}