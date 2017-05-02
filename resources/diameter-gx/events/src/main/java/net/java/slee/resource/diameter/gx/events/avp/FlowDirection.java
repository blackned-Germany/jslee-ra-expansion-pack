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

package net.java.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.base.events.avp.Enumerated;

import java.io.StreamCorruptedException;

/**
 * The RAT-Type AVP (AVP code 1032) is of type Enumerated and is used to
 * identify the radio access technology that is serving the UE. NOTE 1: Values
 * 0-999 are used for generic radio access technologies that can apply to
 * different IP-CAN types and are not IP-CAN specific. NOTE 2: Values 1000-1999
 * are used for 3GPP specific radio access technology types. NOTE 3: Values
 * 2000-2999 are used for 3GPP2 specific radio access technology types. NOTE 4:
 * The informative Annex C presents a mapping between the code values for
 * different access network types. <br>
 * 
 * <br>
 * The following values are defined:
 * 
 * <pre>
 * WLAN (0)
 *   This value shall be used to indicate that the RAT is WLAN.   
 * VIRTUAL (1)
 *   This value shall be used to indicate that the RAT is unknown. For further details refer to 3GPP TS 29.274 [22].
 * UTRAN (1000)
 *   This value shall be used to indicate that the RAT is UTRAN. For further details refer to 3GPP TS 29.060 [18].
 * GERAN (1001)
 *   This value shall be used to indicate that the RAT is GERAN. For further details refer to 3GPP TS 29.060 [18].
 * GAN (1002)
 *   This value shall be used to indicate that the RAT is GAN. For further details refer to 3GPP TS 29.060 [18] and 3GPP TS 43.318 [29].
 * HSPA_EVOLUTION (1003)
 *   This value shall be used to indicate that the RAT is HSPA Evolution. For further details refer to 3GPP TS 29.060 [18].
 * EUTRAN (1004)
 *   This value shall be used to indicate that the RAT is EUTRAN. For further details refer to 3GPP TS 29.274 [22]
 * CDMA2000_1X (2000)
 *   This value shall be used to indicate that the RAT is CDMA2000 1X. For further details refer to 3GPP2 X.S0011 [20].
 * HRPD (2001)
 *   This value shall be used to indicate that the RAT is HRPD. For further details refer to 3GPP2 X.S0011 [20].
 * UMB (2002)
 *   This value shall be used to indicate that the RAT is UMB. For further details refer to 3GPP2 X.S0011 [20].
 * EHRPD (2003)
 *   This value shall be used to indicate that the RAT is eHRPD. For further details refer to 3GPP2 X.S0057 [24].
 * </pre>
 * 
 * NOTE: defined in TS 29.212
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 */
public enum FlowDirection implements Enumerated{

  DOWNLINK(1),
  UPLINK(2),
  BIDIRECTIONAL(3);

  public static final int _DOWNLINK = DOWNLINK.getValue();
  public static final int _UPLINK = UPLINK.getValue();
  public static final int _BIDIRECTIONAL = BIDIRECTIONAL.getValue();

  private int value = -1;

  private FlowDirection(int v) {
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

  public static FlowDirection fromInt(int type) throws IllegalArgumentException {
    switch (type) {
      case 1:
        return DOWNLINK;
      case 2:
        return UPLINK;
      case 3:
        return BIDIRECTIONAL;
      default:
        throw new IllegalArgumentException();
    }
  }

  public int getValue() {
    return this.value;
  }

}
