/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Studio
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.studio.v2.flow;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class FlowRevisionFetcher extends Fetcher<FlowRevision> {
    private String sid;
    private String revision;

    public FlowRevisionFetcher(final String sid, final String revision){
        this.sid = sid;
        this.revision = revision;
    }


    @Override
    public FlowRevision fetch(final TwilioRestClient client) {
        String path = "/v2/Flows/{Sid}/Revisions/{Revision}";

        path = path.replace("{"+"Sid"+"}", this.sid.toString());
        path = path.replace("{"+"Revision"+"}", this.revision.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.STUDIO.toString(),
            path
        );
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("FlowRevision fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FlowRevision.fromJson(response.getStream(), client.getObjectMapper());
    }
}
