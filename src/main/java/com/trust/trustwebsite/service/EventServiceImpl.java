package com.trust.trustwebsite.service;

import com.trust.trustwebsite.model.Event;
import com.trust.trustwebsite.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }
    @Override
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }


}
