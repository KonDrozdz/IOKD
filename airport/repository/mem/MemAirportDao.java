package airport.repository.mem;

import airport.model.Airport;
import airport.model.Plane;
import airport.repository.AirportDao;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
@Repository("airportDao")
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
    @Override
    public Airport Save(Airport airport) {
        int maxId = SampleData.airports.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getId(), s1.getId()))
                .map(s->s.getId())
                .findFirst()
                .orElse(0);
        airport.setId(maxId + 1);
        SampleData.airports.add(airport);
        return airport;
    }
}
