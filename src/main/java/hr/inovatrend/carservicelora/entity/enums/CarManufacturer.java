package hr.inovatrend.carservicelora.entity.enums;

import lombok.Getter;

@Getter

public enum CarManufacturer {

    AUDI_A6("Audi", "A6"),
    BMW_X6("BMW", "X6"),
    MERCEDES_MAYBACH("Mercedes", "Maybach"),
    SEAT_IBIZA("Seat", "Ibiza"),
    OPEL_ASTRA("Opel", "Astra"),
    SKODA_OCTAVIA("Škoda", "Octavia"),
    RENAULT_MEGANE("Renault", "Megane"),
    CITROEN_C3("Citroen", "C3"),
    FERRARI_MARANELLO("Ferrari", "Maranello"),
    LADA_NIVA("Lada", "Niva");

    private String manufacturer;
    private String model;

    public String getDisplayValue() {

        return this.manufacturer + " " + this.model;
    }

    CarManufacturer(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }
}
