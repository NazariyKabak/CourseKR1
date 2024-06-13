package org.example.kr1.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "souvenirs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Souvenir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String manufacturerDetails;
    private LocalDate releaseDate;
    private BigDecimal price;


    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Souvenir souvenir = (Souvenir) o;
        return id != null && id.equals(souvenir.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
