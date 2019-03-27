package com.travel.company.model;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter

@Entity
public class Tour {
    public Tour(String destination, BigDecimal price, GregorianCalendar beginningDate, GregorianCalendar endingDate) {
        this.destination = destination;
        this.price = price;
        this.beginningDate = beginningDate;
        this.endingDate = endingDate;
    }

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private Long id;

    private String destination;

    private BigDecimal price;

    private GregorianCalendar beginningDate;

    private GregorianCalendar endingDate;

    @ManyToMany(mappedBy = "tourSet")
    private Set<Participant> participantSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tour tour = (Tour) o;
        return Objects.equals(id, tour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Tour{" + "id=" + id + ", destination='" + destination + '\'' + ", price=" + price + ", beginningDate" +
                "=" + beginningDate + ", endingDate=" + endingDate + ", participantSet=" + participantSet + '}';
    }
}
