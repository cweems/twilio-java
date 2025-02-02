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

package com.twilio.rest.conversations.v1.service.user;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;



public class UserConversationUpdater extends Updater<UserConversation>{
    private String chatServiceSid;
    private String userSid;
    private String conversationSid;
    private UserConversation.NotificationLevel notificationLevel;
    private ZonedDateTime lastReadTimestamp;
    private Integer lastReadMessageIndex;

    public UserConversationUpdater(final String chatServiceSid, final String userSid, final String conversationSid){
        this.chatServiceSid = chatServiceSid;
        this.userSid = userSid;
        this.conversationSid = conversationSid;
    }

    public UserConversationUpdater setNotificationLevel(final UserConversation.NotificationLevel notificationLevel){
        this.notificationLevel = notificationLevel;
        return this;
    }
    public UserConversationUpdater setLastReadTimestamp(final ZonedDateTime lastReadTimestamp){
        this.lastReadTimestamp = lastReadTimestamp;
        return this;
    }
    public UserConversationUpdater setLastReadMessageIndex(final Integer lastReadMessageIndex){
        this.lastReadMessageIndex = lastReadMessageIndex;
        return this;
    }

    @Override
    public UserConversation update(final TwilioRestClient client){
        String path = "/v1/Services/{ChatServiceSid}/Users/{UserSid}/Conversations/{ConversationSid}";

        path = path.replace("{"+"ChatServiceSid"+"}", this.chatServiceSid.toString());
        path = path.replace("{"+"UserSid"+"}", this.userSid.toString());
        path = path.replace("{"+"ConversationSid"+"}", this.conversationSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("UserConversation update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return UserConversation.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (notificationLevel != null) {
            request.addPostParam("NotificationLevel", notificationLevel.toString());
    
        }
        if (lastReadTimestamp != null) {
            request.addPostParam("LastReadTimestamp", lastReadTimestamp.toInstant().toString());

        }
        if (lastReadMessageIndex != null) {
            request.addPostParam("LastReadMessageIndex", lastReadMessageIndex.toString());
    
        }
    }
}
