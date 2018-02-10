/**
 * Copyright (c) 2014,2017 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.smarthome.binding.bluetooth.bluegiga.internal.command.gap;

import org.eclipse.smarthome.binding.bluetooth.bluegiga.internal.BlueGigaCommand;

/**
 * Class to implement the BlueGiga command <b>setAdvData</b>.
 * <p>
 * This commands set advertisement or scan response data used in the advertisement and scan
 * response packets. The command allows application specific data to be broadcasts either in
 * advertisement or scan response packets. The data set with this command is only used when the
 * GAP discoverable mode is set to gap_user_data. Notice that advertisement or scan response
 * data must be formatted in accordance to the Bluetooth Core Specification. See BLUETOOTH
 * SPECIFICATION Version 4.0 [Vol 3 - Part C - Chapter 11].
 * <p>
 * This class provides methods for processing BlueGiga API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class BlueGigaSetAdvDataCommand extends BlueGigaCommand {
    public static int COMMAND_CLASS = 0x06;
    public static int COMMAND_METHOD = 0x09;

    /**
     * Advertisement data type. 0 : sets advertisement data. 1 : sets scan response data
     * <p>
     * BlueGiga API type is <i>uint8</i> - Java type is {@link int}
     */
    private int setScanrsp;

    /**
     * Advertisement data to send
     * <p>
     * BlueGiga API type is <i>uint8array</i> - Java type is {@link int[]}
     */
    private int[] advData;

    /**
     * Advertisement data type. 0 : sets advertisement data. 1 : sets scan response data
     *
     * @param setScanrsp the setScanrsp to set as {@link int}
     */
    public void setSetScanrsp(int setScanrsp) {
        this.setScanrsp = setScanrsp;
    }
    /**
     * Advertisement data to send
     *
     * @param advData the advData to set as {@link int[]}
     */
    public void setAdvData(int[] advData) {
        this.advData = advData;
    }

    @Override
    public int[] serialize() {
        // Serialize the header
        serializeHeader(COMMAND_CLASS, COMMAND_METHOD);

        // Serialize the fields
        serializeUInt8(setScanrsp);
        serializeUInt8Array(advData);

        return getPayload();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BlueGigaSetAdvDataCommand [setScanrsp=");
        builder.append(setScanrsp);
        builder.append(", advData=");
        for (int c = 0; c < advData.length; c++) {
            if (c > 0) {
                builder.append(' ');
            }
            builder.append(String.format("%02X", advData[c]));
        }
        builder.append(']');
        return builder.toString();
    }
}