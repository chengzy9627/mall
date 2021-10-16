package io.renren.modules.platform.util;

public class StringUtils {
    public static boolean isBlank(String str){
        if (str == null || "".equals(str)){
            return true;
        }
        return false;
    }
    public static boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
