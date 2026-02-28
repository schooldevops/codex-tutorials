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
 * CreateTimeBoxRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
public class CreateTimeBoxRequest {

  private String title;

  private @Nullable String description;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startAt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endAt;

  private TimeBoxPriority priority;

  @Valid
  private List<UUID> tagIds = new ArrayList<>();

  public CreateTimeBoxRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateTimeBoxRequest(String title, OffsetDateTime startAt, OffsetDateTime endAt, TimeBoxPriority priority) {
    this.title = title;
    this.startAt = startAt;
    this.endAt = endAt;
    this.priority = priority;
  }

  public CreateTimeBoxRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull @Size(min = 1, max = 120) 
  @Schema(name = "title", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CreateTimeBoxRequest description(@Nullable String description) {
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

  public CreateTimeBoxRequest startAt(OffsetDateTime startAt) {
    this.startAt = startAt;
    return this;
  }

  /**
   * Get startAt
   * @return startAt
   */
  @NotNull @Valid 
  @Schema(name = "startAt", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startAt")
  public OffsetDateTime getStartAt() {
    return startAt;
  }

  public void setStartAt(OffsetDateTime startAt) {
    this.startAt = startAt;
  }

  public CreateTimeBoxRequest endAt(OffsetDateTime endAt) {
    this.endAt = endAt;
    return this;
  }

  /**
   * Get endAt
   * @return endAt
   */
  @NotNull @Valid 
  @Schema(name = "endAt", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endAt")
  public OffsetDateTime getEndAt() {
    return endAt;
  }

  public void setEndAt(OffsetDateTime endAt) {
    this.endAt = endAt;
  }

  public CreateTimeBoxRequest priority(TimeBoxPriority priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Get priority
   * @return priority
   */
  @NotNull @Valid 
  @Schema(name = "priority", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("priority")
  public TimeBoxPriority getPriority() {
    return priority;
  }

  public void setPriority(TimeBoxPriority priority) {
    this.priority = priority;
  }

  public CreateTimeBoxRequest tagIds(List<UUID> tagIds) {
    this.tagIds = tagIds;
    return this;
  }

  public CreateTimeBoxRequest addTagIdsItem(UUID tagIdsItem) {
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
    CreateTimeBoxRequest createTimeBoxRequest = (CreateTimeBoxRequest) o;
    return Objects.equals(this.title, createTimeBoxRequest.title) &&
        Objects.equals(this.description, createTimeBoxRequest.description) &&
        Objects.equals(this.startAt, createTimeBoxRequest.startAt) &&
        Objects.equals(this.endAt, createTimeBoxRequest.endAt) &&
        Objects.equals(this.priority, createTimeBoxRequest.priority) &&
        Objects.equals(this.tagIds, createTimeBoxRequest.tagIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, description, startAt, endAt, priority, tagIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateTimeBoxRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    endAt: ").append(toIndentedString(endAt)).append("\n");
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

