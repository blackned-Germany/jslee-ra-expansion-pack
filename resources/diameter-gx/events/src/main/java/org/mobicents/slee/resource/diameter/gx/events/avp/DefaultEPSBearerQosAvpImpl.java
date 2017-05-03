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

package org.mobicents.slee.resource.diameter.gx.events.avp;

import net.java.slee.resource.diameter.gx.events.avp.AllocationRetentionPriorityAvp;
import net.java.slee.resource.diameter.gx.events.avp.DefaultEPSBearerQosAvp;
import net.java.slee.resource.diameter.gx.events.avp.QoSClassIdentifier;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link DefaultEPSBearerQosAvp}
 * 
 * @author <a href="mailto:dbeken@blackned.de"> Dincer Beken </a>
 */
public class DefaultEPSBearerQosAvpImpl extends GroupedAvpImpl implements DefaultEPSBearerQosAvp {

  public DefaultEPSBearerQosAvpImpl() {
    super();
  }

  public DefaultEPSBearerQosAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  public boolean hasQoSClassIdentifier() {
    return hasAvp(DiameterGxAvpCodes.QOS_CLASS_IDENTIFIER, DiameterGxAvpCodes.TGPP_VENDOR_ID);
  }

  public void setQoSClassIdentifier(QoSClassIdentifier qci) {
    addAvp(DiameterGxAvpCodes.QOS_CLASS_IDENTIFIER, DiameterGxAvpCodes.TGPP_VENDOR_ID, qci.getValue());
  }

  public QoSClassIdentifier getQoSClassIdentifier() {
    return (QoSClassIdentifier) getAvpAsEnumerated(DiameterGxAvpCodes.QOS_CLASS_IDENTIFIER, DiameterGxAvpCodes.TGPP_VENDOR_ID, QoSClassIdentifier.class);
  }

  public boolean hasAllocationRetentionPriority() {
    return hasAvp(DiameterGxAvpCodes.ALLOCATION_RETENTION_POLICY, DiameterGxAvpCodes.TGPP_VENDOR_ID);
  }

  public void setAllocationRetentionPriority(AllocationRetentionPriorityAvp arp) {
    addAvp(arp);
  }

  public AllocationRetentionPriorityAvp getAllocationRetentionPriority() {
    return (AllocationRetentionPriorityAvp) getAvpAsCustom(DiameterGxAvpCodes.ALLOCATION_RETENTION_POLICY, DiameterGxAvpCodes.TGPP_VENDOR_ID, AllocationRetentionPriorityAvpImpl.class);
  }

}
