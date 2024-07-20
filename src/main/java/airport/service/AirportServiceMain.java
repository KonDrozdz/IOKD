package airport.service;

import airport.model.Airport;
import airport.repository.PlaneDao;
import airport.repository.AirportDao;
import airport.repository.mem.MemPlaneDao;
import airport.repository.mem.MemAirportDao;
import airport.service.impl.AirportServiceBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AirportServiceMain {
    public static void main(String[] args) {

        System.out.println("Let's find showrooms!");

        ApplicationContext context = new AnnotationConfigApplicationContext("airport");
        AirportService service = context.getBean(AirportServiceBean.class);
        AirportService service2 = context.getBean(AirportService.class);

        List<Airport> showrooms = service.getAllAirports();
        System.out.println(showrooms.size() + " showrooms found:");
        showrooms.forEach(System.out::println);

        String foo = context.getBean(String.class);
        System.out.println("foo string: " + foo);
    }
}
