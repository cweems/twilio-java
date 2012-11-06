package com.twilio.sdk.resource.instance;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.list.UsageRecordList;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicHttpResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class BasicRequestTester {
    final String accountSid = "AC0123456789abcdef0123456789abcdef";
    final String authtoken = "0123456789abcdef0123456789abcdef";

    @Mock
    HttpClient httpClient;

    protected TwilioRestClient client = new TwilioRestClient(accountSid, authtoken);

    protected BasicHttpResponse response = mock(BasicHttpResponse.class);
    protected Header[] headers = {mock(Header.class)};
    protected StatusLine status_line = mock(StatusLine.class);
    protected HttpEntity entity = mock(HttpEntity.class);

    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        client.setHttpclient(httpClient);

        when(headers[0].getValue()).thenReturn("application/xml");
        when(response.getHeaders("Content-Type")).thenReturn(headers);
        when(response.getStatusLine()).thenReturn(status_line);
        when(status_line.getStatusCode()).thenReturn(200);
        when(httpClient.execute(Matchers.<HttpUriRequest>anyObject())).thenReturn(response);
        when(response.getEntity()).thenReturn(entity);
    }

    protected void setExpectedServerAnswer(String resource_name) throws Exception {
        when(entity.getContent()).thenReturn(BasicRequestTester.class.getResourceAsStream(resource_name));
    }

}
