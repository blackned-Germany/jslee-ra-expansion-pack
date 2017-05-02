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


}
