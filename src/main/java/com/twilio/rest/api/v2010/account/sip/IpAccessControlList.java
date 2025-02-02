/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Api
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.api.v2010.account.sip;

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
import java.time.ZonedDateTime;

import java.util.Map;
import java.util.Objects;


import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
public class IpAccessControlList extends Resource {
    private static final long serialVersionUID = 178395545365846L;

    public static IpAccessControlListCreator creator(final String friendlyName){
        return new IpAccessControlListCreator(friendlyName);
    }
    public static IpAccessControlListCreator creator(final String accountSid, final String friendlyName){
        return new IpAccessControlListCreator(accountSid, friendlyName);
    }

    public static IpAccessControlListFetcher fetcher(final String sid){
        return new IpAccessControlListFetcher(sid);
    }
    public static IpAccessControlListFetcher fetcher(final String accountSid, final String sid){
        return new IpAccessControlListFetcher(accountSid, sid);
    }

    public static IpAccessControlListDeleter deleter(final String sid){
        return new IpAccessControlListDeleter(sid);
    }
    public static IpAccessControlListDeleter deleter(final String accountSid, final String sid){
        return new IpAccessControlListDeleter(accountSid, sid);
    }

    public static IpAccessControlListReader reader(){
        return new IpAccessControlListReader();
    }
    public static IpAccessControlListReader reader(final String accountSid){
        return new IpAccessControlListReader(accountSid);
    }

    public static IpAccessControlListUpdater updater(final String sid, final String friendlyName){
        return new IpAccessControlListUpdater(sid, friendlyName);
    }
    public static IpAccessControlListUpdater updater(final String accountSid, final String sid, final String friendlyName){
        return new IpAccessControlListUpdater(accountSid, sid, friendlyName);
    }

    /**
    * Converts a JSON String into a IpAccessControlList object using the provided ObjectMapper.
    *
    * @param json Raw JSON String
    * @param objectMapper Jackson ObjectMapper
    * @return IpAccessControlList object represented by the provided JSON
    */
    public static IpAccessControlList fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
    * Converts a JSON InputStream into a IpAccessControlList object using the provided
    * ObjectMapper.
    *
    * @param json Raw JSON InputStream
    * @param objectMapper Jackson ObjectMapper
    * @return IpAccessControlList object represented by the provided JSON
    */
    public static IpAccessControlList fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IpAccessControlList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String friendlyName;
    private final ZonedDateTime dateCreated;
    private final ZonedDateTime dateUpdated;
    private final Map<String, String> subresourceUris;
    private final String uri;

    @JsonCreator
    private IpAccessControlList(
        @JsonProperty("sid")
        final String sid,

        @JsonProperty("account_sid")
        final String accountSid,

        @JsonProperty("friendly_name")
        final String friendlyName,

        @JsonProperty("date_created")
        final String dateCreated,

        @JsonProperty("date_updated")
        final String dateUpdated,

        @JsonProperty("subresource_uris")
        final Map<String, String> subresourceUris,

        @JsonProperty("uri")
        final String uri
    ) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.friendlyName = friendlyName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.subresourceUris = subresourceUris;
        this.uri = uri;
    }

        public final String getSid() {
            return this.sid;
        }
        public final String getAccountSid() {
            return this.accountSid;
        }
        public final String getFriendlyName() {
            return this.friendlyName;
        }
        public final ZonedDateTime getDateCreated() {
            return this.dateCreated;
        }
        public final ZonedDateTime getDateUpdated() {
            return this.dateUpdated;
        }
        public final Map<String, String> getSubresourceUris() {
            return this.subresourceUris;
        }
        public final String getUri() {
            return this.uri;
        }

    @Override
    public boolean equals(final Object o) {
        if (this==o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        IpAccessControlList other = (IpAccessControlList) o;

        return Objects.equals(sid, other.sid) &&  Objects.equals(accountSid, other.accountSid) &&  Objects.equals(friendlyName, other.friendlyName) &&  Objects.equals(dateCreated, other.dateCreated) &&  Objects.equals(dateUpdated, other.dateUpdated) &&  Objects.equals(subresourceUris, other.subresourceUris) &&  Objects.equals(uri, other.uri)  ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid, accountSid, friendlyName, dateCreated, dateUpdated, subresourceUris, uri);
    }

}

