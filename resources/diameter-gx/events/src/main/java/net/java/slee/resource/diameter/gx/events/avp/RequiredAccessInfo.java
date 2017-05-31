package net.java.slee.resource.diameter.gx.events.avp;

import java.io.StreamCorruptedException;

/**
 * Created by root on 02.05.17.
 */
public enum RequiredAccessInfo {

    /** The following values are defined:
    USER_LOCATION (0)
    Indicates that the user location information shall be reported, the PCRF shall report the user location information within the 3GPP-User-Location-Info AVP (if available), the serving PLMN identifier within the 3GPP-SGSN-MCC-MNC AVP (if available), the user location information within the TWAN-Identifier (if available) and User-Location-Info-Time AVP (if available).
    MS_TIME_ZONE (1)
    Indicates that the user timezone information shall be reported, the PCRF shall report the user timezone information within the 3GPP-MS-TimeZone AVP.
     */


    USER_LOCATION(0),
    MS_TIME_ZONE(1);

    public static final int _USER_LOCATION = USER_LOCATION.getValue();
    public static final int _MS_TIME_ZONE = MS_TIME_ZONE.getValue();

    private int value = -1;

    private RequiredAccessInfo(int v) {
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

    public static RequiredAccessInfo fromInt(int type) throws IllegalArgumentException {
        switch (type) {
            case 0:
                return USER_LOCATION;
            case 1:
                return MS_TIME_ZONE;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return this.value;
    }

}
