/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Chat
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.chat.v1;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class CredentialUpdater extends Updater<Credential>{
    private String sid;
    private String friendlyName;
    private String certificate;
    private String privateKey;
    private Boolean sandbox;
    private String apiKey;
    private String secret;

    public CredentialUpdater(final String sid){
        this.sid = sid;
    }

    public CredentialUpdater setFriendlyName(final String friendlyName){
        this.friendlyName = friendlyName;
        return this;
    }
    public CredentialUpdater setCertificate(final String certificate){
        this.certificate = certificate;
        return this;
    }
    public CredentialUpdater setPrivateKey(final String privateKey){
        this.privateKey = privateKey;
        return this;
    }
    public CredentialUpdater setSandbox(final Boolean sandbox){
        this.sandbox = sandbox;
        return this;
    }
    public CredentialUpdater setApiKey(final String apiKey){
        this.apiKey = apiKey;
        return this;
    }
    public CredentialUpdater setSecret(final String secret){
        this.secret = secret;
        return this;
    }

    @Override
    public Credential update(final TwilioRestClient client){
        String path = "/v1/Credentials/{Sid}";

        path = path.replace("{"+"Sid"+"}", this.sid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Credential update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Credential.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
    
        }
        if (certificate != null) {
            request.addPostParam("Certificate", certificate);
    
        }
        if (privateKey != null) {
            request.addPostParam("PrivateKey", privateKey);
    
        }
        if (sandbox != null) {
            request.addPostParam("Sandbox", sandbox.toString());
    
        }
        if (apiKey != null) {
            request.addPostParam("ApiKey", apiKey);
    
        }
        if (secret != null) {
            request.addPostParam("Secret", secret);
    
        }
    }
}
