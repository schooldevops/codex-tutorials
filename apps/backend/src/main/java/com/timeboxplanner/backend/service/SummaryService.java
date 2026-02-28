package com.timeboxplanner.backend.service;

import org.openapitools.model.DailySummaryResponse;

import java.time.LocalDate;

public interface SummaryService {
    DailySummaryResponse getDailySummary(LocalDate date);
}
