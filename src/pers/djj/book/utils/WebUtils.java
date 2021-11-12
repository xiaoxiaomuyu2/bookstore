package pers.djj.book.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class WebUtils {
    public static <T> T copyParamToBean(Map<String, String[]> values, T bean) {
        try {
//            System.out.println("Before populate: " + bean);
            BeanUtils.populate(bean, values);
//            System.out.println("After populate: " + bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt, int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

    public static String getFullReferrerUrl(HttpServletRequest req) {
//        String referrer = req.getHeader("Referer");
//        String contextPath = req.getContextPath();
//
//        if(referrer.substring(0, referrer.length() - 1).endsWith(contextPath)) {
//            return referrer;
//        } else {
//            return referrer + contextPath.substring(1) + "/";
//        }
        System.out.println(req.getHeader("Referer"));
        return req.getHeader("Referer");
    }
}
