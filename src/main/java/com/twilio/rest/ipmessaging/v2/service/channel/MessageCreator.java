/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Ip_messaging
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.ipmessaging.v2.service.channel;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.time.ZonedDateTime;




public class MessageCreator extends Creator<Message>{
    private String serviceSid;
    private String channelSid;
    private Message.WebhookEnabledType xTwilioWebhookEnabled;
    private String from;
    private String attributes;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateUpdated;
    private String lastUpdatedBy;
    private String body;
    private String mediaSid;

    public MessageCreator(final String serviceSid, final String channelSid) {
        this.serviceSid = serviceSid;
        this.channelSid = channelSid;
    }

    public MessageCreator setXTwilioWebhookEnabled(final Message.WebhookEnabledType xTwilioWebhookEnabled){
        this.xTwilioWebhookEnabled = xTwilioWebhookEnabled;
        return this;
    }
    public MessageCreator setFrom(final String from){
        this.from = from;
        return this;
    }
    public MessageCreator setAttributes(final String attributes){
        this.attributes = attributes;
        return this;
    }
    public MessageCreator setDateCreated(final ZonedDateTime dateCreated){
        this.dateCreated = dateCreated;
        return this;
    }
    public MessageCreator setDateUpdated(final ZonedDateTime dateUpdated){
        this.dateUpdated = dateUpdated;
        return this;
    }
    public MessageCreator setLastUpdatedBy(final String lastUpdatedBy){
        this.lastUpdatedBy = lastUpdatedBy;
        return this;
    }
    public MessageCreator setBody(final String body){
        this.body = body;
        return this;
    }
    public MessageCreator setMediaSid(final String mediaSid){
        this.mediaSid = mediaSid;
        return this;
    }

    @Override
    public Message create(final TwilioRestClient client){
        String path = "/v2/Services/{ServiceSid}/Channels/{ChannelSid}/Messages";

        path = path.replace("{"+"ServiceSid"+"}", this.serviceSid.toString());
        path = path.replace("{"+"ChannelSid"+"}", this.channelSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.IPMESSAGING.toString(),
            path
        );
        addPostParams(request);
        addHeaderParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Message creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Message.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (from != null) {
            request.addPostParam("From", from);
    
        }
        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
    
        }
        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toInstant().toString());

        }
        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toInstant().toString());

        }
        if (lastUpdatedBy != null) {
            request.addPostParam("LastUpdatedBy", lastUpdatedBy);
    
        }
        if (body != null) {
            request.addPostParam("Body", body);
    
        }
        if (mediaSid != null) {
            request.addPostParam("MediaSid", mediaSid);
    
        }
    }
    private void addHeaderParams(final Request request) {
        if (xTwilioWebhookEnabled != null) {
            request.addHeaderParam("X-Twilio-Webhook-Enabled", xTwilioWebhookEnabled.toString());

        }
    }
}
