package airport.service;

import airport.model.Airport;
import airport.repository.PlaneDao;
import airport.repository.AirportDao;
import airport.repository.mem.MemPlaneDao;
import airport.repository.mem.MemAirportDao;
import airport.service.impl.AirportServiceBean;

import java.util.List;

public class AirportServiceMain {
    public static void main(String[] args) {
        System.out.println("Let's find airports!");

        AirportDao airportDao = new MemAirportDao();
        PlaneDao planeDao = new MemPlaneDao();

        AirportService service = new AirportServiceBean(airportDao, planeDao);

        List<Airport> airports = service.getAllAirports();
        System.out.println(airports.size() + " airports found:");
        airports.forEach(System.out::println);
    }
}
