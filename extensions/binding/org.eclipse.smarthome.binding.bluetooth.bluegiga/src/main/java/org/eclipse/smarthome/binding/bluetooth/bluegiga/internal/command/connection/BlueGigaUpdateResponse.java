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
package org.eclipse.smarthome.binding.bluetooth.bluegiga.internal.command.connection;

import org.eclipse.smarthome.binding.bluetooth.bluegiga.internal.BlueGigaResponse;
import org.eclipse.smarthome.binding.bluetooth.bluegiga.internal.enumeration.BgApiResponse;

/**
 * Class to implement the BlueGiga command <b>update</b>.
 * <p>
 * This command updates the connection parameters of a given connection. The parameters have
 * the same meaning and follow the same rules as for the GAP class command: Connect Direct. If
 * this command is issued at a master device, it will send parameter update request to the link
 * layer. Bluetooth On the other hand if this command is issued at a slave device, it will send
 * L2CAP connection parameter update request to the master, which may either accept or reject
 * it. It will take an amount of time corresponding to at least six times the current connection
 * interval before the new connection parameters will become active.
 * <p>
 * This class provides methods for processing BlueGiga API commands.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class BlueGigaUpdateResponse extends BlueGigaResponse {
    public static int COMMAND_CLASS = 0x03;
    public static int COMMAND_METHOD = 0x02;

    /**
     * Connection handle.
     * <p>
     * BlueGiga API type is <i>uint8</i> - Java type is {@link int}
     */
    private int connection;

    /**
     *  0 : the update was successful. Non-zero: An error occurred.
     * <p>
     * BlueGiga API type is <i>BgApiResponse</i> - Java type is {@link BgApiResponse}
     */
    private BgApiResponse result;

    /**
     * Response constructor
     */
    public BlueGigaUpdateResponse(int[] inputBuffer) {
        // Super creates deserializer and reads header fields
        super(inputBuffer);

        event = (inputBuffer[0] & 0x80) != 0;

        // Deserialize the fields
        connection = deserializeUInt8();
        result = deserializeBgApiResponse();
    }

    /**
     * Connection handle.
     * <p>
     * BlueGiga API type is <i>uint8</i> - Java type is {@link int}
     *
     * @return the current connection as {@link int}
     */
    public int getConnection() {
        return connection;
    }
    /**
     *  0 : the update was successful. Non-zero: An error occurred.
     * <p>
     * BlueGiga API type is <i>BgApiResponse</i> - Java type is {@link BgApiResponse}
     *
     * @return the current result as {@link BgApiResponse}
     */
    public BgApiResponse getResult() {
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BlueGigaUpdateResponse [connection=");
        builder.append(connection);
        builder.append(", result=");
        builder.append(result);
        builder.append(']');
        return builder.toString();
    }
}
