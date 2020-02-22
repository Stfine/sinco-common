package com.sinco.common.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeUtil {
    /**
     * 序列化
     * 
     * @param object
     * @return
     * @throws IOException 
     */
    public static byte[] serialize(Object object) throws IOException {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        // 序列化
        baos = new ByteArrayOutputStream();
        oos = new ObjectOutputStream(baos);
        oos.writeObject(object);
        byte[] bytes = baos.toByteArray();
        return bytes;
    }

    /**
     * 反序列化
     * 
     * @param bytes
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static Object unserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = null;
        // 反序列化
        bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        return ois.readObject();
    }
}