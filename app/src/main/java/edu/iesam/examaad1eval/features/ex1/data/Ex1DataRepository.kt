package edu.iesam.examaad1eval.features.ex1.data

import edu.iesam.examaad1eval.features.ex1.data.local.Ex1XmlLocalDataSource
import edu.iesam.examaad1eval.features.ex1.data.remote.MockEx1RemoteDataSource
import edu.iesam.examaad1eval.features.ex1.domain.Ex1Repository
import edu.iesam.examaad1eval.features.ex1.domain.Item
import edu.iesam.examaad1eval.features.ex1.domain.Services
import edu.iesam.examaad1eval.features.ex1.domain.User

class Ex1DataRepository(
    private val localDataSource: Ex1XmlLocalDataSource,
    private val remoteDataSource: MockEx1RemoteDataSource
) : Ex1Repository {
    override fun getUsers(): List<User> {
        val usersFromLocal = localDataSource.getUsers()
        return if (usersFromLocal == null) {
            val usersFromRemote = remoteDataSource.getUsers()
            localDataSource.saveUsers(usersFromRemote)
            usersFromRemote
        } else {
            usersFromLocal
        }
    }

    override fun getItems(): List<Item> {
        val itemsFromLocal = localDataSource.getItems()
        return if (itemsFromLocal == null) {
            val itemsFromRemote = remoteDataSource.getItems()
            localDataSource.saveItems(itemsFromRemote)
            itemsFromRemote
        } else {
            itemsFromLocal
        }
    }

    override fun getServices(): List<Services> {
        val servicesFromLocal = localDataSource.getServices()
        return if (servicesFromLocal == null) {
            val servicesFromRemote = remoteDataSource.getServices()
            localDataSource.saveServices(servicesFromRemote)
            servicesFromRemote
        } else {
            servicesFromLocal
        }
    }
}