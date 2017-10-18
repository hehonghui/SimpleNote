package com.demo.simplenote;

import android.support.test.runner.AndroidJUnit4;

import com.demo.simplenote.api.NoteSyncAPi;
import com.demo.simplenote.network.NetworkWatchDog;
import com.demo.simplenote.ui.edit.NoteEditPresenter;
import com.demo.simplenote.ui.edit.NoteEditView;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.mock;

/**
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
        mPresenter.attach(null);
    }

    @Test
    public void testNetworkIsNotAvailable() throws Exception {

    }

    @Test
    public void testSaveSuccess() throws Exception {

    }
}
