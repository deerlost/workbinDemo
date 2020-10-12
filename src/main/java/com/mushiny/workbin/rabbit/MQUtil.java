package com.mushiny.workbin.rabbit;

import com.google.gson.Gson;

/**
 * 消息队列工具类
 *
 * @author zhuyc
 * @since 2.1.0
 */
public class MQUtil {

	public final static Gson GSON = new Gson();

	/**
	 * 将MQ消息转换为指定对象
	 *
	 * @param body
	 * @param classOfT
	 * @param <T>
	 * @return
	 */
	public static <T> T toObject(byte[] body, Class<T> classOfT) {
		if (body != null) {
			return GSON.fromJson(new String(body), classOfT);
		} else {
			return null;
		}
	}

	public static String toJson(Object o) {
		return GSON.toJson(o);
	}
}
