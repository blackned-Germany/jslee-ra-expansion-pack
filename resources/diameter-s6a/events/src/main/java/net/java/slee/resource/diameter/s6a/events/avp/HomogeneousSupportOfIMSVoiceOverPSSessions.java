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

package net.java.slee.resource.diameter.s6a.events.avp;

import java.io.Serializable;
import net.java.slee.resource.diameter.base.events.avp.Enumerated;

/**
 * Java class representing the Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions enumerated type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V9.6.0) specification:
 * 
 * <pre>
 * 7.3.107  Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions
 * 
 * The Homogeneous-Support-of-IMS-Voice-Over-PS-Sessions AVP is of type Enumerated. The following
 * values are defined:
 * 
 * FALSE (0)
 *   This value indicates that "IMS Voice over PS Sessions" is not supported, homogeneously, in any
 *   of the TAs or RAs associated to the serving node.
 * 
 * TRUE (1)
 *   This value indicates that "IMS Voice over PS Sessions" is supported, homogeneously, in all of
 *   the TAs or RAs associated to the serving node.
 * 
 * If this AVP is not present in the command, it indicates that there is no homogeneous support of
 * IMS Voice Over PS Sessions on all the TA/RAs of the serving node, or that the homogeneity of
 * this support is unkown to the serving node.
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class HomogeneousSupportOfIMSVoiceOverPSSessions implements Enumerated, Serializable {

  private static final long serialVersionUID = 1L;

  public static final int _FALSE = 0;
  public static final int _TRUE = 1;

  public static final HomogeneousSupportOfIMSVoiceOverPSSessions FALSE = new HomogeneousSupportOfIMSVoiceOverPSSessions(_FALSE);
  public static final HomogeneousSupportOfIMSVoiceOverPSSessions TRUE = new HomogeneousSupportOfIMSVoiceOverPSSessions(_TRUE);

  private int value = -1;

  private HomogeneousSupportOfIMSVoiceOverPSSessions(int value) {
    this.value = value;
  }

  public static HomogeneousSupportOfIMSVoiceOverPSSessions fromInt(int type) {
    switch (type) {
      case _FALSE:
        return FALSE;
      case _TRUE:
        return TRUE;
      default:
        throw new IllegalArgumentException("Invalid value: " + type);
    }
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    switch (value) {
      case _FALSE:
        return "FALSE";
      case _TRUE:
        return "TRUE";
      default:
        return "<Invalid Value>";
    }
  }
}