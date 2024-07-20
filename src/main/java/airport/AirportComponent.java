package airport;


import airport.model.Airport;
import airport.service.AirportService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class AirportComponent implements CommandLineRunner, ApplicationListener<ContextRefreshedEvent> {
    private final AirportService airportService;
    public AirportComponent(AirportService airportService) { this.airportService = airportService; }

    @PostConstruct
    void init() {
        List<Airport> airports = airportService.getAllAirports();
        log.info("{} airports found", airports.size());
        airports.forEach(airport -> log.info("{}", airport));
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("program arguments: {}", Arrays.toString(args));
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("on context refreshed");
        List<Airport> airports = airportService.getAllAirports();
        log.info("{} airports found", airports.size());
        airports.forEach(airport -> log.info("{}", airport));
    }

    @EventListener
    public void eventListener(ContextRefreshedEvent event) {
        log.info("on context refreshed (from annotated method)");
    }
}