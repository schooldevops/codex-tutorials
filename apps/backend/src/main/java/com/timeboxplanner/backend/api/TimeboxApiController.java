package com.timeboxplanner.backend.api;

import com.timeboxplanner.backend.service.SummaryService;
import com.timeboxplanner.backend.service.TagService;
import com.timeboxplanner.backend.service.TimeBoxService;
import org.openapitools.api.ApiApi;
import org.openapitools.model.CreateTagRequest;
import org.openapitools.model.CreateTimeBoxRequest;
import org.openapitools.model.DailySummaryResponse;
import org.openapitools.model.TagListResponse;
import org.openapitools.model.TagResponse;
import org.openapitools.model.TimeBoxListResponse;
import org.openapitools.model.TimeBoxResponse;
import org.openapitools.model.TimeBoxStatus;
import org.openapitools.model.UpdateTimeBoxRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

@RestController
public class TimeboxApiController implements ApiApi {
    private final TimeBoxService timeBoxService;
    private final TagService tagService;
    private final SummaryService summaryService;

    public TimeboxApiController(TimeBoxService timeBoxService, TagService tagService, SummaryService summaryService) {
        this.timeBoxService = timeBoxService;
        this.tagService = tagService;
        this.summaryService = summaryService;
    }

    @Override
    public ResponseEntity<TagResponse> createTag(CreateTagRequest createTagRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tagService.create(createTagRequest));
    }

    @Override
    public ResponseEntity<TimeBoxResponse> createTimeBox(CreateTimeBoxRequest createTimeBoxRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(timeBoxService.create(createTimeBoxRequest));
    }

    @Override
    public ResponseEntity<Void> deleteTag(UUID id) {
        tagService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteTimeBox(UUID id) {
        timeBoxService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<DailySummaryResponse> getDailySummary(LocalDate date) {
        return ResponseEntity.ok(summaryService.getDailySummary(date));
    }

    @Override
    public ResponseEntity<TagListResponse> listTags() {
        return ResponseEntity.ok(tagService.list());
    }

    @Override
    public ResponseEntity<TimeBoxListResponse> listTimeBoxes(LocalDate date, OffsetDateTime from, OffsetDateTime to, TimeBoxStatus status, UUID tagId, Integer page, Integer size) {
        return ResponseEntity.ok(timeBoxService.list(date, from, to, status, tagId, page, size));
    }

    @Override
    public ResponseEntity<TimeBoxResponse> getTimeBox(UUID id) {
        return ResponseEntity.ok(timeBoxService.get(id));
    }

    @Override
    public ResponseEntity<TimeBoxResponse> updateTimeBox(UUID id, UpdateTimeBoxRequest updateTimeBoxRequest) {
        return ResponseEntity.ok(timeBoxService.update(id, updateTimeBoxRequest));
    }
}
