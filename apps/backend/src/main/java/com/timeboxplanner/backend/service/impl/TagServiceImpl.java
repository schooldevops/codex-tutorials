package com.timeboxplanner.backend.service.impl;

import com.timeboxplanner.backend.service.TagService;
import org.openapitools.model.CreateTagRequest;
import org.openapitools.model.TagListResponse;
import org.openapitools.model.TagResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {
    @Override
    public TagResponse create(CreateTagRequest request) {
        throw new UnsupportedOperationException("TODO: implement create tag");
    }

    @Override
    public TagListResponse list() {
        throw new UnsupportedOperationException("TODO: implement list tags");
    }

    @Override
    public void delete(UUID id) {
        throw new UnsupportedOperationException("TODO: implement delete tag");
    }
}
