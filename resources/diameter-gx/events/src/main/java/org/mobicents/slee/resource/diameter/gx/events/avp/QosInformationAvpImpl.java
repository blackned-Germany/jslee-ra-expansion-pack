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
import net.java.slee.resource.diameter.gx.events.avp.QoSClassIdentifier;
import net.java.slee.resource.diameter.gx.events.avp.QosInformationAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link QosInformationAvp}
 * 
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class QosInformationAvpImpl extends GroupedAvpImpl implements QosInformationAvp {

    public QosInformationAvpImpl() {
        super();
    }

    public QosInformationAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
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

    /** APN Aggregate Max Bitrate UL */
    public boolean hasApnAggregateMaxBitrateUL() {
        return hasAvp(DiameterGxAvpCodes.APN_AGGREGATE_MAX_BITRATE_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public long getApnAggregateMaxBitrateUL() {
         return getAvpAsUnsigned32(DiameterGxAvpCodes.APN_AGGREGATE_MAX_BITRATE_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public void setApnAggregateMaxBitrateUL(long apnAggregateMaxBitrateUL) {
        addAvp(DiameterGxAvpCodes.APN_AGGREGATE_MAX_BITRATE_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID, apnAggregateMaxBitrateUL);
    }

    /** APN Aggregate Max Bitrate DL */
    public boolean hasApnAggregateMaxBitrateDL() {
        return hasAvp(DiameterGxAvpCodes.APN_AGGREGATE_MAX_BITRATE_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public long getApnAggregateMaxBitrateDL() {
         return getAvpAsUnsigned32(DiameterGxAvpCodes.APN_AGGREGATE_MAX_BITRATE_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public void setApnAggregateMaxBitrateDL(long apnAggregateMaxBitrateDL) {
        addAvp(DiameterGxAvpCodes.APN_AGGREGATE_MAX_BITRATE_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID, apnAggregateMaxBitrateDL);
    }

    /** Max Requested Bitrate Uplink. */
    public boolean hasMaxRequestedBandwithUL() {
        return hasAvp(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public long getMaxRequestedBandwithUL() {
        return getAvpAsUnsigned32(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public void setMaxRequestedBandwithUL(long maxRequestedBandwithUL) {
        addAvp(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID, maxRequestedBandwithUL);
    }

    /** Max Requested Bitrate Downlink. */
    public boolean hasMaxRequestedBandwithDL() {
        return hasAvp(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public long getMaxRequestedBandwithDL() {
        return getAvpAsUnsigned32(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public void setMaxRequestedBandwithDL(long maxRequestedBandwithDL) {
        addAvp(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID, maxRequestedBandwithDL);
    }

    /** Guaranteed Bitrate Uplink. */
    public boolean hasGuaranteedBitrateUL() {
        return hasAvp(DiameterGxAvpCodes.GUARANTEED_BITRATE_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public long getGuaranteedBitrateUL() {
        return getAvpAsUnsigned32(DiameterGxAvpCodes.GUARANTEED_BITRATE_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public void setGuaranteedBitrateUL(long guaranteedBitrateUL) {
        addAvp(DiameterGxAvpCodes.GUARANTEED_BITRATE_UL, DiameterGxAvpCodes.TGPP_VENDOR_ID, guaranteedBitrateUL);
    }

    /** Guaranteed Bitrate Downlink. */
    public boolean hasGuaranteedBitrateDL() {
        return hasAvp(DiameterGxAvpCodes.GUARANTEED_BITRATE_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public long getGuaranteedBitrateDL() {
        return getAvpAsUnsigned32(DiameterGxAvpCodes.GUARANTEED_BITRATE_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID);
    }

    public void setGuaranteedBitrateDL(long guaranteedBitrateDL) {
        addAvp(DiameterGxAvpCodes.MAX_REQUESTED_BANDWITH_DL, DiameterGxAvpCodes.TGPP_VENDOR_ID, guaranteedBitrateDL);
    }
}
