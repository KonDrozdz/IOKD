package airport.webRest;

import airport.model.Airport;
import airport.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
@Component
@RequiredArgsConstructor
public class AirportValidator implements Validator {
    
    
    private final AirportService airportService;

    @Override
    public boolean supports(Class<?> clazz) { return clazz.isAssignableFrom(Airport.class); }

    @Override
    public void validate(Object target, Errors errors) {
        Airport validatedAirport = (Airport) target;

        boolean duplicated = airportService.getAllAirports().stream()
                .anyMatch(airport -> airport.getName().equalsIgnoreCase(validatedAirport.getName()));

        if (duplicated) {
            errors.rejectValue("name", "airport.name.duplicated", "Airport name already exists");
        }
    }
}
