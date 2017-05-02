package org.mobicents.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.IPFilterRule;
import net.java.slee.resource.diameter.gx.events.avp.FlowDirection;
import net.java.slee.resource.diameter.gx.events.avp.FlowInformationAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Created by root on 01.05.17.
 */
public class FlowInformationAvpAvpImpl extends GroupedAvpImpl implements FlowInformationAvp {

    /**
     *
     */
    public FlowInformationAvpAvpImpl() {
        super.code = DiameterGxAvpCodes.FLOW_INFORMATION;
        super.vendorId = DiameterGxAvpCodes.TGPP_VENDOR_ID;
    }

    /**
     * @param code
     * @param vendorId
     * @param mnd
     * @param prt
     * @param value
     */
    public FlowInformationAvpAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public IPFilterRule getFlowDescription() {
        return (IPFilterRule) getAvpAsEnumerated(DiameterGxAvpCodes.FLOW_DESCRIPTION, DiameterGxAvpCodes.TGPP_VENDOR_ID, IPFilterRule.class);
    }


    public boolean hasFlowDescription() {
        return hasAvp(DiameterGxAvpCodes.FLOW_DESCRIPTION, DiameterGxAvpCodes.TGPP_VENDOR_ID );
    }


    public void setFlowDescription(IPFilterRule flowDescription) {
        addAvp(DiameterGxAvpCodes.FLOW_DESCRIPTION, DiameterGxAvpCodes.TGPP_VENDOR_ID, flowDescription.toString());
    }

    public FlowDirection getFlowDirection() {
        return (FlowDirection) getAvpAsEnumerated(DiameterGxAvpCodes.FLOW_DIRECTION, DiameterGxAvpCodes.TGPP_VENDOR_ID, IPFilterRule.class);
    }

    public boolean hasFlowDirection() {
        return hasAvp(DiameterGxAvpCodes.FLOW_DIRECTION, DiameterGxAvpCodes.TGPP_VENDOR_ID );
    }


    public void setFlowDirection(FlowDirection flowDirection) {
        addAvp(DiameterGxAvpCodes.FLOW_DIRECTION, DiameterGxAvpCodes.TGPP_VENDOR_ID, flowDirection.toString());
    }
}
