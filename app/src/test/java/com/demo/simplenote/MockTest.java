package com.demo.simplenote;

import com.demo.simplenote.network.NetworkWatchDog;

import junit.framework.Assert;

import org.junit.Test;

import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by mrsimple on 19/10/17.
 */
public class MockTest extends Assert {

    @Test
    public void testMock() throws Exception {
        NetworkWatchDog dog = mock(NetworkWatchDog.class);
        when(dog.isNetworkAvailable()).thenReturn(false) ;
        assertFalse(dog.isNetworkAvailable());

        // mock list
        List<String> strings = mock(List.class);
        when(strings.get(anyInt())).thenReturn("123") ;

        assertEquals(0, strings.size());
        assertEquals("123", strings.get(5));
        assertEquals("123", strings.get(12));
    }
}
