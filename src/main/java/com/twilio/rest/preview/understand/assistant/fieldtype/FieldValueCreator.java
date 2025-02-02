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

package com.twilio.rest.preview.understand.assistant.fieldtype;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class FieldValueCreator extends Creator<FieldValue>{
    private String assistantSid;
    private String fieldTypeSid;
    private String language;
    private String value;
    private String synonymOf;

    public FieldValueCreator(final String assistantSid, final String fieldTypeSid, final String language, final String value) {
        this.assistantSid = assistantSid;
        this.fieldTypeSid = fieldTypeSid;
        this.language = language;
        this.value = value;
    }

    public FieldValueCreator setLanguage(final String language){
        this.language = language;
        return this;
    }
    public FieldValueCreator setValue(final String value){
        this.value = value;
        return this;
    }
    public FieldValueCreator setSynonymOf(final String synonymOf){
        this.synonymOf = synonymOf;
        return this;
    }

    @Override
    public FieldValue create(final TwilioRestClient client){
        String path = "/understand/Assistants/{AssistantSid}/FieldTypes/{FieldTypeSid}/FieldValues";

        path = path.replace("{"+"AssistantSid"+"}", this.assistantSid.toString());
        path = path.replace("{"+"FieldTypeSid"+"}", this.fieldTypeSid.toString());
        path = path.replace("{"+"Language"+"}", this.language.toString());
        path = path.replace("{"+"Value"+"}", this.value.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("FieldValue creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FieldValue.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (language != null) {
            request.addPostParam("Language", language);
    
        }
        if (value != null) {
            request.addPostParam("Value", value);
    
        }
        if (synonymOf != null) {
            request.addPostParam("SynonymOf", synonymOf);
    
        }
    }
}
