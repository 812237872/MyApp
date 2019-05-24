package com.bw.movie.acitivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.util.NetUtil;
import com.bw.movie.view.activity.NotNetActivity;

public abstract class BaseActivity extends AppCompatActivity implements NetworkChangeReceiver.NetEvevt {
    public static NetworkChangeReceiver.NetEvevt evevt ;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;
    /**     * 网络类型     * @param savedInstanceState     */
    private int netModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evevt=this;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);
        inspectNet();

    }
    public boolean inspectNet(){
        this.netModel = NetUtil.getNetWorkState(BaseActivity.this);
        return isNetConnect();
    }
    /**     * 判断当前网络状态     * @return     */
    public boolean isNetConnect(){
        if (netModel == 1){
            return true;
        }else if (netModel == 0){
            return true;
        }else if (netModel == -1){
            return false;
        }
        return false;
    }
    @Override
    public void onNetChange(int netModel) {
        if(netModel==-1){
            Intent intent = new Intent(BaseActivity.this, NotNetActivity.class);
            startActivity(intent);
        }else if(netModel==1 || netModel==0){
            if(NotNetActivity.instance!=null){
                NotNetActivity.instance.finish();
            }
        }
    }

}
