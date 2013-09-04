package com.supertool.dspui.framework.remote.connector;

import java.util.Map;

public abstract class Connector {

    /**
     * 用来推送信息的方法
     * 
     * @return
     * @throws Exception
     */
    public abstract boolean send(RemoteServer remoteServer, String key, String value) throws Exception;

    /**
     * 用来推送信息的方法，可以通过urlParams附加参数
     * 
     * @param remoteServer
     * @param key
     * @param value
     * @param urlParams
     * @return
     * @throws Exception
     */
    public abstract boolean send(RemoteServer remoteServer, String key, String value, Map<String, Object> urlParams) throws Exception;

    public abstract void release();

}