package com.example.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * @author wangfc
 * @desciption
 * @date 2018/7/10
 */
public class FastJson2JsonRedisSerializer<T> implements RedisSerializer<T> {

    private Charset charset ;

    private Class<T> clazz;

    public FastJson2JsonRedisSerializer(Class<T> clazz){
        this(clazz,Charset.forName("UTF-8"));
    }

    public FastJson2JsonRedisSerializer(Class<T> clazz,Charset charset){
        this.clazz = clazz;
        this.charset = charset;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(charset);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, charset);
        return JSON.parseObject(str, clazz);
    }
}
