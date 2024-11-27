package edu.iesam.examaad1eval.features.ex2.data.local

import edu.iesam.examaad1eval.features.ex2.domain.Game

fun Game.toEntity(): GamesEntity {
    return GamesEntity(
        this.id,
        this.title,
        this.player
    )
}

fun GamesEntity.toGame(): Game {
    return Game(
        this.id,
        this.title,
        this.player
    )
}