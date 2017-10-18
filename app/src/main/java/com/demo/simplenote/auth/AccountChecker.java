package com.demo.simplenote.auth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mrsimple on 18/10/17.
 */
public final class AccountChecker {
    private static final String PHONE_NUM_REX = "^1(3|8)\\d{9}$" ;
    private static final String EMAIL_REX = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";

    /**
     * 只接受 13 或者 18 开头的手机号
     * @param phone
     * @return
     */
    private static boolean isMobilePhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE_NUM_REX);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


    private static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REX);
        return pattern.matcher(email).matches();
    }

    public static boolean isValidAccount(String num) {
        if (num == null || num.length() == 0 ) {
            return false;
        }
        return isEmail(num) || isMobilePhone(num) ;
    }

}
