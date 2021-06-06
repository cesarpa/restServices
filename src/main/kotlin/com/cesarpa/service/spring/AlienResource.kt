package com.cesarpa.service.spring

import com.cesarpa.model.Alien
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class AlienResource {

    @RequestMapping("spring")
    fun getAlien(): List<Alien> {
        return listOf<Alien>(
            Alien(4, "iti", 777),
            Alien(5, "alex", 788)
        )
    }
}