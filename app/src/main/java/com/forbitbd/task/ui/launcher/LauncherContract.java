package com.forbitbd.task.ui.launcher;


import com.forbitbd.myplayer.models.OnlineStatus;

public interface LauncherContract {

    interface Presenter{
        void getOnlineStatus();
    }

    interface View{
        void updateStatus(OnlineStatus onlineStatus);
    }
}
