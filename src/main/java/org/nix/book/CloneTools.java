package org.nix.book;


import java.io.*;


/**
 * Create by zhangpe0312@qq.com on 2018/6/2.
 *
 * 用于深度克隆使用
 */
public class CloneTools {

    private CloneTools(){

    }

    /**
     * 深度复制
     * @param o 复制对象
     * @return 复制后的对象
     * @throws IOException IO异常
     * @throws ClassNotFoundException 反射失败
     */
    public static Object deepClone(Object o) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(o);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        return in.readObject();
    }


}
