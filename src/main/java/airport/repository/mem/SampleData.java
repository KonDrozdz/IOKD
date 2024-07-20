package airport.repository.mem;

import airport.model.Plane;
import airport.model.Manufacturer;
import airport.model.Airport;

import java.util.ArrayList;
import java.util.List;

public class SampleData {
    static List<Plane> Planes = new ArrayList<>();

    static List<Manufacturer> manufacturers = new ArrayList<>();

    static List<Airport> airports = new ArrayList<>();

    static {
        Manufacturer boeing = new Manufacturer(1, "Boeing", "USA");
        Manufacturer airbus = new Manufacturer(2, "Airbus", "France");
        Manufacturer embraer = new Manufacturer(3, "Embraer", "Brazil");

        Plane boeing737 = new Plane(1, "737", "https://www.boeing.com/commercial/737max/", boeing, 2018, 100000000);
        Plane boeing747 = new Plane(2, "747", "https://www.boeing.com/commercial/747/", boeing, 2019, 150000000);
        Plane boeing787 = new Plane(3, "787", "https://www.boeing.com/commercial/787/", boeing, 2017, 200000000);

        Plane a320 = new Plane(4, "A320", "https://www.airbus.com/aircraft/passenger-aircraft/a320-family.html", airbus, 2016, 110000000);
        Plane a330 = new Plane(5, "A330", "https://www.airbus.com/aircraft/passenger-aircraft/a330-family.html", airbus, 2017, 140000000);
        Plane a350 = new Plane(6, "A350", "https://www.airbus.com/aircraft/passenger-aircraft/a350-family.html", airbus, 2018, 170000000);

        Plane e190 = new Plane(7, "E190", "https://www.embraercommercialaviation.com/aircraft/e190/", embraer, 2019, 50000000);
        Plane e195 = new Plane(8, "E195", "https://www.embraercommercialaviation.com/aircraft/e195/", embraer, 2018, 55000000);
        Plane e175 = new Plane(9, "E175", "https://www.embraercommercialaviation.com/aircraft/e175/", embraer, 2017, 60000000);

        bind(boeing737, boeing);
        bind(boeing747, boeing);
        bind(boeing787, boeing);

        bind(a320, airbus);
        bind(a330, airbus);
        bind(a350, airbus);

        bind(e190, embraer);
        bind(e195, embraer);
        bind(e175, embraer);

        Airport boeingAirport = new Airport(1, "Boeing Airport", "https://www.boeing.com/assets/images/logo.svg");
        Airport airbusAirport = new Airport(2, "Airbus Airport", "https://www.airbus.com/assets/images/logo.svg");
        Airport embraerAirport = new Airport(3, "Embraer Airport", "https://www.embraercommercialaviation.com/assets/images/logo.svg");

        bind(boeingAirport, boeing737);
        bind(boeingAirport, boeing747);
        bind(boeingAirport, boeing787);

        bind(airbusAirport, a320);
        bind(airbusAirport, a330);
        bind(airbusAirport, a350);

        bind(embraerAirport, e190);
        bind(embraerAirport, e195);
        bind(embraerAirport, e175);

        manufacturers.add(boeing);
        manufacturers.add(airbus);
        manufacturers.add(embraer);

        airports.add(boeingAirport);
        airports.add(airbusAirport);
        airports.add(embraerAirport);

         Planes.add(boeing787);
      Planes.add(boeing747);
        Planes.add(boeing737);

        Planes.add(a320);
        Planes.add(a330);
        Planes.add(a350);

        Planes.add(e190);
        Planes.add(e195);
        Planes.add(e175);
    }

    private static void bind(Airport s, Plane c) {
        s.addPlane(c);
        c.addAirport(s);
    }

    private static void bind(Plane c, Manufacturer m) {
        c.setManufacturer(m);
        m.addPlane(c);
    }


}
