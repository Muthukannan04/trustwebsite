package com.trust.trustwebsite.repository;

import com.trust.trustwebsite.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
