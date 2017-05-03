package net.java.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.StreamCorruptedException;

/**
 * Created by root on 03.05.17.
 */
public enum PccRuleStatus implements Enumerated{

    /**
     * ACTIVE (0)
     This value is used to indicate that the PCC rule(s) are successfully installed (for those provisioned from PCRF) or activated (for those pre-provisioned in PCEF).
     INACTIVE (1)
     This value is used to indicate that the PCC rule(s) are removed (for those provisioned from PCRF) or inactive (for those pre-provisioned in PCEF).
     TEMPORARILY INACTIVE (2)
     This value is used to indicate that, for some reason (e.g. loss of bearer), already installed or activated PCC rules are temporarily disabled.
     */

    ACTIVE(0),
    INACTIVE(1),
    TEMPORARILY_INACTIVE(2);

    public static final int _ACTIVE = ACTIVE.getValue();
    public static final int _INACTIVE = INACTIVE.getValue();
    public static final int _TEMPORARILY_INACTIVE = TEMPORARILY_INACTIVE.getValue();

    private int value = -1;

    private PccRuleStatus(int v) {
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

    public static PccRuleStatus fromInt(int type) throws IllegalArgumentException {
        switch (type) {
            case 0:
                return ACTIVE;
            case 1:
                return INACTIVE;
            case 1000:
                return TEMPORARILY_INACTIVE;

            default:
                throw new IllegalArgumentException();
        }
    }

    public int getValue() {
        return this.value;
    }

}
