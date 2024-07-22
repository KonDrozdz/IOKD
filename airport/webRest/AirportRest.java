package airport.webRest;

import airport.model.Airport;
import airport.model.Plane;
import airport.service.AirportService;
import airport.service.PlaneService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class AirportRest {

        private  final AirportService airportService;
        private final PlaneService planeService;
        private final MessageSource messageSource;
        private final LocaleResolver localeResolver;



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
    ResponseEntity<?> addAirport(@Validated @RequestBody Airport airport, Errors errors, HttpServletRequest request) {
        log.info("about to add new airport: {}", airport);
        if(errors.hasErrors()) {
            Locale locale = localeResolver.resolveLocale(request);
            String errorMessage = errors.getAllErrors().stream()
                    .map(oe->messageSource.getMessage(Objects.requireNonNull(oe.getCode()), new Object[0], locale))
                    .reduce("errors:\n", (accu, oe)->accu + oe + "\n");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
        airport = airportService.addAirports(airport);
        log.info("new airport added {}", airport);
        return ResponseEntity.status(HttpStatus.CREATED).body(airport);
    }

}


