package com.timeboxplanner.backend.repository;

import java.time.LocalDate;

public interface TimeBoxRepository {
    int countByDate(LocalDate date);

    int countDoneByDate(LocalDate date);

    int sumPlannedMinutesByDate(LocalDate date);

    int sumDoneMinutesByDate(LocalDate date);
}
