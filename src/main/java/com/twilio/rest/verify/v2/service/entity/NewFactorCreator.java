/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.verify.v2.service.entity;

import com.twilio.base.Creator;
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
public class NewFactorCreator extends Creator<NewFactor> {
    private final String pathServiceSid;
    private final String pathIdentity;
    private final String friendlyName;
    private final NewFactor.FactorTypes factorType;
    private String bindingAlg;
    private String bindingPublicKey;
    private String configAppId;
    private NewFactor.NotificationPlatforms configNotificationPlatform;
    private String configNotificationToken;
    private String configSdkVersion;
    private String bindingSecret;
    private Integer configTimeStep;
    private Integer configSkew;
    private Integer configCodeLength;
    private NewFactor.TotpAlgorithms configAlg;

    /**
     * Construct a new NewFactorCreator.
     *
     * @param pathServiceSid Service Sid.
     * @param pathIdentity Unique external identifier of the Entity
     * @param friendlyName The friendly name of this Factor
     * @param factorType The Type of this Factor
     */
    public NewFactorCreator(final String pathServiceSid,
                            final String pathIdentity,
                            final String friendlyName,
                            final NewFactor.FactorTypes factorType) {
        this.pathServiceSid = pathServiceSid;
        this.pathIdentity = pathIdentity;
        this.friendlyName = friendlyName;
        this.factorType = factorType;
    }

    /**
     * The algorithm used when `factor_type` is `push`. Algorithm supported:
     * `ES256`.
     *
     * @param bindingAlg The algorithm used when `factor_type` is `push`
     * @return this
     */
    public NewFactorCreator setBindingAlg(final String bindingAlg) {
        this.bindingAlg = bindingAlg;
        return this;
    }

    /**
     * The Ecdsa public key in PKIX, ASN.1 DER format encoded in Base64.
     *
     * Required when `factor_type` is `push`.
     *
     * @param bindingPublicKey The public key encoded in Base64
     * @return this
     */
    public NewFactorCreator setBindingPublicKey(final String bindingPublicKey) {
        this.bindingPublicKey = bindingPublicKey;
        return this;
    }

    /**
     * The ID that uniquely identifies your app in the Google or Apple store, such
     * as `com.example.myapp`. It can be up to 100 characters long.
     *
     * Required when `factor_type` is `push`..
     *
     * @param configAppId The ID that uniquely identifies your app in the Google or
     *                    Apple store
     * @return this
     */
    public NewFactorCreator setConfigAppId(final String configAppId) {
        this.configAppId = configAppId;
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
    public NewFactorCreator setConfigNotificationPlatform(final NewFactor.NotificationPlatforms configNotificationPlatform) {
        this.configNotificationPlatform = configNotificationPlatform;
        return this;
    }

    /**
     * For APN, the device token. For FCM, the registration token. It is used to
     * send the push notifications. Must be between 32 and 255 characters long.
     *
     * Required when `factor_type` is `push`..
     *
     * @param configNotificationToken For APN, the device token. For FCM, the
     *                                registration token
     * @return this
     */
    public NewFactorCreator setConfigNotificationToken(final String configNotificationToken) {
        this.configNotificationToken = configNotificationToken;
        return this;
    }

    /**
     * The Verify Push SDK version used to configure the factor
     *
     * Required when `factor_type` is `push`.
     *
     * @param configSdkVersion The Verify Push SDK version used to configure the
     *                         factor
     * @return this
     */
    public NewFactorCreator setConfigSdkVersion(final String configSdkVersion) {
        this.configSdkVersion = configSdkVersion;
        return this;
    }

    /**
     * The shared secret for TOTP factors encoded in Base32. This can be provided
     * when creating the Factor, otherwise it will be generated.
     *
     * Used when `factor_type` is `totp`.
     *
     * @param bindingSecret The shared secret in Base32
     * @return this
     */
    public NewFactorCreator setBindingSecret(final String bindingSecret) {
        this.bindingSecret = bindingSecret;
        return this;
    }

    /**
     * Defines how often, in seconds, are TOTP codes generated. i.e, a new TOTP code
     * is generated every time_step seconds. Must be between 20 and 60 seconds,
     * inclusive. The default value is defined at the service level in the property
     * `totp.time_step`. Defaults to 30 seconds if not configured.
     *
     * Used when `factor_type` is `totp`.
     *
     * @param configTimeStep How often, in seconds, are TOTP codes generated
     * @return this
     */
    public NewFactorCreator setConfigTimeStep(final Integer configTimeStep) {
        this.configTimeStep = configTimeStep;
        return this;
    }

    /**
     * The number of time-steps, past and future, that are valid for validation of
     * TOTP codes. Must be between 0 and 2, inclusive. The default value is defined
     * at the service level in the property `totp.skew`. If not configured defaults
     * to 1.
     *
     * Used when `factor_type` is `totp`.
     *
     * @param configSkew The number of past and future time-steps valid at a given
     *                   time
     * @return this
     */
    public NewFactorCreator setConfigSkew(final Integer configSkew) {
        this.configSkew = configSkew;
        return this;
    }

    /**
     * Number of digits for generated TOTP codes. Must be between 3 and 8,
     * inclusive. The default value is defined at the service level in the property
     * `totp.code_length`. If not configured defaults to 6.
     *
     * Used when `factor_type` is `totp`.
     *
     * @param configCodeLength Number of digits for generated TOTP codes
     * @return this
     */
    public NewFactorCreator setConfigCodeLength(final Integer configCodeLength) {
        this.configCodeLength = configCodeLength;
        return this;
    }

    /**
     * The algorithm used to derive the TOTP codes. Can be `sha1`, `sha256` or
     * `sha512`. Defaults to `sha1`.
     *
     * Used when `factor_type` is `totp`.
     *
     * @param configAlg The algorithm used to derive the TOTP codes
     * @return this
     */
    public NewFactorCreator setConfigAlg(final NewFactor.TotpAlgorithms configAlg) {
        this.configAlg = configAlg;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created NewFactor
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public NewFactor create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.VERIFY.toString(),
            "/v2/Services/" + this.pathServiceSid + "/Entities/" + this.pathIdentity + "/Factors"
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("NewFactor creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.test(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return NewFactor.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (factorType != null) {
            request.addPostParam("FactorType", factorType.toString());
        }

        if (bindingAlg != null) {
            request.addPostParam("Binding.Alg", bindingAlg);
        }

        if (bindingPublicKey != null) {
            request.addPostParam("Binding.PublicKey", bindingPublicKey.toString());
        }

        if (configAppId != null) {
            request.addPostParam("Config.AppId", configAppId);
        }

        if (configNotificationPlatform != null) {
            request.addPostParam("Config.NotificationPlatform", configNotificationPlatform.toString());
        }

        if (configNotificationToken != null) {
            request.addPostParam("Config.NotificationToken", configNotificationToken);
        }

        if (configSdkVersion != null) {
            request.addPostParam("Config.SdkVersion", configSdkVersion);
        }

        if (bindingSecret != null) {
            request.addPostParam("Binding.Secret", bindingSecret);
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
    }
}