package cn.edu.zut.trace.common.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
    public static String encode(String password){
        return DigestUtils.md5Hex(password);
    }
}
