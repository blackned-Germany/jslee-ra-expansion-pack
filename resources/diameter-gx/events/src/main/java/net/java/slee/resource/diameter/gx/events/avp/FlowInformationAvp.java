package net.java.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.IPFilterRule;

/**
 * Created by root on 01.05.17.
 */
public interface FlowInformationAvp {


    IPFilterRule getFlowDescription();

    boolean hasFlowDescription();

    void setFlowDescription(IPFilterRule flowDescription);


    FlowDirection getFlowDirection();

    boolean hasFlowDirection();

    void setFlowDirection(FlowDirection flowDirection);

    /**
     * Returns true if the ToS-Traffic-Class AVP is present in the message.
     * @return boolean
     */
    boolean hasTosTrafficClass();

    /**
     * Sets the value of the ToS-Traffic-Class AVP, of type Octet String.
     * @param flowDescription
     */
    void setTosTrafficClass(byte[] tosTrafficClass);


    /**
     * Returns the value of the ToS-Traffic-Class AVP, of type Octet String.
     * @return String
     */
    abstract byte[] getTosTrafficClass();
}
