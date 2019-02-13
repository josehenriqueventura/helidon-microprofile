package io.jventura.weather;

import java.io.IOException;
import java.util.logging.LogManager;

import io.helidon.microprofile.server.Server;

/**
 * @author Jose Henrique Ventura 03 Feb 2019
 */
public final class Main {
   
    private Main() { }
    
    public static void main(final String[] args) throws IOException {
        //Load Logging Properties
        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        
        //Start the server
        Server.create().start();
    }
}
