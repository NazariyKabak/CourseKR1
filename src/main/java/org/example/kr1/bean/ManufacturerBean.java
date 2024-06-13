package org.example.kr1.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.kr1.model.Manufacturer;
import org.example.kr1.service.ManufacturerService;

import java.math.BigDecimal;
import java.util.List;

@Named
@RequestScoped
@Getter
@Setter
public class ManufacturerBean {
    @Inject
    private ManufacturerService manufacturerService;

    private Manufacturer manufacturer = new Manufacturer();
    private Long manufacturerId;
    private BigDecimal price;



    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getAllManufacturers();
    }

    public void addManufacturer() {
        manufacturerService.addManufacturer(manufacturer);
        manufacturer = new Manufacturer();
    }

    public void updateManufacturer() {
        manufacturerService.updateManufacturer(manufacturer);
        manufacturer = new Manufacturer();
    }

    public void deleteManufacturer(Long id) {
        manufacturerService.deleteManufacturer(id);
    }

    public List<Manufacturer> findManufacturersBySouvenirPriceLessThan() {
        return manufacturerService.findManufacturersBySouvenirPriceLessThan(price);
    }
}
