package com.bw.movie.acitivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.bw.movie.util.NetUtil;

public class NetworkChangeReceiver extends BroadcastReceiver {
    public static String TAG = "NetworkChangeReceiver";
    public NetEvevt evevt = BaseActivity.evevt;
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Hxh","MainActivity:"+intent.getAction());
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            //Toast.makeText(context, "network change", Toast.LENGTH_SHORT).show();
            evevt.onNetChange(NetUtil.getNetWorkState(context));
                 }
              }
            public interface NetEvevt {
                public void onNetChange(int netModel);
                //网络状态改变时的回调
                 }

}
