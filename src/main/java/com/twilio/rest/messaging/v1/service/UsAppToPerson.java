/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.messaging.v1.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;

import com.twilio.exception.ApiException;

import lombok.ToString;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.ZonedDateTime;

import java.util.List;
import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class UsAppToPerson extends Resource {
    private static final long serialVersionUID = 215629763717991L;

    public static UsAppToPersonCreator creator(final String messagingServiceSid, final String brandRegistrationSid, final String description, final List<String> messageSamples, final String usAppToPersonUsecase, final Boolean hasEmbeddedLinks, final Boolean hasEmbeddedPhone){
        return new UsAppToPersonCreator(messagingServiceSid, brandRegistrationSid, description, messageSamples, usAppToPersonUsecase, hasEmbeddedLinks, hasEmbeddedPhone);
    }

    public static UsAppToPersonFetcher fetcher(final String messagingServiceSid, final String sid){
        return new UsAppToPersonFetcher(messagingServiceSid, sid);
    }

    public static UsAppToPersonDeleter deleter(final String messagingServiceSid, final String sid){
        return new UsAppToPersonDeleter(messagingServiceSid, sid);
    }

    public static UsAppToPersonReader reader(final String messagingServiceSid){
        return new UsAppToPersonReader(messagingServiceSid);
    }


    /**
    * Converts a JSON String into a UsAppToPerson object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return UsAppToPerson object represented by the provided JSON
    */
    public static UsAppToPerson fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UsAppToPerson.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a UsAppToPerson object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return UsAppToPerson object represented by the provided JSON
    */
    public static UsAppToPerson fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, UsAppToPerson.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String brandRegistrationSid;
    private final String messagingServiceSid;
    private final String description;
    private final List<String> messageSamples;
    private final String usAppToPersonUsecase;
    private final Boolean hasEmbeddedLinks;
    private final Boolean hasEmbeddedPhone;
    private final String campaignStatus;
    private final String campaignId;
    private final Boolean isExternallyRegistered;
    private final Map<String, Object> rateLimits;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final URI url;
    private final Boolean mock;

    @JsonCreator
    private UsAppToPerson(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("brand_registration_sid")
        final String brandRegistrationSid,

        @JsonProperty("messaging_service_sid")
        final String messagingServiceSid,

        @JsonProperty("description")
        final String description,

        @JsonProperty("message_samples")
        final List<String> messageSamples,

        @JsonProperty("us_app_to_person_usecase")
        final String usAppToPersonUsecase,

        @JsonProperty("has_embedded_links")
        final Boolean hasEmbeddedLinks,

        @JsonProperty("has_embedded_phone")
        final Boolean hasEmbeddedPhone,

        @JsonProperty("campaign_status")
        final String campaignStatus,

        @JsonProperty("campaign_id")
        final String campaignId,

        @JsonProperty("is_externally_registered")
        final Boolean isExternallyRegistered,

        @JsonProperty("rate_limits")
        final Map<String, Object> rateLimits,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("url")
        final URI url,

        @JsonProperty("mock")
        final Boolean mock
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.brandRegistrationSid = brandRegistrationSid;
        this.messagingServiceSid = messagingServiceSid;
        this.description = description;
        this.messageSamples = messageSamples;
        this.usAppToPersonUsecase = usAppToPersonUsecase;
        this.hasEmbeddedLinks = hasEmbeddedLinks;
        this.hasEmbeddedPhone = hasEmbeddedPhone;
        this.campaignStatus = campaignStatus;
        this.campaignId = campaignId;
        this.isExternallyRegistered = isExternallyRegistered;
        this.rateLimits = rateLimits;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
        this.mock = mock;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getBrandRegistrationSid() {
            return this.brandRegistrationSid;
        }
        public final String getMessagingServiceSid() {
            return this.messagingServiceSid;
        }
        public final String getDescription() {
            return this.description;
        }
        public final List<String> getMessageSamples() {
            return this.messageSamples;
        }
        public final String getUsAppToPersonUsecase() {
            return this.usAppToPersonUsecase;
        }
        public final Boolean getHasEmbeddedLinks() {
            return this.hasEmbeddedLinks;
        }
        public final Boolean getHasEmbeddedPhone() {
            return this.hasEmbeddedPhone;
        }
        public final String getCampaignStatus() {
            return this.campaignStatus;
        }
        public final String getCampaignId() {
            return this.campaignId;
        }
        public final Boolean getIsExternallyRegistered() {
            return this.isExternallyRegistered;
        }
        public final Map<String, Object> getRateLimits() {
            return this.rateLimits;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final URI getUrl() {
            return this.url;
        }
        public final Boolean getMock() {
            return this.mock;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UsAppToPerson other = (UsAppToPerson) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(brandRegistrationSid, other.brandRegistrationSid) &&  Objects.equals(messagingServiceSid, other.messagingServiceSid) &&  Objects.equals(description, other.description) &&  Objects.equals(messageSamples, other.messageSamples) &&  Objects.equals(usAppToPersonUsecase, other.usAppToPersonUsecase) &&  Objects.equals(hasEmbeddedLinks, other.hasEmbeddedLinks) &&  Objects.equals(hasEmbeddedPhone, other.hasEmbeddedPhone) &&  Objects.equals(campaignStatus, other.campaignStatus) &&  Objects.equals(campaignId, other.campaignId) &&  Objects.equals(isExternallyRegistered, other.isExternallyRegistered) &&  Objects.equals(rateLimits, other.rateLimits) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(url, other.url) &&  Objects.equals(mock, other.mock)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, brandRegistrationSid, messagingServiceSid, description, messageSamples, usAppToPersonUsecase, hasEmbeddedLinks, hasEmbeddedPhone, campaignStatus, campaignId, isExternallyRegistered, rateLimits, dateCreated, dateUpdated, url, mock);
    }

}

