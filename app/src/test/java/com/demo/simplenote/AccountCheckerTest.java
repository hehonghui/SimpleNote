package com.demo.simplenote;

import com.demo.simplenote.auth.AccountChecker;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by mrsimple on 18/10/17.
 */

public class AccountCheckerTest extends Assert  {

    @Test
    public void testPhoneNumFailed() throws Exception {
        assertFalse(AccountChecker.isValidAccount(""));
        assertFalse(AccountChecker.isValidAccount("12"));
        assertFalse(AccountChecker.isValidAccount("13"));
        assertFalse(AccountChecker.isValidAccount("145"));
        assertFalse(AccountChecker.isValidAccount("14577777777777777"));

        // 11位的，但是不合法, 只接受 13 或者 18 开头的
        assertFalse(AccountChecker.isValidAccount("11677889900"));
        assertFalse(AccountChecker.isValidAccount("12677889900"));
        assertFalse(AccountChecker.isValidAccount("14677889900"));
        assertFalse(AccountChecker.isValidAccount("15677889900"));
        assertFalse(AccountChecker.isValidAccount("16677889900"));
        assertFalse(AccountChecker.isValidAccount("17677889900"));
        assertFalse(AccountChecker.isValidAccount("19677889900"));

        // 10位
        assertFalse(AccountChecker.isValidAccount("1267788990"));
        // 12位
        assertFalse(AccountChecker.isValidAccount("126778899000"));
        // null
        assertFalse(AccountChecker.isValidAccount(null));
    }


    @Test
    public void testPhoneNumSuccess() throws Exception {
        assertTrue(AccountChecker.isValidAccount("13677889900"));
        assertTrue(AccountChecker.isValidAccount("18677889900"));

    }


    @Test
    public void testPhoneEmailFailed() throws Exception {
        assertFalse(AccountChecker.isValidAccount("13haha"));
        assertFalse(AccountChecker.isValidAccount("haha145"));
        assertFalse(AccountChecker.isValidAccount("@sina.com"));
        assertFalse(AccountChecker.isValidAccount("@sina"));
        assertFalse(AccountChecker.isValidAccount("@"));
        assertFalse(AccountChecker.isValidAccount("www.google.com"));
    }


    @Test
    public void testPhoneEmail() throws Exception {
        assertTrue(AccountChecker.isValidAccount("haha145@a.cn"));
        assertTrue(AccountChecker.isValidAccount("123@test.cn"));
        assertTrue(AccountChecker.isValidAccount("hello123@test.com"));
    }
}
