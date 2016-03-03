/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.sh.events;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.java.slee.resource.diameter.base.events.avp.DiameterAvpCodes;
import net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp;
import net.java.slee.resource.diameter.s6a.events.avp.APNConfigurationProfileAvp;
import net.java.slee.resource.diameter.s6a.events.avp.SubscriptionDataAvp;
import net.java.slee.resource.diameter.sh.events.UserDataAnswer;
import net.java.slee.resource.diameter.sh.events.avp.DiameterShAvpCodes;
import net.java.slee.resource.diameter.sh.events.avp.SubscriptionIdAvp;
import net.java.slee.resource.diameter.sh.events.avp.userdata.ShData;
import net.java.slee.resource.diameter.sh.events.avp.userdata.UserDataObjectFactory;

import org.jdiameter.api.Avp;
import org.jdiameter.api.Message;
import org.mobicents.slee.resource.diameter.base.events.avp.ExperimentalResultAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.APNConfigurationAvpImpl;
import org.mobicents.slee.resource.diameter.s6a.events.avp.SubscriptionDataAvpImpl;
import org.mobicents.slee.resource.diameter.sh.events.avp.SubscriptionIdAvpImpl;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.ObjectFactory;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TShData;
import org.mobicents.slee.resource.diameter.sh.events.avp.userdata.UserDataObjectFactoryImpl;

import static net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes.APN_CONFIGURATION_PROFILE;
import static net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes.S6A_VENDOR_ID;
import static net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes.SUBSCRIPTION_DATA;

