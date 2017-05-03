package net.java.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.StreamCorruptedException;

/**
 * Created by root on 03.05.17.
 */
public enum RuleFailureCode implements Enumerated{

    /**
     * UNKNOWN_RULE_NAME (1)
     This value is used to indicate that the pre-provisioned PCC rule could not be successfully activated because the Charging-Rule-Name or Charging-Rule-Base-Name is unknown to the PCEF.
     RATING_GROUP_ERROR (2)
     This value is used to indicate that the PCC rule could not be successfully installed or enforced because the Rating-Group specified within the Charging-Rule-Definition AVP by the PCRF is unknown or, invalid.
     SERVICE_IDENTIFIER_ERROR (3)
     This value is used to indicate that the PCC rule could not be successfully installed or enforced because the Service-Identifier specified within the Charging-Rule-Definition AVP by the PCRF is invalid, unknown, or not applicable to the service being charged.
     GW/PCEF_MALFUNCTION (4)
     This value is used to indicate that the PCC rule could not be successfully installed (for those provisioned from the PCRF) or activated (for those pre-provisioned in PCEF) or enforced (for those already successfully installed) due to GW/PCEF malfunction.
     RESOURCES_LIMITATION (5)
     This value is used to indicate that the PCC rule could not be successfully installed (for those provisioned from PCRF) or activated (for those pre-provisioned in PCEF) or enforced (for those already successfully installed) due to a limitation of resources at the PCEF.
     MAX_NR_BEARERS_REACHED (6)
     This value is used to indicate that the PCC rule could not be successfully installed (for those provisioned from PCRF) or activated (for those pre-provisioned in PCEF) or enforced (for those already successfully installed) due to the fact that the maximum number of bearers has been reached for the IP-CAN session.
     UNKNOWN_BEARER_ID (7)
     This value is used to indicate that the PCC rule could not be successfully installed or enforced at the PCEF because the Bearer-Id specified within the Charging-Rule-Install AVP by the PCRF is unknown or invalid. Applicable only for GPRS in the case the PCRF performs the bearer binding.
     MISSING_BEARER_ID (8)
     This value is used to indicate that the PCC rule could not be successfully installed or enforced at the PCEF because the Bearer-Id is not specified within the Charging-Rule-Install AVP by the PCRF. Applicable only for GPRS in the case the PCRF performs the bearer binding.
     MISSING_FLOW_INFORMATION (9)
     This value is used to indicate that the PCC rule could not be successfully installed or enforced because the Flow-Information AVP is not specified within the Charging-Rule-Definition AVP by the PCRF during the first install request of the PCC rule.
     RESOURCE_ALLOCATION_FAILURE (10)
     This value is used to indicate that the PCC rule could not be successfully installed or maintained since the bearer establishment/modification failed, or the bearer was released.
     UNSUCCESSFUL_QOS_VALIDATION (11)
     This value is used to:
     -	indicate that the QoS validation has failed or,
     -	Indicate when Guaranteed Bandwidth > Max-Requested-Bandwidth.
     INCORRECT_FLOW_INFORMATION (12)
     This value is used to indicate that the PCC rule could not be successfully installed or modified at the PCEF because the provided flow information does not meet the preconditions for signalling with the UE or is not supported by the network (e.g. the provided IP address(es) or IPv6 prefix(es) do not correspond to an IP version applicable for the IP-CAN session).
     PS_TO_CS_HANDOVER (13)
     This value is used to indicate that the PCC rule could not be maintained because of PS to CS handover. This value is only applicable for 3GPP-GPRS and 3GPP-EPS. Applicable to functionality introduced with the Rel9 feature as described in clause 5.4.1.
     TDF_APPLICATION_IDENTIFIER_ERROR (14)
     This value is used to indicate that the rule could not be successfully installed or enforced because the TDF-Application-Identifier is invalid, unknown, or not applicable to the application required for detection.
     NO_BEARER_BOUND (15)
     This value is used to indicate that there is no IP-CAN bearer which the PCEF can bind the PCC rule(s) to.
     FILTER_RESTRICTIONS (16)
     This value is used to indicate that the Flow-Description AVP(s) cannot be handled by the PCEF because one of the following restrictions was not met.
     -	Only the Action "permit" shall be used.
     -	No "options" shall be used.
     -	The invert modifier "!" for addresses shall not be used.
     -	The keyword "assigned" shall not be used.
     AN_GW_FAILED (17)
     This value is used to indicate that the AN-Gateway has failed and that the PCRF should refrain from sending policy decisions to the PCEF until it is informed that the S-GW has been recovered. This value shall not be used if the IP-CAN Session Modification procedure is initiated for PCC rule removal only.
     MISSING_REDIRECT_SERVER_ADDRESS (18)
     This value is used to indicate that the PCC rule could not be successfully installed or enforced at the PCEF because there is no valid Redirect_Server_Address within the Redirect-Server-Address AVP provided by the PCRF and no preconfigured redirection address for this PCC rule at the PCEF.
     CM_END_USER_SERVICE_DENIED (19)
     This value is used to indicate that the charging system denied the service request due to service restrictions (e.g. terminate rating group) or limitations related to the end-user, for example the end-user's account could not cover the requested service. Applicable to functionality introduced with the ABC feature for Sd reference point as described in subclause 5b.4.1.
     CM_CREDIT_CONTROL_NOT_APPLICABLE (20)
     This value is used to indicate that the charging system determined that the service can be granted to the end user but no further credit control is needed for the service (e.g. service is free of charge or is treated for offline charging). Applicable to functionality introduced with the ABC feature for Sd reference point as described in subclause 5b.4.1.
     CM_AUTHORIZATION_REJECTED (21)
     This value is used to indicate that the charging system denied the service request in order to terminate the service for which credit is requested. Applicable to functionality introduced with the ABC feature for Sd reference point as described in subclause 5b.4.1.
     CM_USER_UNKNOWN (22)
     This value is used to indicate that the specified end user could not be found in the charging system. Applicable to functionality introduced with the ABC feature for Sd reference point as described in subclause 5b.4.1.
     CM_RATING_FAILED (23)
     This value is used to inform the PCRF that the charging system cannot rate the service request due to insufficient rating input, incorrect AVP combination or due to an AVP or an AVP value that is not recognized or supported in the rating. Applicable to functionality introduced with the ABC feature for Sd reference point as described in subclause 5b.4.1.
     */

