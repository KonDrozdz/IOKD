package airport.webRest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
@RequiredArgsConstructor
public class airportAdvice {


        private final AirportValidator validator;

        @InitBinder
        void initBinder(WebDataBinder binder) { binder.addValidators(validator); }
}
