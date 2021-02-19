package com.unco.client.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author HeXianGang
 * @create 2020-05-12 9:03
 */
public class WebUtils {
    /**
     *
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
        }
        return bean;
    }

    /**
     * 将字符串解析为数值
     * @param strInt 要解析的字符串
     * @param defaultValue 默认数值
     * @return 转换后的数值
     */
    public static int paratInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {

        }
        return defaultValue;
    }
}
