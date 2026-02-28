package com.timeboxplanner.backend.service.impl;

import com.timeboxplanner.backend.service.SummaryService;
import org.openapitools.model.DailySummaryResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SummaryServiceImpl implements SummaryService {
    @Override
    public DailySummaryResponse getDailySummary(LocalDate date) {
        throw new UnsupportedOperationException("TODO: implement daily summary");
    }
}
