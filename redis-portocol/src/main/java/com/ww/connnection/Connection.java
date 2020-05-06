package com.ww.connnection;

import com.ww.protocol.Protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 传输层
 */
public class Connection {
    private Socket socket;
    private String host;
    private int port;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Connection(String host, int port) {
        this.port = port;
        this.host = host;
    }

    public void connect() {
        try {
            socket = new Socket(host, port);
            outputStream = socket.getOutputStream();
            inputStream = socket.getInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 发送数据
     *
     * @param command
     * @param args
     * @return
     */
    public Connection sendCommand(Protocol.Command command, byte[]... args) {
        //连接
        connect();
        Protocol.sendCommand(outputStream, command, args);
        return this;
    }

    public String getReply() {
        byte[] b = new byte[1024];
        try {
            socket.getInputStream().read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(b);
    }
}