/**
 * 
 * Implementation of {@link UserDataAnswer} interface.
 * 
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class UserDataAnswerImpl extends DiameterShMessageImpl implements UserDataAnswer {

  private static final long serialVersionUID = -6240588207973076841L;

  private static JAXBContext jaxbContext = initJAXBContext();
  private static UserDataObjectFactory udof = new UserDataObjectFactoryImpl(new ObjectFactory());

  private static JAXBContext initJAXBContext() {
    try {
      return JAXBContext.newInstance(org.mobicents.slee.resource.diameter.sh.events.avp.userdata.TShData.class);
    }
    catch (Exception e) {
      // we can't throw exception
      return null;
    }
  }

  /**
   * 
   * @param msg
   */
  public UserDataAnswerImpl(Message msg) {
    super(msg);
    msg.setRequest(false);
    msg.setReTransmitted(false); // just in case. answers never have T flag set
    super.longMessageName = "User-Data-Answer";
    super.shortMessageName = "UDA";
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#hasUserData()
   */
  public boolean hasUserData() {
    return hasAvp(DiameterShAvpCodes.USER_DATA, DiameterShAvpCodes.SH_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#getUserData()
   */
  public byte[] getUserData() {
    return getAvpAsOctetString(DiameterShAvpCodes.USER_DATA, DiameterShAvpCodes.SH_VENDOR_ID);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#getUserDataObject()
   */
  public ShData getUserDataObject() throws IOException {
    ShData shDataObject = null;
    try {
      Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

      byte[] data = getAvpAsRaw(DiameterShAvpCodes.USER_DATA, DiameterShAvpCodes.SH_VENDOR_ID);
      JAXBElement<TShData> jaxbElem = udof.createShData((TShData) unmarshaller.unmarshal(new ByteArrayInputStream(data)));
      shDataObject = (ShData) jaxbElem.getValue();
    }
    catch (Exception e) {
      throw new IOException("Failed to unmarshal User-Data AVP into JAXB Object", e);
    }
    return shDataObject;
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#setUserData(byte[])
   */
  public void setUserData(byte[] userData) {
    addAvp(DiameterShAvpCodes.USER_DATA, DiameterShAvpCodes.SH_VENDOR_ID, userData);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#setUserData(byte[])
   */
  public void setUserDataObject(ShData userData) throws IOException {
    try {
      Marshaller marshaller = jaxbContext.createMarshaller();

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      marshaller.marshal(userData, baos);
      addAvp(DiameterShAvpCodes.USER_DATA, DiameterShAvpCodes.SH_VENDOR_ID, baos.toByteArray());
    }
    catch (Exception e) {
      throw new IOException("Failed to marshal JAXB Object to User-Data AVP", e);
    }
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#hasExperimentalResult()
   */
  public boolean hasExperimentalResult() {
    return hasAvp(DiameterAvpCodes.EXPERIMENTAL_RESULT);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#getExperimentalResult()
   */
  public ExperimentalResultAvp getExperimentalResult() {
    return (ExperimentalResultAvp) getAvpAsCustom(Avp.EXPERIMENTAL_RESULT, ExperimentalResultAvpImpl.class);
  }

  /*
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.UserDataAnswer#setExperimentalResult(net.java.slee.resource.diameter.base.events.avp.ExperimentalResultAvp)
   */
  public void setExperimentalResult(ExperimentalResultAvp experimentalResult) {
    addAvp(Avp.EXPERIMENTAL_RESULT, experimentalResult.byteArrayValue());
  }

  /* 
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer#hasWildcardedPSI()
   */
  public boolean hasWildcardedPSI() {
    return hasAvp(DiameterShAvpCodes.WILDCARDED_PSI, DiameterShAvpCodes.SH_VENDOR_ID);
  }

  /* 
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer#getWildcardedPSI()
   */
  public String getWildcardedPSI() {
    return getAvpAsUTF8String(DiameterShAvpCodes.WILDCARDED_PSI, DiameterShAvpCodes.SH_VENDOR_ID);
  }

  /* 
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer#setWildcardedPSI(String)
   */
  public void setWildcardedPSI(String wildcardedPSI) {
    addAvp(DiameterShAvpCodes.WILDCARDED_PSI, DiameterShAvpCodes.SH_VENDOR_ID, wildcardedPSI);
  }
  
  /* 
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer#hasWildcardedIMPU()
   */
  public boolean hasWildcardedIMPU() {
    return hasAvp(DiameterShAvpCodes.WILDCARDED_IMPU, DiameterShAvpCodes.SH_VENDOR_ID);
  }

  /* 
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer#getWildcardedIMPU()
   */
  public String getWildcardedIMPU() {
    return getAvpAsUTF8String(DiameterShAvpCodes.WILDCARDED_IMPU, DiameterShAvpCodes.SH_VENDOR_ID);
  }

  /* 
   * (non-Javadoc)
   * @see net.java.slee.resource.diameter.sh.events.SubscribeNotificationsAnswer#setWildcardedIMPU(String)
   */
  public void setWildcardedIMPU(String wildcardedIMPU) {
    addAvp(DiameterShAvpCodes.WILDCARDED_IMPU, DiameterShAvpCodes.SH_VENDOR_ID, wildcardedIMPU);
  }


  /**
   * Blackned SP Interface Extensions.
   * @param subscriptionDataAvp
   */
  public void setSubscriptionDataAvp(final SubscriptionDataAvp subscriptionDataAvp){
    addAvp(subscriptionDataAvp);
  }

  /**
   * Blackned SP Interface Extensions.
   * @return subscriptionVector
   */
  public SubscriptionDataAvp getSubscriptionDataAvp() {
    return (SubscriptionDataAvp) getAvpAsCustom(SUBSCRIPTION_DATA, S6A_VENDOR_ID, SubscriptionDataAvpImpl.class);
  }

  /**
   * Blackned SP Interface Extensions.
   * @return subscriptionVector
   */
  public boolean hasSubscriptionDataAvp() {
    return hasAvp(SUBSCRIPTION_DATA, S6A_VENDOR_ID);
  }

  /**
   * Blackned SP Interface Extensions.
   * @param apnCfgProfileAvp
   */
  public void setApnCfgProfileAvp(final APNConfigurationProfileAvp apnCfgProfileAvp){
    addAvp(apnCfgProfileAvp);
  }

  /**
   * Blackned SP Interface Extensions.
   * @return apnCfgProfileAvp
   */
  public APNConfigurationProfileAvp getAPNConfigurationProfileAvp(){
    return (APNConfigurationProfileAvp) getAvpAsCustom(APN_CONFIGURATION_PROFILE, S6A_VENDOR_ID, APNConfigurationAvpImpl.class);
  }

  /**
   * Blackned SP Interface Extensions.
   * @return
   */
  public boolean hasAPNConfigurationProfileAvp(){
    return hasAvp(APN_CONFIGURATION_PROFILE, S6A_VENDOR_ID);
  }
  /**
   * Blackned SP Interface Extensions.
   * @param subscriptionIdAvp
   */
  public void setSubscriptionIdAvp(final SubscriptionIdAvp subscriptionIdAvp){
    addAvp(subscriptionIdAvp);
  }

  /**
   * Blackned SP Interface Extensions.
   * @return subscriptionIdAvp
   */
  public SubscriptionIdAvp getSubscriptionIdAvp() {
    return (SubscriptionIdAvp) getAvpAsCustom(DiameterShAvpCodes.Subscription_Id, S6A_VENDOR_ID, SubscriptionIdAvpImpl.class);
  }

  /**
   * Blackned SP Interface Extensions.
   * @return subscriptionIdAvp
   */
  public boolean hasSubscriptionIdAvp() {
    return hasAvp(DiameterShAvpCodes.Subscription_Id, S6A_VENDOR_ID);
  }

}
