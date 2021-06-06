package com.cesarpa.config

import com.cesarpa.service.AlienService
import com.cesarpa.service.HelloService
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration

@Configuration
class JerseyConfig : ResourceConfig {

    constructor() {
        register(AlienService::class.java)
        register(HelloService::class.java)
    }
}