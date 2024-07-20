package airport.repository.mem;

import airport.model.Airport;
import airport.model.Plane;
import airport.repository.AirportDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component("airportDao")
public class MemAirportDao implements AirportDao {

    @Override
    public List<Airport> findAll() {
        return SampleData.airports;
    }

    @Override
    public Airport findById(int id) {
        return SampleData.airports.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Airport> findByPlane(Plane plane) {
        return SampleData.airports.stream().filter(s -> s.getPlanes().contains(plane)).collect(Collectors.toList());
    }
}
