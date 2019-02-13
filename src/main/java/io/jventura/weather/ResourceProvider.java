package io.jventura.weather;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * @author Jose Henrique Ventura 03 Feb 2019
 */
@ApplicationScoped
public class ResourceProvider {

    @Inject @ConfigProperty(name = "app.weatherAppGreeting")
    private String appWeatherAppGreeting;

    public String getAppWeatherGreeting() {
        return appWeatherAppGreeting;
    }
}
