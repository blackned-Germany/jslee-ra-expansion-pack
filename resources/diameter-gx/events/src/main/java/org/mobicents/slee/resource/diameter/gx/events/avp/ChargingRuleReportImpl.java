package org.mobicents.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.gx.events.avp.ChargingRuleReport;
import net.java.slee.resource.diameter.gx.events.avp.PccRuleStatus;
import net.java.slee.resource.diameter.gx.events.avp.RuleFailureCode;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Created by root on 03.05.17.
 */
public class ChargingRuleReportImpl extends GroupedAvpImpl implements ChargingRuleReport{

    /**
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.gx.events.avp.ChargingRuleInstall#getChargingRuleName()
     */
    public byte[] getChargingRuleName() {
        return getAvpAsOctetString(DiameterGxAvpCodes.CHARGING_RULE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    public byte[][] getChargingRuleNames() {
        return getAvpsAsOctetString(DiameterGxAvpCodes.CHARGING_RULE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID);
    }


    public void setChargingRuleName(byte[] chargingRuleName) {
        addAvp(DiameterGxAvpCodes.CHARGING_RULE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID, chargingRuleName);
    }

    public void setChargingRuleNames(byte[][] chargingRuleNames) {
        for(byte[] chargingRuleName : chargingRuleNames){
            setChargingRuleName(chargingRuleName);
        }
    }

    /**
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.gx.events.avp.ChargingRuleInstall#setChargingRuleBaseName(String)
     */
    public void setChargingRuleBaseName(String chargingRuleBaseName) {
        addAvp(DiameterGxAvpCodes.CHARGING_RULE_BASE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID, chargingRuleBaseName);
    }

    public void setChargingRuleBaseNames(String[] chargingRuleBaseNames) {
        for(String chargingRuleBaseName : chargingRuleBaseNames){
            setChargingRuleBaseName(chargingRuleBaseName);
        }
    }

    public boolean hasChargingRuleName() {
        return hasAvp( DiameterGxAvpCodes.CHARGING_RULE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    /**
     * (non-Javadoc)
     *
     * @see net.java.slee.resource.diameter.gx.events.avp.ChargingRuleInstall#getChargingRuleBaseName()
     */
    public String getChargingRuleBaseName() {
        return getAvpAsUTF8String(DiameterGxAvpCodes.CHARGING_RULE_BASE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    public String[] getChargingRuleBaseNames() {
        return getAvpsAsUTF8String(DiameterGxAvpCodes.CHARGING_RULE_BASE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    public boolean hasChargingRuleBaseName() {
        return hasAvp( DiameterGxAvpCodes.CHARGING_RULE_BASE_NAME, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    /**
     * (non-Javadoc)
     * @see net.java.slee.resource.diameter.gx.events.GxCreditControlRequest#getPccRuleStatus()
     */
    public PccRuleStatus getPccRuleStatus() {
        return (PccRuleStatus) getAvpAsEnumerated(DiameterGxAvpCodes.PCC_RULE_STATUS, DiameterGxAvpCodes.GX_VENDOR_ID, PccRuleStatus.class);
    }

    public boolean hasPccRuleStatus() {
        return hasAvp(DiameterGxAvpCodes.PCC_RULE_STATUS, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    public void setPccRuleStatus(PccRuleStatus pccRuleStatuses) {
        addAvp(DiameterGxAvpCodes.PCC_RULE_STATUS, DiameterGxAvpCodes.GX_VENDOR_ID, pccRuleStatuses);
    }

    public RuleFailureCode getRuleFailureCode() {
        return (RuleFailureCode) getAvpAsEnumerated(DiameterGxAvpCodes.RULE_FAILURE_CODE, DiameterGxAvpCodes.GX_VENDOR_ID, RuleFailureCode.class);
    }

    public boolean hasRuleFailureCode() {
        return hasAvp(DiameterGxAvpCodes.RULE_FAILURE_CODE, DiameterGxAvpCodes.GX_VENDOR_ID);
    }

    public void setRuleFailureCode(RuleFailureCode ruleFailureCode) {
        addAvp(DiameterGxAvpCodes.RULE_FAILURE_CODE, DiameterGxAvpCodes.GX_VENDOR_ID, ruleFailureCode);
    }
}
