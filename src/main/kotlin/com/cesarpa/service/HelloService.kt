package com.cesarpa.service

import org.springframework.stereotype.Service
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Service
@Path("/hello")
class HelloService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello from Spring"
}