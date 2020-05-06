package com.ww.api;

import com.ww.connnection.Connection;
import com.ww.protocol.Protocol;

/**
 * api操作层
 */
public class Client {

    private Connection connection;

    public Client(String host, int port) {
        connection = new Connection(host, port);
    }

    /**
     * Set the string value as value of the key. The string can't be longer than 1073741824 bytes (1
     * GB).
     * <p>
     * Time complexity: O(1)
     *
     * @param key
     * @param value
     * @return Status code reply
     */
    public String set(final String key, final String value) {
        //发送数据
        connection.sendCommand(Protocol.Command.SET,Encode.encode(key),Encode.encode(value));
        return null;
    }


    /**
     * Get the value of the specified key. If the key does not exist null is returned. If the value
     * stored at key is not a string an error is returned because GET can only handle string values.
     * <p>
     * Time complexity: O(1)
     *
     * @param key
     * @return Bulk reply
     */
    public String get(final String key) {
        connection.sendCommand(Protocol.Command.GET,Encode.encode(key));
        return connection.getReply();
    }
}
