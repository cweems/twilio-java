/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Insights
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.insights.v1.call;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;




public class AnnotationUpdater extends Updater<Annotation>{
    private String callSid;
    private Annotation.AnsweredBy answeredBy;
    private Annotation.ConnectivityIssue connectivityIssue;
    private String qualityIssues;
    private Boolean spam;
    private Integer callScore;
    private String comment;
    private String incident;

    public AnnotationUpdater(final String callSid){
        this.callSid = callSid;
    }

    public AnnotationUpdater setAnsweredBy(final Annotation.AnsweredBy answeredBy){
        this.answeredBy = answeredBy;
        return this;
    }
    public AnnotationUpdater setConnectivityIssue(final Annotation.ConnectivityIssue connectivityIssue){
        this.connectivityIssue = connectivityIssue;
        return this;
    }
    public AnnotationUpdater setQualityIssues(final String qualityIssues){
        this.qualityIssues = qualityIssues;
        return this;
    }
    public AnnotationUpdater setSpam(final Boolean spam){
        this.spam = spam;
        return this;
    }
    public AnnotationUpdater setCallScore(final Integer callScore){
        this.callScore = callScore;
        return this;
    }
    public AnnotationUpdater setComment(final String comment){
        this.comment = comment;
        return this;
    }
    public AnnotationUpdater setIncident(final String incident){
        this.incident = incident;
        return this;
    }

    @Override
    public Annotation update(final TwilioRestClient client){
        String path = "/v1/Voice/{CallSid}/Annotation";

        path = path.replace("{"+"CallSid"+"}", this.callSid.toString());

        Request request = new Request(
            HttpMethod.POST,
            Domains.INSIGHTS.toString(),
            path
        );
        addPostParams(request);
        Response response = client.request(request);
        if (response == null) {
            throw new ApiConnectionException("Annotation update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Annotation.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addPostParams(final Request request) {
        if (answeredBy != null) {
            request.addPostParam("AnsweredBy", answeredBy.toString());
    
        }
        if (connectivityIssue != null) {
            request.addPostParam("ConnectivityIssue", connectivityIssue.toString());
    
        }
        if (qualityIssues != null) {
            request.addPostParam("QualityIssues", qualityIssues);
    
        }
        if (spam != null) {
            request.addPostParam("Spam", spam.toString());
    
        }
        if (callScore != null) {
            request.addPostParam("CallScore", callScore.toString());
    
        }
        if (comment != null) {
            request.addPostParam("Comment", comment);
    
        }
        if (incident != null) {
            request.addPostParam("Incident", incident);
    
        }
    }
}
