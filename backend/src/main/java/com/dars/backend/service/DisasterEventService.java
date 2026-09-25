package com.dars.backend.service;

import com.dars.backend.entity.DisasterEvent;
import com.dars.backend.repository.DisasterEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisasterEventService {

    private final DisasterEventRepository disasterEventRepository;

    public DisasterEventService(DisasterEventRepository disasterEventRepository) {
        this.disasterEventRepository = disasterEventRepository;
    }

    public List<DisasterEvent> getAllEvents() {
        return disasterEventRepository.findAll();
    }
}
