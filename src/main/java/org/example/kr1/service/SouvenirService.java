package org.example.kr1.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.example.kr1.model.Souvenir;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Stateless
public class SouvenirService {
//    @PersistenceContext(unitName = "souvenirPU")
//    private EntityManager em;
//
//    public void addSouvenir(Souvenir souvenir) {
//        em.persist(souvenir);
//    }
//
//    public void updateSouvenir(Souvenir souvenir) {
//        em.merge(souvenir);
//    }
//
//    public Souvenir getSouvenir(Long id) {
//        return em.find(Souvenir.class, id);
//    }
//
//    public List<Souvenir> getAllSouvenirs() {
//        return em.createQuery("SELECT s FROM Souvenir s", Souvenir.class).getResultList();
//    }
//
//    public void deleteSouvenir(Long id) {
//        Souvenir souvenir = getSouvenir(id);
//        if (souvenir != null) {
//            em.remove(souvenir);
//        }
//    }
//
//    public List<Souvenir> findSouvenirsByManufacturer(Long manufacturerId) {
//        TypedQuery<Souvenir> query = em.createQuery(
//                "SELECT s FROM Souvenir s WHERE s.manufacturer.id = :manufacturerId",
//                Souvenir.class);
//        query.setParameter("manufacturerId", manufacturerId);
//        return query.getResultList();
//    }
//
//    public List<Souvenir> findSouvenirsByCountry(String country) {
//        TypedQuery<Souvenir> query = em.createQuery(
//                "SELECT s FROM Souvenir s WHERE s.manufacturer.country = :country",
//                Souvenir.class);
//        query.setParameter("country", country);
//        return query.getResultList();
//    }
//
//    public List<Souvenir> findSouvenirsByYear(int year) {
//        TypedQuery<Souvenir> query = em.createQuery(
//                "SELECT s FROM Souvenir s WHERE YEAR(s.releaseDate) = :year",
//                Souvenir.class);
//        query.setParameter("year", year);
//        return query.getResultList();
//    }
//
//    public List<Souvenir> findSouvenirsByManufacturerAndYear(Long manufacturerId, int year) {
//        TypedQuery<Souvenir> query = em.createQuery(
//                "SELECT s FROM Souvenir s WHERE s.manufacturer.id = :manufacturerId AND YEAR(s.releaseDate) = :year",
//                Souvenir.class);
//        query.setParameter("manufacturerId", manufacturerId);
//        query.setParameter("year", year);
//        return query.getResultList();
//    }
//
//    public List<Souvenir> getSouvenirsByYear() {
//        TypedQuery<Souvenir> query = em.createQuery(
//                "SELECT s FROM Souvenir s ORDER BY YEAR(s.releaseDate)",
//                Souvenir.class);
//        return query.getResultList();
//    }
    private List<Souvenir> souvenirs = new ArrayList<>();

        public void addSouvenir(Souvenir souvenir) {
            souvenirs.add(souvenir);
        }

        public void updateSouvenir(Souvenir souvenir) {
            souvenirs = souvenirs.stream()
                    .map(s -> s.getId().equals(souvenir.getId()) ? souvenir : s)
                    .collect(Collectors.toList());
        }

        public Optional<Souvenir> getSouvenirById(Long id) {
        return souvenirs.stream()
                .filter(souvenir -> souvenir.getId().equals(id))
                .findFirst();
        }

        public List<Souvenir> getAllSouvenirs() {
            return new ArrayList<>(souvenirs);
        }

        public void deleteSouvenir(Long id) {
            souvenirs.removeIf(s -> s.getId().equals(id));
        }

        public List<Souvenir> findSouvenirsByManufacturer(Long manufacturerId) {
            return souvenirs.stream()
                    .filter(s -> s.getManufacturer().getId().equals(manufacturerId))
                    .collect(Collectors.toList());
        }

        public List<Souvenir> findSouvenirsByCountry(String country) {
            return souvenirs.stream()
                    .filter(s -> s.getManufacturer().getCountry().equalsIgnoreCase(country))
                    .collect(Collectors.toList());
        }

        public List<Souvenir> findSouvenirsByYear(int year) {
            return souvenirs.stream()
                    .filter(s -> s.getReleaseDate().getYear() == year)
                    .collect(Collectors.toList());
        }

        public List<Souvenir> findSouvenirsByManufacturerAndYear(Long manufacturerId, int year) {
            return souvenirs.stream()
                    .filter(s -> s.getManufacturer().getId().equals(manufacturerId) && s.getReleaseDate().getYear() == year)
                    .collect(Collectors.toList());
        }

        public List<Souvenir> getSouvenirsByYear() {
            return souvenirs.stream()
                    .sorted((s1, s2) -> s1.getReleaseDate().getYear() - s2.getReleaseDate().getYear())
                    .collect(Collectors.toList());
        }

}
