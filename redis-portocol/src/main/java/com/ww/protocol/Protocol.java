package com.ww.protocol;

import com.ww.connnection.Connection;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 协议层
 */
public class Protocol {
    public static final String DOLLAR_BYTE = "$";
    public static final String ASTERIRK_BYTE = "*";
    public static final String BLANK_BYTE = "\r\n";

    public static void sendCommand(OutputStream outputStream, Protocol.Command command, byte[]... args) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(ASTERIRK_BYTE).append(args.length + 1).append(BLANK_BYTE);
        buffer.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE);
        buffer.append(command).append(BLANK_BYTE);
        for (byte[] b : args) {
            buffer.append(DOLLAR_BYTE).append(command.name().length()).append(BLANK_BYTE);
            buffer.append(new String(b)).append(BLANK_BYTE);
        }
        try {
            outputStream.write(buffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static enum Command {
        GET, SET
    }
}
