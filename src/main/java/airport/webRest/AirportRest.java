package airport.webRest;

import airport.model.Airport;
import airport.service.AirportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AirportRest {

        private  final AirportService airportService;

        @GetMapping("/airports")
        List<Airport> getShowrooms() {
            log.info("retrieve airports list");
            List<Airport> airports = airportService.getAllAirports();
            log.info("{} airports found", airports.size());
            return airports;
        }
    }

