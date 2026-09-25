package com.dars.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.time.OffsetDateTime;

@Entity
@Table(name = "disaster_event")
public class DisasterEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String externalId;

    @NotBlank
    private String title;

    @NotBlank
    private String disasterType;

    private String description;

    @DecimalMin(value = "-90.0")
    @DecimalMax(value = "90.0")
    private Double latitude;

    @DecimalMin(value = "-180.0")
    @DecimalMax(value = "180.0")
    private Double longitude;

    private OffsetDateTime eventDate;

    @NotBlank
    private String source;

    private String sourceUrl;

    private OffsetDateTime sourceUpdatedAt;

    private OffsetDateTime retrievedAt;

    private OffsetDateTime processedAt;

    public Long getId() {
        return id;
    }

    public String getExternalId() {
        return externalId;
    }

    public String getTitle() {
        return title;
    }

    public String getDisasterType() {
        return disasterType;
    }

    public String getDescription() {
        return description;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public OffsetDateTime getEventDate() {
        return eventDate;
    }

    public String getSource() {
        return source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public OffsetDateTime getSourceUpdatedAt() {
        return sourceUpdatedAt;
    }

    public OffsetDateTime getRetrievedAt() {
        return retrievedAt;
    }

    public OffsetDateTime getProcessedAt() {
        return processedAt;
    }
}