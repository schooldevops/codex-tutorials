package com.timeboxplanner.backend.service;

import org.openapitools.model.CreateTimeBoxRequest;
import org.openapitools.model.TimeBoxListResponse;
import org.openapitools.model.TimeBoxResponse;
import org.openapitools.model.TimeBoxStatus;
import org.openapitools.model.UpdateTimeBoxRequest;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public interface TimeBoxService {
    TimeBoxResponse create(CreateTimeBoxRequest request);

    TimeBoxListResponse list(LocalDate date, OffsetDateTime from, OffsetDateTime to, TimeBoxStatus status, UUID tagId, Integer page, Integer size);

    TimeBoxResponse get(UUID id);

    TimeBoxResponse update(UUID id, UpdateTimeBoxRequest request);

    void delete(UUID id);
}
