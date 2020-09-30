package com.mushiny.workbin.netty;


import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class LiveChannnelHolder {
    private static Map<String, Channel> channelCache = new ConcurrentHashMap<>();

    public static void add(String userCode, Channel channel) {
        channelCache.put(userCode, channel);
    }

    public static Channel remove(String userCode) {
        return channelCache.remove(userCode);
    }

    public static void remove(Channel channel) {
        for (Map.Entry entry : channelCache.entrySet()) {
            if (entry.getValue().equals(channel)) {
                channelCache.remove(entry.getKey().toString());
                break;
            }
        }
    }

    public static String get(Channel channel) {
        for (Map.Entry entry : channelCache.entrySet()) {
            if (entry.getValue().equals(channel)) {
                return (String) entry.getKey();
            }
        }
        return "";
    }

    public static Map<String, Channel> getChannelCache() {
        return channelCache;
    }

    public static void setChannelCache(Map<String, Channel> channelCache) {
        LiveChannnelHolder.channelCache = channelCache;
    }
}
