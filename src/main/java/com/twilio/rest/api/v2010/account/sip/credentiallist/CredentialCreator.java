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

package com.twilio.rest.api.v2010.account.sip.credentiallist;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class CredentialCreator extends Creator<Credential>{
    private String credentialListSid;
    private String username;
    private String password;
    private String accountSid;

    public CredentialCreator(final String credentialListSid, final String username, final String password) {
        this.credentialListSid = credentialListSid;
        this.username = username;
        this.password = password;
    }
    public CredentialCreator(final String accountSid, final String credentialListSid, final String username, final String password) {
        this.accountSid = accountSid;
        this.credentialListSid = credentialListSid;
        this.username = username;
        this.password = password;
    }

    public CredentialCreator setUsername(final String username){
        this.username = username;
        return this;
    }
    public CredentialCreator setPassword(final String password){
        this.password = password;
        return this;
    }

    @Override
    public Credential create(final TwilioRestClient client){
        String path = "/2010-04-01/Accounts/{AccountSid}/SIP/CredentialLists/{CredentialListSid}/Credentials.json";

        this.accountSid = this.accountSid == null ? client.getAccountSid() : this.accountSid;
        path = path.replace("{"+"AccountSid"+"}", this.accountSid.toString());
        path = path.replace("{"+"CredentialListSid"+"}", this.credentialListSid.toString());
        path = path.replace("{"+"Username"+"}", this.username.toString());
        path = path.replace("{"+"Password"+"}", this.password.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Credential creation failed: Unable to connect to server");
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
        if (username != null) {
            request.addPostParam("Username", username);
    
        }
        if (password != null) {
            request.addPostParam("Password", password);
    
        }
    }
}
