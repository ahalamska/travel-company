package com.travel.company.model;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
public class Participant {
    @Id
    @GeneratedValue( strategy =  GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;



    //TODO implement password hashing
    private String password;

    @ManyToMany
    @JoinTable(name = "tour_participant", joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "tour_id"))
    private Set<Tour> tourSet = new HashSet<>();

    public Participant(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Participant{" + "id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + ", password='" + password + '\'' + ", tourSet=" + tourSet + '}';
    }
}



