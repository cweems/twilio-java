/*
 * This code was generated by
 * ___ _ _ _ _ _    _ ____    ____ ____ _    ____ ____ _  _ ____ ____ ____ ___ __   __
 *  |  | | | | |    | |  | __ |  | |__| | __ | __ |___ |\ | |___ |__/ |__|  | |  | |__/
 *  |  |_|_| | |___ | |__|    |__| |  | |    |__] |___ | \| |___ |  \ |  |  | |__| |  \
 *
 * Twilio - Taskrouter
 * This is the public Twilio REST API.
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.time.ZonedDateTime;



public class WorkspaceStatisticsFetcher extends Fetcher<WorkspaceStatistics> {
    private String workspaceSid;
    private Integer minutes;
    private ZonedDateTime startDate;
    private ZonedDateTime endDate;
    private String taskChannel;
    private String splitByWaitTime;

    public WorkspaceStatisticsFetcher(final String workspaceSid){
        this.workspaceSid = workspaceSid;
    }

    public WorkspaceStatisticsFetcher setMinutes(final Integer minutes){
        this.minutes = minutes;
        return this;
    }
    public WorkspaceStatisticsFetcher setStartDate(final ZonedDateTime startDate){
        this.startDate = startDate;
        return this;
    }
    public WorkspaceStatisticsFetcher setEndDate(final ZonedDateTime endDate){
        this.endDate = endDate;
        return this;
    }
    public WorkspaceStatisticsFetcher setTaskChannel(final String taskChannel){
        this.taskChannel = taskChannel;
        return this;
    }
    public WorkspaceStatisticsFetcher setSplitByWaitTime(final String splitByWaitTime){
        this.splitByWaitTime = splitByWaitTime;
        return this;
    }

    @Override
    public WorkspaceStatistics fetch(final TwilioRestClient client) {
        String path = "/v1/Workspaces/{WorkspaceSid}/Statistics";

        path = path.replace("{"+"WorkspaceSid"+"}", this.workspaceSid.toString());

        Request request = new Request(
            HttpMethod.GET,
            Domains.TASKROUTER.toString(),
            path
        );
        addQueryParams(request);
        Response response = client.request(request);

        if (response == null) {
        throw new ApiConnectionException("WorkspaceStatistics fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return WorkspaceStatistics.fromJson(response.getStream(), client.getObjectMapper());
    }
    private void addQueryParams(final Request request) {
        if (minutes != null) {
    
            request.addQueryParam("Minutes", minutes.toString());
        }
        if (startDate != null) {
            request.addQueryParam("StartDate", startDate.toInstant().toString());
        }

        if (endDate != null) {
            request.addQueryParam("EndDate", endDate.toInstant().toString());
        }

        if (taskChannel != null) {
    
            request.addQueryParam("TaskChannel", taskChannel);
        }
        if (splitByWaitTime != null) {
    
            request.addQueryParam("SplitByWaitTime", splitByWaitTime);
        }
    }
}
