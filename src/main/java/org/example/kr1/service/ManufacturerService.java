package org.example.kr1.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.kr1.model.Manufacturer;
import org.example.kr1.model.Souvenir;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class ManufacturerService {
//    @PersistenceContext(unitName = "souvenirPU")
//    private EntityManager em;
//
//    public void addManufacturer(Manufacturer manufacturer) {
//        em.persist(manufacturer);
//    }
//
//    public void updateManufacturer(Manufacturer manufacturer) {
//        em.merge(manufacturer);
//    }
//
//    public Manufacturer getManufacturer(Long id) {
//        return em.find(Manufacturer.class, id);
//    }
//
//    public List<Manufacturer> getAllManufacturers() {
//        return em.createQuery("SELECT m FROM Manufacturer m", Manufacturer.class).getResultList();
//    }
//
//    public void deleteManufacturer(Long id) {
//        Manufacturer manufacturer = getManufacturer(id);
//        if (manufacturer != null) {
//            em.remove(manufacturer);
//        }
//    }
//
//    public List<Manufacturer> findManufacturersBySouvenirPriceLessThan(BigDecimal price) {
//        TypedQuery<Manufacturer> query = em.createQuery(
//                "SELECT DISTINCT m FROM Manufacturer m JOIN m.souvenirs s WHERE s.price < :price",
//                Manufacturer.class);
//        query.setParameter("price", price);
//        return query.getResultList();
//    }
    //
    private List<Manufacturer> manufacturers = new ArrayList<>();

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturers.add(manufacturer);
    }

    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturers = manufacturers.stream()
                .map(m -> m.getId().equals(manufacturer.getId()) ? manufacturer : m)
                .collect(Collectors.toList());
    }

    public Optional<Manufacturer> getManufacturerById(Long id) {
        return manufacturers.stream()
                .filter(manufacturer -> manufacturer.getId().equals(id))
                .findFirst();
    }

    public List<Manufacturer> getAllManufacturers() {
        return new ArrayList<>(manufacturers);
    }

    public void deleteManufacturer(Long id) {
        manufacturers.removeIf(m -> m.getId().equals(id));
    }

    public List<Manufacturer> findManufacturersBySouvenirPriceLessThan(BigDecimal price) {
        return manufacturers.stream()
                .filter(m -> m.getSouvenirs().stream().anyMatch(s -> s.getPrice().compareTo(price) < 0))
                .collect(Collectors.toList());
    }
    public List<Souvenir> getSouvenirsByManufacturer(Long manufacturerId) {
        return getManufacturerById(manufacturerId)
                .map(Manufacturer::getSouvenirs)
                .orElseThrow(() -> new IllegalArgumentException("Manufacturer not found"));
    }
}
