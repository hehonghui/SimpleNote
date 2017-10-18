package com.demo.simplenote;

import com.demo.simplenote.domain.Note;
import com.demo.simplenote.network.NetworkWatchDog;

import junit.framework.TestCase;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by mrsimple on 18/10/17.
 */

public class NoteListSortTest extends TestCase {

    private List<Note> mNotes = new LinkedList<>() ;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        mNotes.addAll(mockNotes()) ;
    }

    private List<Note> mockNotes() {
        List<Note> notes = new LinkedList<>() ;
        for (int i = 0; i < 5; i++) {
            Note item = new Note() ;
            item.title = "Note - " + i ;
            item.content = "Note - " + i + " content !!!!";
            item.modifyTimeStamp = i;
            notes.add(item) ;
        }
        return notes ;
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        mNotes.clear();
    }

    public void testSort() throws Exception {
        // 执行排序之前
        assertEquals(mNotes.get(0).modifyTimeStamp, 0);
        // 执行排序
        Collections.sort(mNotes);

        // 执行排序之后
        assertEquals(mNotes.get(0).modifyTimeStamp, 4);
        assertEquals(mNotes.get(1).modifyTimeStamp, 3);
        assertEquals(mNotes.get(2).modifyTimeStamp, 2);
        assertEquals(mNotes.get(3).modifyTimeStamp, 1);
        assertEquals(mNotes.get(4).modifyTimeStamp, 0);
    }


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
