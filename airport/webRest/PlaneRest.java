package airport.webRest;

import airport.DTO.PlaneDTO;
import airport.model.Airport;
import airport.model.Plane;
import airport.service.AirportService;
import airport.service.PlaneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/webapi")
public class PlaneRest {
    private final AirportService airportService;
    private final PlaneService planeService;
    private final MessageSource messageSource;
    private final LocaleResolver localeResolver;
    @GetMapping("/planes")
    List<Plane> getPlanes(
            @RequestParam(value = "phrase", required = false) String phrase,
            @RequestHeader(value = "custom-header", required = false) String customHeader,
            @CookieValue(value = "some-cookie", required = false) String someCookie) {
        log.info("about to retrieve planes list");
        log.info("phrase param: {}", phrase);
        log.info("custom-header: {}", customHeader);
        log.info("some cookie value: {}", someCookie);
        List<Plane> planes = planeService.getAllPlanes();
        log.info("{} planes found", planes.size());
        return planes;
    }

    @GetMapping("/planes/{id}")
    ResponseEntity<Plane> getPlane(@PathVariable("id") int id) {
        log.info("about to retrieve plane with id {}", id);
        Plane plane = planeService.getPlaneById(id);
        log.info("plane found: {}", plane);
        if(plane != null) {
            return ResponseEntity.ok(plane);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("airports/{airportId}/planes")
    ResponseEntity<List<Plane>> getPlanesInAirport(@PathVariable("airportId") int airportId) {
        log.info("about to retrieve planes in airport with id {}", airportId);
        Airport airport = airportService.getAirportById(airportId);
        if(airport == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            List<Plane> planes = airportService.getPlanesInAirport(airport);
            log.info("there's {} planes found in airport {}", planes.size(), airport.getName());
            return ResponseEntity.ok(planes);
        }
    }

    @PostMapping("/planes")
    ResponseEntity<?> addPlane(@RequestBody PlaneDTO planeDTO) {
        log.info("about to add a new plane");
        Plane plane = new Plane();
        plane.setName(planeDTO.getName());
        plane.setPlaneImage(planeDTO.getPlaneImage());
        plane.setYear(planeDTO.getYear());
        plane.setPrice(planeDTO.getPrice());
        plane.setManufacturer(planeService.getManufacturerById(planeDTO.getManufacturerId()));

        planeService.addPlane(plane);
        log.info("new plane added: {}", plane);
        return ResponseEntity
                .created(
                        ServletUriComponentsBuilder
                                .fromCurrentRequestUri()
                                .path("/" + plane.getId())
                                .build()
                                .toUri())
                .body(plane);
    }
}