/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Conversations
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.conversations.v1.service.conversation.message;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class DeliveryReceiptFetcher extends Fetcher<DeliveryReceipt> {
    private String chatServiceSid;
    private String conversationSid;
    private String messageSid;
    private String sid;

    public DeliveryReceiptFetcher(final String chatServiceSid, final String conversationSid, final String messageSid, final String sid){
        this.chatServiceSid = chatServiceSid;
        this.conversationSid = conversationSid;
        this.messageSid = messageSid;
        this.sid = sid;
    }


    @Override
    public DeliveryReceipt fetch(final TwilioRestClient client) {
        String path = "/v1/Services/{ChatServiceSid}/Conversations/{ConversationSid}/Messages/{MessageSid}/Receipts/{Sid}";

        path = path.replace("{"+"ChatServiceSid"+"}", this.chatServiceSid.toString());
        path = path.replace("{"+"ConversationSid"+"}", this.conversationSid.toString());
        path = path.replace("{"+"MessageSid"+"}", this.messageSid.toString());
        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.CONVERSATIONS.toString(),
            path
        );
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("DeliveryReceipt fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return DeliveryReceipt.fromJson(response.getStream(), client.getObjectMapper());
    }
}
