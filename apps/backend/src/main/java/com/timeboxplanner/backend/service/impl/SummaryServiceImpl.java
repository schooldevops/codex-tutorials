package com.timeboxplanner.backend.service.impl;

import com.timeboxplanner.backend.repository.TimeBoxRepository;
import com.timeboxplanner.backend.service.SummaryService;
import org.openapitools.model.DailySummaryResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SummaryServiceImpl implements SummaryService {
    private final TimeBoxRepository timeBoxRepository;

    public SummaryServiceImpl(TimeBoxRepository timeBoxRepository) {
        this.timeBoxRepository = timeBoxRepository;
    }

    @Override
    public DailySummaryResponse getDailySummary(LocalDate date) {
        int plannedCount = timeBoxRepository.countByDate(date);
        int doneCount = timeBoxRepository.countDoneByDate(date);
        int totalPlannedMinutes = timeBoxRepository.sumPlannedMinutesByDate(date);
        int totalDoneMinutes = timeBoxRepository.sumDoneMinutesByDate(date);

        return new DailySummaryResponse(
            date,
            plannedCount,
            doneCount,
            totalPlannedMinutes,
            totalDoneMinutes
        );
    }
}
