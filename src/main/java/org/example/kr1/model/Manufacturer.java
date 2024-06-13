package org.example.kr1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "manufacturers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "souvenirs")
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Souvenir> souvenirs;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manufacturer that = (Manufacturer) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }




}
