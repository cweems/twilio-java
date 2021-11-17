/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.entity;

import com.twilio.base.Updater;
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
public class FactorUpdater extends Updater<Factor> {
    private final String pathServiceSid;
    private final String pathIdentity;
    private final String pathSid;
    private String authPayload;
    private String friendlyName;
    private String configNotificationToken;
    private String configSdkVersion;
    private Integer configTimeStep;
    private Integer configSkew;
    private Integer configCodeLength;
    private Factor.TotpAlgorithms configAlg;
    private String configNotificationPlatform;

    /**
     * Construct a new FactorUpdater.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param pathSid A string that uniquely identifies this Factor.
     */
    public FactorUpdater(final String pathServiceSid,
                         final String pathIdentity,
                         final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.pathSid = pathSid;
    }

    /**
     * The optional payload needed to verify the Factor for the first time. E.g. for
     * a TOTP, the numeric code..
     *
     * @param authPayload Optional payload to verify the Factor for the first time
     * @return this
     */
    public FactorUpdater setAuthPayload(final String authPayload) {
        this.authPayload = authPayload;
        return this;
    }

    /**
     * The new friendly name of this Factor. It can be up to 64 characters..
     *
     * @param friendlyName The friendly name of this Factor
     * @return this
     */
    public FactorUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * For APN, the device token. For FCM, the registration token. It is used to
     * send the push notifications. Required when `factor_type` is `push`. If
     * specified, this value must be between 32 and 255 characters long..
     *
     * @param configNotificationToken For APN, the device token. For FCM, the
     *                                registration token
     * @return this
     */
    public FactorUpdater setConfigNotificationToken(final String configNotificationToken) {
        this.configNotificationToken = configNotificationToken;
        return this;
    }

    /**
     * The Verify Push SDK version used to configure the factor.
     *
     * @param configSdkVersion The Verify Push SDK version used to configure the
     *                         factor
     * @return this
     */
    public FactorUpdater setConfigSdkVersion(final String configSdkVersion) {
        this.configSdkVersion = configSdkVersion;
        return this;
    }

    /**
     * Defines how often, in seconds, are TOTP codes generated. i.e, a new TOTP code
     * is generated every time_step seconds. Must be between 20 and 60 seconds,
     * inclusive.
     *
     * @param configTimeStep How often, in seconds, are TOTP codes generated
     * @return this
     */
    public FactorUpdater setConfigTimeStep(final Integer configTimeStep) {
        this.configTimeStep = configTimeStep;
        return this;
    }

    /**
     * The number of time-steps, past and future, that are valid for validation of
     * TOTP codes. Must be between 0 and 2, inclusive.
     *
     * @param configSkew The number of past and future time-steps valid at a given
     *                   time
     * @return this
     */
    public FactorUpdater setConfigSkew(final Integer configSkew) {
        this.configSkew = configSkew;
        return this;
    }

    /**
     * Number of digits for generated TOTP codes. Must be between 3 and 8,
     * inclusive.
     *
     * @param configCodeLength Number of digits for generated TOTP codes
     * @return this
     */
    public FactorUpdater setConfigCodeLength(final Integer configCodeLength) {
        this.configCodeLength = configCodeLength;
        return this;
    }

    /**
     * The algorithm used to derive the TOTP codes. Can be `sha1`, `sha256` or
     * `sha512`.
     *
     * @param configAlg The algorithm used to derive the TOTP codes
     * @return this
     */
    public FactorUpdater setConfigAlg(final Factor.TotpAlgorithms configAlg) {
        this.configAlg = configAlg;
        return this;
    }

    /**
     * The transport technology used to generate the Notification Token. Can be
     * `apn`, `fcm` or `none`.
     *
     * Required when `factor_type` is `push`..
     *
     * @param configNotificationPlatform The transport technology used to generate
     *                                   the Notification Token
     * @return this
     */
    public FactorUpdater setConfigNotificationPlatform(final String configNotificationPlatform) {
        this.configNotificationPlatform = configNotificationPlatform;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Factor
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Factor update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Entities/" + this.pathIdentity + "/Factors/" + this.pathSid + ""
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Factor update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return Factor.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (authPayload != null) {
            request.addPostParam("AuthPayload", authPayload);
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (configNotificationToken != null) {
            request.addPostParam("Config.NotificationToken", configNotificationToken);
        }

        if (configSdkVersion != null) {
            request.addPostParam("Config.SdkVersion", configSdkVersion);
        }

        if (configTimeStep != null) {
            request.addPostParam("Config.TimeStep", configTimeStep.toString());
        }

        if (configSkew != null) {
            request.addPostParam("Config.Skew", configSkew.toString());
        }

        if (configCodeLength != null) {
            request.addPostParam("Config.CodeLength", configCodeLength.toString());
        }

        if (configAlg != null) {
            request.addPostParam("Config.Alg", configAlg.toString());
        }

        if (configNotificationPlatform != null) {
            request.addPostParam("Config.NotificationPlatform", configNotificationPlatform);
        }
    }
}