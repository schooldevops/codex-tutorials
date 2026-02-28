package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets TimeBoxPriority
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-02-28T15:29:13.021091+09:00[Asia/Seoul]", comments = "Generator version: 7.14.0")
public enum TimeBoxPriority {
  
  LOW("LOW"),
  
  MEDIUM("MEDIUM"),
  
  HIGH("HIGH");

  private final String value;

  TimeBoxPriority(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static TimeBoxPriority fromValue(String value) {
    for (TimeBoxPriority b : TimeBoxPriority.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

