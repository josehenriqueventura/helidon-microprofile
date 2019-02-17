package io.jventura.weather;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;

/**
 * @author Jose Henrique Ventura 03 Feb 2019
 */
@RequestScoped
public class WeatherGateway {
    private static final Logger LOGGER = Logger.getLogger(WeatherGateway.class.getName());

    @Timeout(50)
    @Retry(maxRetries = 3)
    @Fallback(fallbackMethod = "statusOfWeekByMetEireann")
    @CircuitBreaker(requestVolumeThreshold=3, failureRatio=0.5, successThreshold=3)
    public String statusOfDayByAccuWeather(){
        return longRunningTask();
    }

    /**
     * 
     * @return Status of the Day
     */
    public String statusOfWeekByMetEireann(){
        LOGGER.log(Level.WARNING, "MetEireann backup service has been requested due to AccuWeather timeout");
        return "A beautiful day";
    }

    /**
     * Simulate a long processing task of 80ms
     * 
     * @return null
     */
    private String longRunningTask(){
        try {
            Thread.sleep(80);
        } catch (InterruptedException e) {
            LOGGER.log(Level.WARNING,"AccuWeather task has been interrupted.");
        }
        return null;
    }
}
