package com.travel.company.repositories;


import com.travel.company.model.Participant;
import org.springframework.data.repository.CrudRepository;

public interface ParticipantRepository extends CrudRepository<Participant, Long> {

}
