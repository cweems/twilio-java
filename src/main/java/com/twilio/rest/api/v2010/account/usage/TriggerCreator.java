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

package com.twilio.rest.api.v2010.account.usage;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import java.net.URI;



import java.net.URI;

public class TriggerCreator extends Creator<Trigger>{
    private URI callbackUrl;
    private String triggerValue;
    private Trigger.UsageCategory usageCategory;
    private String accountSid;
    private HttpMethod callbackMethod;
    private String friendlyName;
    private Trigger.Recurring recurring;
    private Trigger.TriggerField triggerBy;

    public TriggerCreator(final URI callbackUrl, final String triggerValue, final Trigger.UsageCategory usageCategory) {
        this.callbackUrl = callbackUrl;
        this.triggerValue = triggerValue;
        this.usageCategory = usageCategory;
    }
    public TriggerCreator(final String accountSid, final URI callbackUrl, final String triggerValue, final Trigger.UsageCategory usageCategory) {
        this.accountSid = accountSid;
        this.callbackUrl = callbackUrl;
        this.triggerValue = triggerValue;
        this.usageCategory = usageCategory;
    }

    public TriggerCreator setCallbackUrl(final URI callbackUrl){
        this.callbackUrl = callbackUrl;
        return this;
    }

    public TriggerCreator setCallbackUrl(final String callbackUrl){
        return setCallbackUrl(Promoter.uriFromString(callbackUrl));
    }
    public TriggerCreator setTriggerValue(final String triggerValue){
        this.triggerValue = triggerValue;
        return this;
    }
    public TriggerCreator setUsageCategory(final Trigger.UsageCategory usageCategory){
        this.usageCategory = usageCategory;
        return this;
    }
    public TriggerCreator setCallbackMethod(final HttpMethod callbackMethod){
        this.callbackMethod = callbackMethod;
        return this;
    }
    public TriggerCreator setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public TriggerCreator setRecurring(final Trigger.Recurring recurring){
        this.recurring = recurring;
        return this;
    }
    public TriggerCreator setTriggerBy(final Trigger.TriggerField triggerBy){
        this.triggerBy = triggerBy;
        return this;
    }

    @Override
    public Trigger create(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/Usage/Triggers.json";

        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"CallbackUrl"+"}", this.callbackUrl.toString());
        path = path.replace("{"+"TriggerValue"+"}", this.triggerValue.toString());
        path = path.replace("{"+"UsageCategory"+"}", this.usageCategory.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Trigger creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Trigger.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (callbackUrl != null) {
            request.addPostParam("CallbackUrl", callbackUrl.toString());
    
        }
        if (triggerValue != null) {
            request.addPostParam("TriggerValue", triggerValue);
    
        }
        if (usageCategory != null) {
            request.addPostParam("UsageCategory", usageCategory.toString());
    
        }
        if (callbackMethod != null) {
            request.addPostParam("CallbackMethod", callbackMethod.toString());
    
        }
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (recurring != null) {
            request.addPostParam("Recurring", recurring.toString());
    
        }
        if (triggerBy != null) {
            request.addPostParam("TriggerBy", triggerBy.toString());
    
        }
    }
}
