package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
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
 * DailySummaryResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.14.0")
public class DailySummaryResponse {

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate date;

  private Integer plannedCount;

  private Integer doneCount;

  private Integer totalPlannedMinutes;

  private Integer totalDoneMinutes;

  public DailySummaryResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DailySummaryResponse(LocalDate date, Integer plannedCount, Integer doneCount, Integer totalPlannedMinutes, Integer totalDoneMinutes) {
    this.date = date;
    this.plannedCount = plannedCount;
    this.doneCount = doneCount;
    this.totalPlannedMinutes = totalPlannedMinutes;
    this.totalDoneMinutes = totalDoneMinutes;
  }

  public DailySummaryResponse date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   */
  @NotNull @Valid 
  @Schema(name = "date", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public DailySummaryResponse plannedCount(Integer plannedCount) {
    this.plannedCount = plannedCount;
    return this;
  }

  /**
   * Get plannedCount
   * @return plannedCount
   */
  @NotNull 
  @Schema(name = "plannedCount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("plannedCount")
  public Integer getPlannedCount() {
    return plannedCount;
  }

  public void setPlannedCount(Integer plannedCount) {
    this.plannedCount = plannedCount;
  }

  public DailySummaryResponse doneCount(Integer doneCount) {
    this.doneCount = doneCount;
    return this;
  }

  /**
   * Get doneCount
   * @return doneCount
   */
  @NotNull 
  @Schema(name = "doneCount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("doneCount")
  public Integer getDoneCount() {
    return doneCount;
  }

  public void setDoneCount(Integer doneCount) {
    this.doneCount = doneCount;
  }

  public DailySummaryResponse totalPlannedMinutes(Integer totalPlannedMinutes) {
    this.totalPlannedMinutes = totalPlannedMinutes;
    return this;
  }

  /**
   * Get totalPlannedMinutes
   * @return totalPlannedMinutes
   */
  @NotNull 
  @Schema(name = "totalPlannedMinutes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalPlannedMinutes")
  public Integer getTotalPlannedMinutes() {
    return totalPlannedMinutes;
  }

  public void setTotalPlannedMinutes(Integer totalPlannedMinutes) {
    this.totalPlannedMinutes = totalPlannedMinutes;
  }

  public DailySummaryResponse totalDoneMinutes(Integer totalDoneMinutes) {
    this.totalDoneMinutes = totalDoneMinutes;
    return this;
  }

  /**
   * Get totalDoneMinutes
   * @return totalDoneMinutes
   */
  @NotNull 
  @Schema(name = "totalDoneMinutes", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("totalDoneMinutes")
  public Integer getTotalDoneMinutes() {
    return totalDoneMinutes;
  }

  public void setTotalDoneMinutes(Integer totalDoneMinutes) {
    this.totalDoneMinutes = totalDoneMinutes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DailySummaryResponse dailySummaryResponse = (DailySummaryResponse) o;
    return Objects.equals(this.date, dailySummaryResponse.date) &&
        Objects.equals(this.plannedCount, dailySummaryResponse.plannedCount) &&
        Objects.equals(this.doneCount, dailySummaryResponse.doneCount) &&
        Objects.equals(this.totalPlannedMinutes, dailySummaryResponse.totalPlannedMinutes) &&
        Objects.equals(this.totalDoneMinutes, dailySummaryResponse.totalDoneMinutes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, plannedCount, doneCount, totalPlannedMinutes, totalDoneMinutes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DailySummaryResponse {\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    plannedCount: ").append(toIndentedString(plannedCount)).append("\n");
    sb.append("    doneCount: ").append(toIndentedString(doneCount)).append("\n");
    sb.append("    totalPlannedMinutes: ").append(toIndentedString(totalPlannedMinutes)).append("\n");
    sb.append("    totalDoneMinutes: ").append(toIndentedString(totalDoneMinutes)).append("\n");
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

