package com.timeboxplanner.backend.service;

import org.openapitools.model.CreateTagRequest;
import org.openapitools.model.TagListResponse;
import org.openapitools.model.TagResponse;

import java.util.UUID;

public interface TagService {
    TagResponse create(CreateTagRequest request);

    TagListResponse list();

    void delete(UUID id);
}
