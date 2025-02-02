/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Bulkexports
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.bulkexports.v1.export;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class ExportCustomJobCreator extends Creator<ExportCustomJob>{
    private String resourceType;
    private String startDay;
    private String endDay;
    private String friendlyName;
    private String webhookUrl;
    private String webhookMethod;
    private String email;

    public ExportCustomJobCreator(final String resourceType, final String startDay, final String endDay, final String friendlyName) {
        this.resourceType = resourceType;
        this.startDay = startDay;
        this.endDay = endDay;
        this.friendlyName = friendlyName;
    }

    public ExportCustomJobCreator setStartDay(final String startDay){
        this.startDay = startDay;
        return this;
    }
    public ExportCustomJobCreator setEndDay(final String endDay){
        this.endDay = endDay;
        return this;
    }
    public ExportCustomJobCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public ExportCustomJobCreator setWebhookUrl(final String webhookUrl){
        this.webhookUrl = webhookUrl;
        return this;
    }
    public ExportCustomJobCreator setWebhookMethod(final String webhookMethod){
        this.webhookMethod = webhookMethod;
        return this;
    }
    public ExportCustomJobCreator setEmail(final String email){
        this.email = email;
        return this;
    }

    @Override
    public ExportCustomJob create(final TwilioRestClient client){
        String path = "/v1/Exports/{ResourceType}/Jobs";

        path = path.replace("{"+"ResourceType"+"}", this.resourceType.toString());
        path = path.replace("{"+"StartDay"+"}", this.startDay.toString());
        path = path.replace("{"+"EndDay"+"}", this.endDay.toString());
        path = path.replace("{"+"FriendlyName"+"}", this.friendlyName.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.BULKEXPORTS.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("ExportCustomJob creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return ExportCustomJob.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (startDay != null) {
            request.addPostParam("StartDay", startDay);
    
        }
        if (endDay != null) {
            request.addPostParam("EndDay", endDay);
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (webhookUrl != null) {
            request.addPostParam("WebhookUrl", webhookUrl);
    
        }
        if (webhookMethod != null) {
            request.addPostParam("WebhookMethod", webhookMethod);
    
        }
        if (email != null) {
            request.addPostParam("Email", email);
    
        }
    }
}
