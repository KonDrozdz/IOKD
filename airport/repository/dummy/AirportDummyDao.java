package airport.repository.dummy;

import airport.model.Airport;
import airport.model.Plane;
import airport.repository.AirportDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@Primary
public class AirportDummyDao implements AirportDao {
    @Override
    public List<Airport> findAll() {
        return List.of();
    }

    @Override
    public Airport findById(int id) {
        return null;
    }

    @Override
    public List<Airport> findByPlane(Plane car) {
        return List.of();
    }

    @Override
    public Airport Save(Airport airport) {
        return null;
    }
}