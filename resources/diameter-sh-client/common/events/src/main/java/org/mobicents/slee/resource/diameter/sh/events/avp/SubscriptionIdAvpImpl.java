package org.mobicents.slee.resource.diameter.sh.events.avp;


import net.java.slee.resource.diameter.sh.events.avp.DiameterShAvpCodes;
import net.java.slee.resource.diameter.sh.events.avp.SubscriptionIdAvp;
import net.java.slee.resource.diameter.sh.events.avp.SubscriptionIdType;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Created by dbeken on 22.02.2016.
 */
public class SubscriptionIdAvpImpl  extends GroupedAvpImpl implements SubscriptionIdAvp {

    public SubscriptionIdAvpImpl() {
        super();
    }

    public SubscriptionIdAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp#getSubscriptionIdData()
     */
    public String getSubscriptionIdData() {
        return getAvpAsUTF8String(DiameterShAvpCodes.Subscription_Id_Data);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp#getSubscriptionIdType()
     */
    public SubscriptionIdType getSubscriptionIdType() {
        return (SubscriptionIdType) getAvpAsEnumerated(DiameterShAvpCodes.Subscription_Id_Type, SubscriptionIdType.class);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp#hasSubscriptionIdData()
     */
    public boolean hasSubscriptionIdData() {
        return hasAvp(DiameterShAvpCodes.Subscription_Id_Data);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp#hasSubscriptionIdType()
     */
    public boolean hasSubscriptionIdType() {
        return hasAvp(DiameterShAvpCodes.Subscription_Id_Type);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp#setSubscriptionIdData(java.lang.String)
     */
    public void setSubscriptionIdData(String data) {
        addAvp(DiameterShAvpCodes.Subscription_Id_Data, data);
    }

    /*
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdAvp#setSubscriptionIdType(net.java.slee.resource.diameter.cca.events.avp.SubscriptionIdType)
     */
    public void setSubscriptionIdType(SubscriptionIdType type) {
        addAvp(DiameterShAvpCodes.Subscription_Id_Type, type.getValue());
    }

}
