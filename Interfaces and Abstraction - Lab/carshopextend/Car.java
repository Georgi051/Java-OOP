package interfacesandabstraction.carshopextend;

import java.io.Serializable;

public interface Car extends Serializable {
    int TYRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String getCountryProduced();

}