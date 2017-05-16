package org.mobicents.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.IPFilterRule;
import net.java.slee.resource.diameter.gx.events.avp.FlowDirection;
import net.java.slee.resource.diameter.gx.events.avp.FlowInformationAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Created by root on 01.05.17.
 */
public class FlowInformationAvpImpl extends GroupedAvpImpl implements FlowInformationAvp {

    /**
     *
     */
    public FlowInformationAvpImpl() {
        super.code = DiameterGxAvpCodes.FLOW_INFORMATION;
        super.vendorId = DiameterGxAvpCodes.GX_VENDOR_ID;
    }

    /**
     * @param code
     * @param vendorId
     * @param mnd
     * @param prt
     * @param value
     */
    public FlowInformationAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public IPFilterRule getFlowDescription() {
        return getAvpAsIPFilterRule(DiameterGxAvpCodes.FLOW_DESCRIPTION, DiameterGxAvpCodes.GX_VENDOR_ID);
    }


    public boolean hasFlowDescription() {
        return hasAvp(DiameterGxAvpCodes.FLOW_DESCRIPTION, DiameterGxAvpCodes.GX_VENDOR_ID);
    }


    public void setFlowDescription(IPFilterRule flowDescription) {
        addAvp(DiameterGxAvpCodes.FLOW_DESCRIPTION, DiameterGxAvpCodes.GX_VENDOR_ID, flowDescription);
    }

    public FlowDirection getFlowDirection() {
        return (FlowDirection) getAvpAsEnumerated(DiameterGxAvpCodes.FLOW_DIRECTION, DiameterGxAvpCodes.GX_VENDOR_ID, FlowDirection.class);
    }

    public boolean hasFlowDirection() {
        return hasAvp(DiameterGxAvpCodes.FLOW_DIRECTION, DiameterGxAvpCodes.GX_VENDOR_ID);
    }


    public void setFlowDirection(FlowDirection flowDirection) {
        addAvp(DiameterGxAvpCodes.FLOW_DIRECTION, DiameterGxAvpCodes.GX_VENDOR_ID, flowDirection.getValue());
    }

    public byte[] getTosTrafficClass() {
        return getAvpAsOctetString(DiameterGxAvpCodes.ToS_TRAFFIC_CLASS, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    /**
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.gx.events.avp.TFTPacketFilterInformation#hasTosTrafficClass()
     */
    public boolean hasTosTrafficClass() {
        return hasAvp(DiameterGxAvpCodes.ToS_TRAFFIC_CLASS, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    /**
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.gx.events.avp.TFTPacketFilterInformation#setTosTrafficClass(String)
     */
    public void setTosTrafficClass(byte[] tosTrafficClass) {
        addAvp(DiameterGxAvpCodes.ToS_TRAFFIC_CLASS, DiameterGxAvpCodes.GX_VENDOR_ID, tosTrafficClass);
    }

}
