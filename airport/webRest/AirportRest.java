package airport.webRest;

import airport.model.Airport;
import airport.model.Plane;
import airport.service.AirportService;
import airport.service.PlaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class AirportRest {

        private  final AirportService airportService;
        private final PlaneService planeService;

        @GetMapping("/airports")
        List<Airport> getairports(
                @RequestParam(value = "phrase", required = false) String phrase,
                @RequestHeader(value = "custom-header", required = false) String customHeader,
                @CookieValue(value = "some-cookie", required = false) String someCookie ) {
            log.info("about to retrieve airports list");
            log.info("phrase param: {}", phrase);
            log.info("custom-header: {}", customHeader);
            log.info("some cookie value: {}", someCookie);
            List<Airport> airports = airportService.getAllAirports();
            log.info("{} airports found", airports.size());
            return airports;
    }
    @GetMapping("/airports/{id}")
    ResponseEntity<Airport> getAirport(@PathVariable("id") int id) {
        log.info("about to retrieve airport with id {}", id);
        Airport airport = airportService.getAirportById(id);
        log.info("airport found: {}", airport);
        if(airport != null) {
            return ResponseEntity.ok(airport);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/planes/{planeId}/airports")
    ResponseEntity<List<Airport>> getAirportsByPlane(@PathVariable("planeId") int planeId) {
        log.info("about to retrieve airports with a plane {}", planeId);
        Plane plane = planeService.getPlaneById(planeId);
        if(plane == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<Airport> airports = airportService.getAirportsByPlane(plane);
            log.info("{} airports found for plane {}", airports.size(), plane.getName());
            return ResponseEntity.ok(airports);
        }
    }

    @PostMapping("/airports")
    ResponseEntity<Airport> addAirport(@RequestBody Airport airport) {
        log.info("about to add new airport: {}", airport);
        airport = airportService.addAirports(airport);
        log.info("new airport added {}", airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(airport);
    }

}


