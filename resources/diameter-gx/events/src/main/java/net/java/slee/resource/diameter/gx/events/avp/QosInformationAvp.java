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

import net.java.slee.resource.diameter.base.events.avp.GroupedAvp;

/**
 * Defines an interface representing the AMBR grouped AVP type.
 * From the Diameter S6a Reference Point Protocol Details (3GPP TS 29.272 V9.6.0) specification:
 * 
 * <pre>
 * 7.3.41 AMBR
 * 
 * The AMBR AVP is of type Grouped.
 * 
 * AVP format
 * AMBR ::= < AVP header: 1435 10415 >
 *          { Max-Requested-Bandwidth-UL }
 *          { Max-Requested-Bandwidth-DL }
 *         *[AVP]
 * </pre>
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public interface QosInformationAvp extends GroupedAvp {

  public boolean hasQoSClassIdentifier();

  public void setQoSClassIdentifier(QoSClassIdentifier qci);

  public QoSClassIdentifier getQoSClassIdentifier();

  public boolean hasAllocationRetentionPriority();

  public void setAllocationRetentionPriority(AllocationRetentionPriorityAvp qci);

  public AllocationRetentionPriorityAvp getAllocationRetentionPriority();

  /** APN Aggregate Max Bitrate UL */

  public boolean hasApnAggregateMaxBitrateUL();

  public long getApnAggregateMaxBitrateUL();

  public void setApnAggregateMaxBitrateUL(long apnAggregateMaxBitrateUL);

  /** APN Aggregate Max Bitrate DL */
  public boolean hasApnAggregateMaxBitrateDL();

  public long getApnAggregateMaxBitrateDL();

  public void setApnAggregateMaxBitrateDL(long apnAggregateMaxBitrateDL);

  /** Max Requested Bitrate Uplink. */
  boolean hasMaxRequestedBandwithUL();

  public long getMaxRequestedBandwithUL();

  void setMaxRequestedBandwithUL(long maxRequestedBandwithUL);

  /** Max Requested Bitrate Downlink. */
  boolean hasMaxRequestedBandwithDL();

  long getMaxRequestedBandwithDL();

  void setMaxRequestedBandwithDL(long maxRequestedBandwithDL);

  /** Guaranteed Bitrate Uplink. */
  boolean hasGuaranteedBitrateUL();

  long getGuaranteedBitrateUL();

  void setGuaranteedBitrateUL(long guaranteedBitrateUL);

  /** Guaranteed Bitrate Downlink. */
  boolean hasGuaranteedBitrateDL();

  long getGuaranteedBitrateDL();

  void setGuaranteedBitrateDL(long guaranteedBitrateDL);
}