/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Preview
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.preview.understand.assistant;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class QueryUpdater extends Updater<Query>{
    private String assistantSid;
    private String sid;
    private String sampleSid;
    private String status;

    public QueryUpdater(final String assistantSid, final String sid){
        this.assistantSid = assistantSid;
        this.sid = sid;
    }

    public QueryUpdater setSampleSid(final String sampleSid){
        this.sampleSid = sampleSid;
        return this;
    }
    public QueryUpdater setStatus(final String status){
        this.status = status;
        return this;
    }

    @Override
    public Query update(final TwilioRestClient client){
        String path = "/understand/Assistants/{AssistantSid}/Queries/{Sid}";

        path = path.replace("{"+"AssistantSid"+"}", this.assistantSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Query update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Query.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (sampleSid != null) {
            request.addPostParam("SampleSid", sampleSid);
    
        }
        if (status != null) {
            request.addPostParam("Status", status);
    
        }
    }
}
