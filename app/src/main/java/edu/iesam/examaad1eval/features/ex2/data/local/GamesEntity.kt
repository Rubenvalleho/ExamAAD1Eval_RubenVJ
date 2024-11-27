package edu.iesam.examaad1eval.features.ex2.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import edu.iesam.examaad1eval.features.ex2.domain.Player

@Entity(tableName = "GamesEntity")

data class GamesEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "player") val player: List<Player>
) {
}