package com.mgrapp.GrzegorzDawidek.mgrapp.service;

import com.mgrapp.GrzegorzDawidek.mgrapp.model.Reservation;
import com.mgrapp.GrzegorzDawidek.mgrapp.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }
}
