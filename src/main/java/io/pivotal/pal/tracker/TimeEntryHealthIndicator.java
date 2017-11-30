package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class TimeEntryHealthIndicator  implements HealthIndicator{

    @Autowired
    TimeEntryRepository timeEntryRepository;

    public Health health() {
         return (timeEntryRepository.count()<=5) ? Health.up().build() : Health.down().build();
    }
}
