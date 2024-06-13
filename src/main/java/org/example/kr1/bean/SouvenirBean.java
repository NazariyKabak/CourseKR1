package org.example.kr1.bean;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.example.kr1.model.Souvenir;
import org.example.kr1.service.SouvenirService;

import java.util.List;

@Named
@RequestScoped
@Getter
@Setter
public class SouvenirBean {
    @Inject
    private SouvenirService souvenirService;

    private Souvenir souvenir = new Souvenir();
    private Long manufacturerId;
    private int year;
    private String country;



    public List<Souvenir> getAllSouvenirs() {
        return souvenirService.getAllSouvenirs();
    }

    public void addSouvenir() {
        souvenirService.addSouvenir(souvenir);
        souvenir = new Souvenir();
    }

    public void updateSouvenir() {
        souvenirService.updateSouvenir(souvenir);
        souvenir = new Souvenir();
    }

    public void deleteSouvenir(Long id) {
        souvenirService.deleteSouvenir(id);
    }

    public List<Souvenir> findSouvenirsByManufacturer() {
        return souvenirService.findSouvenirsByManufacturer(manufacturerId);
    }

    public List<Souvenir> findSouvenirsByCountry() {
        return souvenirService.findSouvenirsByCountry(country);
    }

    public List<Souvenir> findSouvenirsByYear() {
        return souvenirService.findSouvenirsByYear(year);
    }

    public List<Souvenir> findSouvenirsByManufacturerAndYear() {
        return souvenirService.findSouvenirsByManufacturerAndYear(manufacturerId, year);
    }

    public List<Souvenir> getSouvenirsByYear() {
        return souvenirService.getSouvenirsByYear();
    }
}
