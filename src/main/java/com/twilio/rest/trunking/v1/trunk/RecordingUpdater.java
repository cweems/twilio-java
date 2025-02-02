/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Trunking
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.trunking.v1.trunk;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class RecordingUpdater extends Updater<Recording>{
    private String trunkSid;
    private Recording.RecordingMode mode;
    private Recording.RecordingTrim trim;

    public RecordingUpdater(final String trunkSid){
        this.trunkSid = trunkSid;
    }

    public RecordingUpdater setMode(final Recording.RecordingMode mode){
        this.mode = mode;
        return this;
    }
    public RecordingUpdater setTrim(final Recording.RecordingTrim trim){
        this.trim = trim;
        return this;
    }

    @Override
    public Recording update(final TwilioRestClient client){
        String path = "/v1/Trunks/{TrunkSid}/Recording";

        path = path.replace("{"+"TrunkSid"+"}", this.trunkSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.TRUNKING.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Recording update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Recording.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (mode != null) {
            request.addPostParam("Mode", mode.toString());
    
        }
        if (trim != null) {
            request.addPostParam("Trim", trim.toString());
    
        }
    }
}
