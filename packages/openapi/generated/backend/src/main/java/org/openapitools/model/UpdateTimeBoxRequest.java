package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.openapitools.model.TimeBoxPriority;
import org.openapitools.model.TimeBoxStatus;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * UpdateTimeBoxRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
public class UpdateTimeBoxRequest {

  private @Nullable String title;

  private @Nullable String description;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime endAt;

  private @Nullable TimeBoxStatus status;

  private @Nullable TimeBoxPriority priority;

  @Valid
  private List<UUID> tagIds = new ArrayList<>();

  public UpdateTimeBoxRequest title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @Size(min = 1, max = 120) 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public UpdateTimeBoxRequest description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @Size(max = 2000) 
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public UpdateTimeBoxRequest startAt(@Nullable OffsetDateTime startAt) {
    this.startAt = startAt;
    return this;
  }

  /**
   * Get startAt
   * @return startAt
   */
  @Valid 
  @Schema(name = "startAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startAt")
  public @Nullable OffsetDateTime getStartAt() {
    return startAt;
  }

  public void setStartAt(@Nullable OffsetDateTime startAt) {
    this.startAt = startAt;
  }

  public UpdateTimeBoxRequest endAt(@Nullable OffsetDateTime endAt) {
    this.endAt = endAt;
    return this;
  }

  /**
   * Get endAt
   * @return endAt
   */
  @Valid 
  @Schema(name = "endAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("endAt")
  public @Nullable OffsetDateTime getEndAt() {
    return endAt;
  }

  public void setEndAt(@Nullable OffsetDateTime endAt) {
    this.endAt = endAt;
  }

  public UpdateTimeBoxRequest status(@Nullable TimeBoxStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public @Nullable TimeBoxStatus getStatus() {
    return status;
  }

  public void setStatus(@Nullable TimeBoxStatus status) {
    this.status = status;
  }

  public UpdateTimeBoxRequest priority(@Nullable TimeBoxPriority priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
   */
  @Valid 
  @Schema(name = "priority", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priority")
  public @Nullable TimeBoxPriority getPriority() {
    return priority;
  }

  public void setPriority(@Nullable TimeBoxPriority priority) {
    this.priority = priority;
  }

  public UpdateTimeBoxRequest tagIds(List<UUID> tagIds) {
    this.tagIds = tagIds;
    return this;
  }

  public UpdateTimeBoxRequest addTagIdsItem(UUID tagIdsItem) {
    if (this.tagIds == null) {
      this.tagIds = new ArrayList<>();
    }
    this.tagIds.add(tagIdsItem);
    return this;
  }

  /**
   * Get tagIds
   * @return tagIds
   */
  @Valid 
  @Schema(name = "tagIds", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("tagIds")
  public List<UUID> getTagIds() {
    return tagIds;
  }

  public void setTagIds(List<UUID> tagIds) {
    this.tagIds = tagIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateTimeBoxRequest updateTimeBoxRequest = (UpdateTimeBoxRequest) o;
    return Objects.equals(this.title, updateTimeBoxRequest.title) &&
        Objects.equals(this.description, updateTimeBoxRequest.description) &&
        Objects.equals(this.startAt, updateTimeBoxRequest.startAt) &&
        Objects.equals(this.endAt, updateTimeBoxRequest.endAt) &&
        Objects.equals(this.status, updateTimeBoxRequest.status) &&
        Objects.equals(this.priority, updateTimeBoxRequest.priority) &&
        Objects.equals(this.tagIds, updateTimeBoxRequest.tagIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, startAt, endAt, status, priority, tagIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateTimeBoxRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    endAt: ").append(toIndentedString(endAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    tagIds: ").append(toIndentedString(tagIds)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

