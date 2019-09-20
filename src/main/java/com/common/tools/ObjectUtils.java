package com.common.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2019/9/20 11:21
 * @Email: 15290810931@163.com
 */
public class ObjectUtils {

    /**
     * 判断对象是否为空，只要有一个属性为空，则返回true。
     * 当所有属性不为空时，才返回false。
     * @param bean
     * @return
     */
    public static boolean checkFieldValueNull(Object bean) {
        boolean result = true;
        if (bean == null) {
            return true;
        }
        Class<?> cls = bean.getClass();
        Method[] methods = cls.getDeclaredMethods();
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            try {
                String fieldGetName = parGetName(field.getName());
                if (!checkGetMet(methods, fieldGetName)) {
                    continue;
                }
                Method fieldGetMet = cls.getMethod(fieldGetName, new Class[]{});
                Object fieldVal = fieldGetMet.invoke(bean, new Object[]{});
                if (fieldVal != null) {
                    if ("".equals(fieldVal)) {
                        result = true;
                    } else {
                        result = false;
                    }
                }else{
                    result = true;
                }
            } catch (Exception e) {
                continue;
            }
        }
        return result;
    }
    //拼接某属性的 get方法
    private static String parGetName(String fieldName) {
        if (null == fieldName || "".equals(fieldName)) {
            return null;
        }
        int startIndex = 0;
        if (fieldName.charAt(0) == '_')
            startIndex = 1;
        return "get"
                + fieldName.substring(startIndex, startIndex + 1).toUpperCase()
                + fieldName.substring(startIndex + 1);
    }
    //判断是否存在某属性的 get方法
    private static boolean checkGetMet(Method[] methods, String fieldGetMet) {
        for (Method met : methods) {
            if (fieldGetMet.equals(met.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断对象是否为空，只要有一个属性不为空,就返回false
     * 只有当对象的所有属性都是null,才返回true
     * @param obj
     * @return
     * @throws Exception
     */
    public static boolean isAllFieldNull(Object obj) throws Exception{
        // 得到类对象
        Class stuCla = (Class) obj.getClass();
        //得到属性集合
        Field[] fs = stuCla.getDeclaredFields();
        boolean flag = true;
        //遍历属性
        for (Field f : fs) {
            // 设置属性是可以访问的(私有的也可以)
            f.setAccessible(true);
            // 得到此属性的值
            Object val = f.get(obj);
            //只要有1个属性不为空,那么就不是所有的属性值都为空
            if(val!=null) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
