package io.jventura.weather;

import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.helidon.common.CollectionsHelper;

/**
 * @author Jose Henrique Ventura 03 Feb 2019
 */
@ApplicationScoped
@ApplicationPath("/")
public class WeatherApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return CollectionsHelper.setOf(WeatherEndpoint.class);
    }
}
