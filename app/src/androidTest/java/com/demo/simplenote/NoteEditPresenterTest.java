package com.demo.simplenote;

import android.support.test.runner.AndroidJUnit4;

import com.demo.simplenote.api.NoteSyncAPi;
import com.demo.simplenote.domain.Note;
import com.demo.simplenote.network.NetworkWatchDog;
import com.demo.simplenote.ui.edit.NoteEditPresenter;
import com.demo.simplenote.ui.edit.NoteEditView;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * 在 Android 测试环境下，被测试 、被引用的类 中可以带有 Android SDK 的类库.
 *
 * Created by mrsimple on 18/10/17.
 */
@RunWith(AndroidJUnit4.class)
public class NoteEditPresenterTest extends Assert {

    NoteEditPresenter mPresenter ;
    NoteEditView mView ;
    NoteSyncAPi mApi ;
    NetworkWatchDog mDog ;

    @Before
    public void setUp() {
        mView = mock(NoteEditView.class) ;
        mApi = mock(NoteSyncAPi.class) ;
        mDog = mock(NetworkWatchDog.class) ;
        mPresenter = new NoteEditPresenter( mView, mApi , mDog) ;
        assertNotNull(mPresenter);
    }

    @After
    public void tearDown()  {
        mPresenter.detach();
        mPresenter = null;
    }


    @Test
    public void testViewIsNull() throws Exception {
        // set mView to null
        mPresenter.attach(null);

        Note note = new Note() ;
        mPresenter.save(note, "new-title", "new-content");

        verify(mApi, never()).saveNote(any(Note.class), any(NoteSyncAPi.SyncListener.class));
        verify(mView, never()).onSaved();
        verify(mView, never()).onSaveError();
    }


    @Test
    public void testNoteIsNull() throws Exception {
        // 执行函数
        mPresenter.save(null, "new-title", "new-content");

        // 验证结果
        verify(mApi, never()).saveNote(any(Note.class), any(NoteSyncAPi.SyncListener.class));
        verify(mView, never()).onSaved();
        verify(mView, times(1)).onSaveError();
    }


    @Test
    public void testNetworkIsNotAvailable() throws Exception {
        // 准备条件
        when(mDog.isNetworkAvailable()).thenReturn(false) ;

        // 执行函数
        mPresenter.save(new Note(), "new-title", "new-content");

        // 验证结果
        verify(mApi, never()).saveNote(any(Note.class), any(NoteSyncAPi.SyncListener.class));
        verify(mView, never()).onSaved();
        verify(mView, times(1)).onSaveError();
    }


    @Test
    public void testSaveSuccess() throws Exception {
        // 准备条件
        when(mDog.isNetworkAvailable()).thenReturn(true) ;

        // 执行函数
        mPresenter.save(new Note(), "new-title", "new-content");

        // 捕获参数
        ArgumentCaptor<NoteSyncAPi.SyncListener> captor = ArgumentCaptor.forClass(NoteSyncAPi.SyncListener.class) ;
        // 验证结果
        verify(mApi, times(1)).saveNote(any(Note.class), captor.capture());
        // 模拟api请求回调 onSuccess
        captor.getValue().onSuccess();

        verify(mView, times(1)).onSaved();
        verify(mView, never()).onSaveError();
    }
}
