package io.jventura.weather;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.spi.CDI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import io.helidon.microprofile.server.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WeatherTest {
    private static Server server;

    @BeforeAll
    public static void startTheServer(){
        server = Server.create().start();
    }

    @Test
    void testHelloWorld() {
        Client client = ClientBuilder.newClient();
        String response = client.target(getConnectionString("/weather/statusOfDay"))
                .request().get(String.class);
        
        Assertions.assertEquals("A beautiful day", response, "default message");
    }

    @AfterAll
    static void destroyClass() {
        CDI<Object> current = CDI.current();
        SeContainer sec = (SeContainer) current;
        sec.close();
    }

    private String getConnectionString(String path) {
        return "http://localhost:" + server.port() + path;
    }
}
