package com.travel.company.participant;

import com.travel.company.tours.Tour;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Participant {
    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    //TODO implement password hashing
    private String password;

    @ManyToMany
    @JoinTable(name = "Participants_Tours", joinColumns = @JoinColumn(name = "Participant_id"),
            inverseJoinColumns = @JoinColumn(name = "Tour_id"))
    private Set<Tour> tourSet = new HashSet<>();

}
