package com.timeboxplanner.backend.service.impl;

import com.timeboxplanner.backend.service.TimeBoxService;
import org.openapitools.model.CreateTimeBoxRequest;
import org.openapitools.model.TimeBoxListResponse;
import org.openapitools.model.TimeBoxResponse;
import org.openapitools.model.TimeBoxStatus;
import org.openapitools.model.UpdateTimeBoxRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@Service
public class TimeBoxServiceImpl implements TimeBoxService {
    @Override
    public TimeBoxResponse create(CreateTimeBoxRequest request) {
        throw new UnsupportedOperationException("TODO: implement create time-box");
    }

    @Override
    public TimeBoxListResponse list(LocalDate date, OffsetDateTime from, OffsetDateTime to, TimeBoxStatus status, UUID tagId, Integer page, Integer size) {
        throw new UnsupportedOperationException("TODO: implement list time-boxes");
    }

    @Override
    public TimeBoxResponse get(UUID id) {
        throw new UnsupportedOperationException("TODO: implement get time-box");
    }

    @Override
    public TimeBoxResponse update(UUID id, UpdateTimeBoxRequest request) {
        throw new UnsupportedOperationException("TODO: implement update time-box");
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("TODO: implement delete time-box");
    }
}
