package io.jventura.weather;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Jose Henrique Ventura 03 Feb 2019
 */
@Path("/weather")
@RequestScoped
public class WeatherEndpoint {
    
    private WeatherGateway weatherGateway;
    private ResourceProvider resourceProvider;

    @Inject
    public WeatherEndpoint(WeatherGateway weatherGateway, ResourceProvider resourceProvider) {
        this.weatherGateway =  weatherGateway;
        this.resourceProvider = resourceProvider;
    }

    @GET
    @Path(value = "/greeting")
    @Produces(MediaType.TEXT_PLAIN)
    public String weatherGreeting(){
        return resourceProvider.getAppWeatherGreeting();
    }
    
    @GET
    @Path(value = "/statusOfDay")
    @Produces(MediaType.TEXT_PLAIN)
    public String statusOfDay(){
        return weatherGateway.statusOfDayByAccuWeather();
    }
}
