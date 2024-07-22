package airport.DTO;

import lombok.Data;

@Data
public class PlaneDTO {
    private String name;
    private String planeImage;
    private int manufacturerId;
    private int year;
    private int price;
}