    UNKNOWN_RULE_NAME (1),
    RATING_GROUP_ERROR (2),
    SERVICE_IDENTIFIER_ERROR (3),
    GW_PCEF_MALFUNCTION (4),
    RESOURCES_LIMITATION (5),
    MAX_NR_BEARERS_REACHED (6),
    UNKNOWN_BEARER_ID (7),
    MISSING_BEARER_ID (8),
    MISSING_FLOW_INFORMATION (9),
    RESOURCE_ALLOCATION_FAILURE (10),
    UNSUCCESSFUL_QOS_VALIDATION (11),
    INCORRECT_FLOW_INFORMATION (12),
    PS_TO_CS_HANDOVER (13),
    TDF_APPLICATION_IDENTIFIER_ERROR (14),
    NO_BEARER_BOUND (15),
    FILTER_RESTRICTIONS (16),
    AN_GW_FAILED (17),
    MISSING_REDIRECT_SERVER_ADDRESS (18),
    CM_END_USER_SERVICE_DENIED (19),
    CM_CREDIT_CONTROL_NOT_APPLICABLE (20),
    CM_AUTHORIZATION_REJECTED (21),
    CM_USER_UNKNOWN (22),
    CM_RATING_FAILED (23);

    public static final int _UNKNOWN_RULE_NAME = UNKNOWN_RULE_NAME.getValue();
    public static final int _RATING_GROUP_ERROR = RATING_GROUP_ERROR.getValue();
    public static final int _SERVICE_IDENTIFIER_ERROR = SERVICE_IDENTIFIER_ERROR.getValue();

    public static final int _GW_PCEF_MALFUNCTION = GW_PCEF_MALFUNCTION.getValue();
    public static final int _RESOURCES_LIMITATION = RESOURCES_LIMITATION.getValue();
    public static final int _MAX_NR_BEARERS_REACHED = MAX_NR_BEARERS_REACHED.getValue();

