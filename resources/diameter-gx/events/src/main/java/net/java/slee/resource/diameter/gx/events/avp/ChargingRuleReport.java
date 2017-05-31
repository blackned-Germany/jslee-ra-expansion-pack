package net.java.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;
import org.mobicents.slee.resource.diameter.gx.events.avp.DiameterGxAvpCodes;

/**
 * Created by root on 03.05.17.
 *
 * Will not contain a bearer identifier:
 *
 * TGPP 29.212: 4.5.5.2:
 * The authorized QoS per service data flow shall be provisioned within the corresponding PCC rule by including the
 * QoS-Information AVP within the Charging-Rule-Definition AVP in the CCA or RAR commands.
 * This QoS-Information AVP shall not contain a Bearer-Identifier AVP.
 */
public interface ChargingRuleReport extends GroupedAvp{

    /**
     * Returns the value of the Charging-Rule-Name AVP, of type Octet String.
     * @return String
     */
    byte[] getChargingRuleName();
    byte[][] getChargingRuleNames();

    void setChargingRuleName(byte[] chargingRuleName);
    void setChargingRuleNames(byte[][] chargingRuleNames);

    boolean hasChargingRuleName();

    /**
     * Returns the value of the Charging-Rule-Base-Name AVP, of type UTF8 String.
     * @return String
     */
    String getChargingRuleBaseName();
    String[] getChargingRuleBaseNames();

    void setChargingRuleBaseName(String chargingRuleBaseName);
    void setChargingRuleBaseNames(String[] chargingRuleBaseNames);

    boolean hasChargingRuleBaseName();

    public PccRuleStatus getPccRuleStatus();

    public boolean hasPccRuleStatus();

    public void setPccRuleStatus(PccRuleStatus pccRuleStatuses);

    public RuleFailureCode getRuleFailureCode();
    boolean hasRuleFailureCode();

    void setRuleFailureCode(RuleFailureCode ruleFailureCode);
}
