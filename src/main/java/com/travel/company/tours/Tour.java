package com.travel.company.tours;

import com.travel.company.participant.Participant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor

@Entity
public class Tour {

    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private Long id;

    private String destination;

    private Float price;

    private GregorianCalendar beginningDate;

    private GregorianCalendar endingDate;

    @ManyToMany(mappedBy = "tourSet")
    private Set<Participant> participantSet = new HashSet<>();
}