    public static final int _UNKNOWN_BEARER_ID = UNKNOWN_BEARER_ID.getValue();
    public static final int _MISSING_BEARER_ID = MISSING_BEARER_ID.getValue();
    public static final int _MISSING_FLOW_INFORMATION = MISSING_FLOW_INFORMATION.getValue();

    public static final int _RESOURCE_ALLOCATION_FAILURE = RESOURCE_ALLOCATION_FAILURE.getValue();
    public static final int _UNSUCCESSFUL_QOS_VALIDATION = UNSUCCESSFUL_QOS_VALIDATION.getValue();
    public static final int _INCORRECT_FLOW_INFORMATION = INCORRECT_FLOW_INFORMATION.getValue();

    public static final int _PS_TO_CS_HANDOVER = PS_TO_CS_HANDOVER.getValue();
    public static final int _TDF_APPLICATION_IDENTIFIER_ERROR = TDF_APPLICATION_IDENTIFIER_ERROR.getValue();
    public static final int _NO_BEARER_BOUND = NO_BEARER_BOUND.getValue();

    public static final int _FILTER_RESTRICTIONS = FILTER_RESTRICTIONS.getValue();
    public static final int _AN_GW_FAILED = AN_GW_FAILED.getValue();
    public static final int _MISSING_REDIRECT_SERVER_ADDRESS = MISSING_REDIRECT_SERVER_ADDRESS.getValue();

    public static final int _CM_END_USER_SERVICE_DENIED = CM_END_USER_SERVICE_DENIED.getValue();
    public static final int _CM_CREDIT_CONTROL_NOT_APPLICABLE = CM_CREDIT_CONTROL_NOT_APPLICABLE.getValue();
    public static final int _CM_AUTHORIZATION_REJECTED = CM_AUTHORIZATION_REJECTED.getValue();

    public static final int _CM_USER_UNKNOWN = CM_USER_UNKNOWN.getValue();
    public static final int _CM_RATING_FAILED = CM_RATING_FAILED.getValue();


    private int value = -1;

    private RuleFailureCode(int v) {
        this.value=v;
    }

    private Object readResolve() throws StreamCorruptedException {
        try {
            return fromInt(value);
        }
        catch (IllegalArgumentException iae) {
            throw new StreamCorruptedException("Invalid internal state found: " + value);
        }
    }

    public static RuleFailureCode fromInt(int type) throws IllegalArgumentException {
        switch (type) {
            case 1:
                return UNKNOWN_RULE_NAME;
            case 2:
                return RATING_GROUP_ERROR;
            case 3:
                return SERVICE_IDENTIFIER_ERROR;
            case 4:
                return GW_PCEF_MALFUNCTION;
            case 5:
                return RESOURCES_LIMITATION;
            case 6:
               return MAX_NR_BEARERS_REACHED;
            case 7:
                return UNKNOWN_BEARER_ID;
            case 8:
                return MISSING_BEARER_ID;
            case 9:
                return MISSING_FLOW_INFORMATION;
            case 10:
                return RESOURCE_ALLOCATION_FAILURE;
            case 11:
                return UNSUCCESSFUL_QOS_VALIDATION;
            case 12:
                return INCORRECT_FLOW_INFORMATION;
            case 13:
                return PS_TO_CS_HANDOVER;
            case 14:
                return TDF_APPLICATION_IDENTIFIER_ERROR;
            case 15:
                return NO_BEARER_BOUND;
            case 16:
                return FILTER_RESTRICTIONS;
            case 17:
                return AN_GW_FAILED;
            case 18:
                return MISSING_REDIRECT_SERVER_ADDRESS;
            case 19:
                return CM_END_USER_SERVICE_DENIED;
            case 20:
                return CM_CREDIT_CONTROL_NOT_APPLICABLE;
            case 21:
                return CM_AUTHORIZATION_REJECTED;
            case 22:
                return CM_USER_UNKNOWN;
            case 23:
                return CM_RATING_FAILED;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return this.value;
    }

}
