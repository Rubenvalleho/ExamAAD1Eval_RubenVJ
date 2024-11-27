package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val remoteDataSource: MockEx1RemoteDataSource,
    private val localDataSource: Ex1XmlLocalDataSource
) : Ex1Repository {

    override fun getUsers(): List<User> {
        val usersFromLocal = localDataSource.getUserList()
        if (usersFromLocal!!.isEmpty()) {
            val usersFromRemote = remoteDataSource.getUsers()
            localDataSource.saveUsers(usersFromRemote)
            return usersFromRemote
        }
        return usersFromLocal
    }

    override fun getItems(): List<Item> {
        val itemsFromLocal = localDataSource.getItemList()
        if (itemsFromLocal.isEmpty()) {
            val itemsFromRemote = remoteDataSource.getItems()
            localDataSource.saveItems(itemsFromRemote)
            return itemsFromRemote
        }
        return itemsFromLocal
    }

    override fun getServices(): List<Services> {
        val servicesFromLocal = localDataSource.getServiceList()
        if (servicesFromLocal.isEmpty()) {
            val servicesFromRemote = remoteDataSource.getServices()
            localDataSource.saveServices(servicesFromRemote)
            return servicesFromRemote
        }
        return servicesFromLocal
    }
}