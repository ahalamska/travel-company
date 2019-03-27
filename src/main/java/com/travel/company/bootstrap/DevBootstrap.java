package com.travel.company.bootstrap;

import com.travel.company.model.Participant;
import com.travel.company.model.Tour;
import com.travel.company.repositories.ParticipantRepository;
import com.travel.company.repositories.TourRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TourRepository tourRepository;
    private ParticipantRepository participantRepository;

    public DevBootstrap(TourRepository tourRepository, ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
        this.tourRepository = tourRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Korfu
        Tour korfu = new Tour("Korfu",new BigDecimal("2000.99"),
                new GregorianCalendar(2019, 8, 21),
                new GregorianCalendar(2019, 8, 28) );

        //Participants
        tourRepository.save(korfu);


        Participant participant1 = new Participant("Jan Kowalski", "jan.kowalski@gmail.com", "1234");
        participant1.getTourSet().add(korfu);
        participantRepository.save(participant1);

        korfu.getParticipantSet().add(participant1);


        Participant participant2 = new Participant("Janina Kowalski", "janina.kowalski@gmail.com", "4321");
        participant2.getTourSet().add(korfu);
        participantRepository.save(participant2);
        korfu.getParticipantSet().add(participant2);


    }
}
