package com.trust.trustwebsite.service;

import com.trust.trustwebsite.model.Event;
import java.util.List;

public interface EventService {
    void saveEvent(Event event);
    List<Event> getAllEvents();
    Event getEventById(Long id);
    void deleteEvent(Long id);

}
