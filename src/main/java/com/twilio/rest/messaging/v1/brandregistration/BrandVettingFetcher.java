/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.messaging.v1.brandregistration;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class BrandVettingFetcher extends Fetcher<BrandVetting> {
    private final String pathBrandSid;
    private final String pathBrandVettingSid;

    /**
     * Construct a new BrandVettingFetcher.
     *
     * @param pathBrandSid A2P BrandRegistration Sid
     * @param pathBrandVettingSid SID for third-party vetting record
     */
    public BrandVettingFetcher(final String pathBrandSid,
                               final String pathBrandVettingSid) {
        this.pathBrandSid = pathBrandSid;
        this.pathBrandVettingSid = pathBrandVettingSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched BrandVetting
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public BrandVetting fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.MESSAGING.toString(),
            "/v1/a2p/BrandRegistrations/" + this.pathBrandSid + "/Vettings/" + this.pathBrandVettingSid + ""
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("BrandVetting fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return BrandVetting.fromJson(response.getStream(), client.getObjectMapper());
    }
}