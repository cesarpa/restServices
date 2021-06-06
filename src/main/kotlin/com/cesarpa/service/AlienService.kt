package com.cesarpa.service

import com.cesarpa.model.Alien
import com.cesarpa.repositories.AlienRepository
import org.springframework.stereotype.Service
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Service
@Path("/alien")
class AlienService {

    var repo: AlienRepository = AlienRepository()

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAlien(): List<Alien>? {
        println("Im in the Alien Service")
        return repo.getAlienData()
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAlienbyId(@PathParam("id") id: Int): Alien? {
        return repo.getAlienById(id)
    }

    @POST
    @Path("save")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun createAlien(a: Alien): Alien {
        println(a)
        repo.createAlien(a)
        return a
    }

    @PUT
    @Path("update")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateAlien(a: Alien): Alien {
        println(a)
        if (a.id == null) {
            repo.createAlien(a)
        } else {
            repo.updateAlien(a)
        }
        return a
    }


    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun deleteAlien(@PathParam("id") id: Int) {
        if (id != null) {
            repo.deleteAlien(id)
            print("successfully deleted")
        }
    }

}
