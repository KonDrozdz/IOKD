package airport.service;

import airport.model.Airport;
import airport.model.Plane;
import airport.repository.AirportDao;

import java.util.List;

public interface AirportService {

    Airport getAirportById(int id);

    List<Airport> getAllAirports();

    List<Airport> getAirportsByPlane(Plane plane);

    List<Plane> getPlanesInAirport(Airport airport);
    Airport addAirports(Airport airport);
}
