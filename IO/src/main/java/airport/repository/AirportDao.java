package airport.repository;

import airport.model.Airport;
import airport.model.Plane;

import java.util.List;

public interface AirportDao {

    List<Airport> findAll();

    Airport findById(int id);

    List<Airport> findByPlane(Plane plane);
}
