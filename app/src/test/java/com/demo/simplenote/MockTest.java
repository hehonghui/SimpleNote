package com.demo.simplenote;

import com.demo.simplenote.network.NetworkWatchDog;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by mrsimple on 19/10/17.
 */
public class MockTest extends Assert {

    @Test
    public void testMock() throws Exception {
        // mock list
        List<String> stringList = mock(List.class);
        when(stringList.get(anyInt())).thenReturn("123") ;

        // 没有调用过 List 的 get 方法
        verify(stringList, never()).get(anyInt()) ;

        assertEquals(0, stringList.size());
        assertEquals("123", stringList.get(5));
        assertEquals("123", stringList.get(12));
        // 调用过两次
        verify(stringList, times(2)).get(anyInt()) ;

        // mock 网络环境
        NetworkWatchDog dog = mock(NetworkWatchDog.class);
        when(dog.isNetworkAvailable()).thenReturn(false) ;
        assertFalse(dog.isNetworkAvailable());
    }


    @Test
    public void testFakeAsync() throws Exception {
        List mockList = mock(List.class);
        mockList.add("John");

        ArgumentCaptor argument = ArgumentCaptor.forClass(String.class);
        // 捕获参数
        verify(mockList).add(argument.capture());
        // 获取值
        assertEquals("John", argument.getValue());
    }



    // 字节码生成
//    class MockList implements List<String> {
//
//        public String get(int index) {
//            // 1. 记录调用
//            // 2. 返回特定的值
//            return "123";
//        }
//    }
}
