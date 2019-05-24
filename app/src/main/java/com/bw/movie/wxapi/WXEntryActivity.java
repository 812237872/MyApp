package com.bw.movie.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.bean.WXBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.view.LoginActivity;
import com.bw.movie.view.ShowActivity;
import com.tencent.mm.sdk.modelbase.BaseReq;
import com.tencent.mm.sdk.modelbase.BaseResp;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.WXAPIFactory;


public class WXEntryActivity extends Activity implements IWXAPIEventHandler ,ContractInterface.WxLoginInterface {

    private static final int RETURN_MSG_TYPE_LOGIN = 1;
    private static final int RETURN_MSG_TYPE_SHARE = 2;
    ContractInterface.PresenterInterface presenterInterface;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_wx);
        presenterInterface=new MyPresenter<>(WXEntryActivity.this);
        //如果没回调onResp，八成是这句没有写

        IWXAPI wxapi = WXAPIFactory.createWXAPI(this, "wxb3852e6a6b7d9516", false);
        wxapi.handleIntent(getIntent(), this);

    }

    // 微信发送请求到第三方应用时，会回调到该方法
    @Override
    public void onReq(BaseReq req) {
    }

    // 第三方应用发送到微信的请求处理后的响应结果，会回调到该方法
    //app发送消息给微信，处理返回消息的回调
    @Override
    public void onResp(BaseResp resp) {
        Log.e("tags","aaaa");
        switch (resp.errCode) {

            case BaseResp.ErrCode.ERR_AUTH_DENIED:
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                if (RETURN_MSG_TYPE_SHARE == resp.getType()){
                    Toast.makeText(WXEntryActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(WXEntryActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                break;
            case BaseResp.ErrCode.ERR_OK:
                switch (resp.getType()) {
                    case RETURN_MSG_TYPE_LOGIN:
                        Log.e("tags","sss");
                        //拿到了微信返回的code,立马再去请求access_token
                        String code = ((SendAuth.Resp) resp).code;
                        presenterInterface.toWxLogin(code);
                        //就在这个地方，用网络库什么的或者自己封的网络api，发请求去咯，注意是get请求
                        break;

                    case RETURN_MSG_TYPE_SHARE:

                        finish();
                        break;
                }
                break;
        }
    }


    @Override
    public void showWxLogin(Object o) {
        WXBean wxBean = (WXBean) o;
        LoginActivity.sessionId = wxBean.getResult().getSessionId();
        LoginActivity.userId = wxBean.getResult().getUserId();
        if (wxBean.getMessage().equals("登陆成功")){
            Toast.makeText(this,wxBean.getMessage(),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(WXEntryActivity.this,ShowActivity.class);
            startActivity(intent);

            finish();
        }else {
            Toast.makeText(this,wxBean.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
