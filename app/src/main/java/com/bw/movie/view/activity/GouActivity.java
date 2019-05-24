package com.bw.movie.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.acitivity.BaseActivity;
import com.bw.movie.bean.hotmove.DownBean;
import com.bw.movie.bean.hotmove.PayBean;
import com.bw.movie.cont.ContractInterface;
import com.bw.movie.presenter.MyPresenter;
import com.bw.movie.util.EncryptUtil;
import com.bw.movie.view.LoginActivity;
import com.bw.movie.view.SeatTable;
import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GouActivity extends BaseActivity implements ContractInterface.GouInterface {
    SeatTable seatTable;
    TextView gou_name,gou_address,gou_movename,gou_time,text_ting,gou_price;
    ImageView img_cancel,img_sure;
    //paypopup的控件
    ImageView pay_down;
    RadioGroup group_pay;
    Button btn_pay;
    int type;
    String order;
    private IWXAPI iwxapi;
    ContractInterface.PresenterInterface presenterInterface;

    int pid;
    int num=0;
    double price;
    PopupWindow payPopup;
    double sum;
    RelativeLayout relative_pay;
    public static String appId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gou);
        presenterInterface=new MyPresenter<>(this);

        seatTable=findViewById(R.id.seatTable);
        gou_name=findViewById(R.id.gou_name);
        gou_address=findViewById(R.id.gou_address);
        gou_movename=findViewById(R.id.gou_movename);
        gou_time=findViewById(R.id.gou_time);
        text_ting=findViewById(R.id.text_ting);
        gou_price=findViewById(R.id.gou_price);
        img_cancel=findViewById(R.id.img_cancel);
        img_sure=findViewById(R.id.img_sure);
        relative_pay=findViewById(R.id.relative_pay);
        //intent
        Intent intent = getIntent();
        pid = intent.getIntExtra("pid", 0);
        String name = intent.getStringExtra("name");
        String address = intent.getStringExtra("address");
        final String movename = intent.getStringExtra("movename");
        String beginTime = intent.getStringExtra("beginTime");
        String endTime = intent.getStringExtra("endTime");
        String screeningHall = intent.getStringExtra("screeningHall");
        price = intent.getDoubleExtra("price", 0);
        gou_name.setText(name);
        gou_address.setText(address);
        gou_time.setText(beginTime+"—"+endTime);
        gou_movename.setText(movename);
        text_ting.setText(screeningHall);
        seatTable.setScreenName(screeningHall);//设置屏幕名称
        seatTable.setMaxSelected(5);//设置最多选中
        setPrice();
        img_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        img_sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPopup();
                View view = View.inflate(GouActivity.this, R.layout.activity_gou, null);
                payPopup.showAtLocation(view,Gravity.BOTTOM,0,0);
                String sign=LoginActivity.userId+""+pid+num+"movie";
                String s = md5Decode(sign);
                init(pid,num,s);
            }
        });



        seatTable.setSeatChecker(new SeatTable.SeatChecker() {

            @Override
            public boolean isValidSeat(int row, int column) {
                if(column==2) {
                    return false;
                }
                return true;
            }

            @Override
            public boolean isSold(int row, int column) {
                if(row==6&&column==6){
                    return true;
                }
                return false;
            }

            @Override
            public void checked(int row, int column) {
                num++;
                relative_pay.setVisibility(View.VISIBLE);
                setPrice();
            }

            @Override
            public void unCheck(int row, int column) {
                num--;
                setPrice();
            }

            @Override
            public String[] checkedSeatTxt(int row, int column) {
                return null;
            }

        });
        seatTable.setData(7,10);

    }

    public void setPrice(){
        sum = price * num;
        gou_price.setText(sum+"");
    }

    public String md5Decode(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException",e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        }
        //对生成的16字节数组进行补零操作
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10){
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public void init(int sche,int amount,String sign){
        presenterInterface.toDownMovie(sche,amount,sign);
    }
    public void setPopup(){
        View view = View.inflate(this, R.layout.layout_pay_popup, null);
        pay_down=view.findViewById(R.id.pay_down);
        group_pay=view.findViewById(R.id.group_pay);
        btn_pay=view.findViewById(R.id.btn_pay);
        payPopup=new PopupWindow(view,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        payPopup.setContentView(view);
        payPopup.setTouchable(true);
        payPopup.setFocusable(true);

        pay_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payPopup.dismiss();
                btn_pay.setVisibility(View.GONE);

            }
        });
        group_pay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1 :
                        btn_pay.setText("微信支付"+price+"元");
                        btn_pay.setVisibility(View.VISIBLE);
                        type=1;
                        break;
                    case R.id.rb2 :
                        btn_pay.setText("支付宝支付"+price+"元");
                        btn_pay.setVisibility(View.VISIBLE);
                        type=2;
                        break;
                    default: break;
                }
            }
        });
        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenterInterface.toPayMovie(type,order);
            }
        });
    }

    @Override
    public void showDown(Object o) {
        DownBean downBean= (DownBean) o;
        String message = downBean.getMessage();
        order = downBean.getOrderId();
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showPayMovie(Object o) {
        PayBean payBean= (PayBean) o;
        appId = payBean.getAppId();
        String partnerId = payBean.getPartnerId();
        String prepayId = payBean.getPrepayId();
        String packageValue = payBean.getPackageValue();
        String nonceStr = payBean.getNonceStr();
        String timeStamp = payBean.getTimeStamp();
        String sign = payBean.getSign();

        toWXPay(appId,partnerId,prepayId,packageValue,nonceStr,timeStamp,sign);
    }

    private void toWXPay(final String appId, final String partnerId, final String prepayId, final String packageValue, final String nonceStr, final String timeStamp, final String sign) {

        iwxapi = WXAPIFactory.createWXAPI(this, null); //初始化微信api

        iwxapi.registerApp(appId); //注册appid  appid可以在开发平台获取



        Runnable payRunnable = new Runnable() {  //这里注意要放在子线程

            @Override

            public void run() {

                PayReq request = new PayReq(); //调起微信APP的对象

                //下面是设置必要的参数，也就是前面说的参数,这几个参数从何而来请看上面说明
                request.appId = appId;
                request.partnerId = partnerId;
                request.prepayId= prepayId;
                request.packageValue =packageValue;
                request.nonceStr= nonceStr;
                request.timeStamp= timeStamp;
                request.sign= sign;

                iwxapi.sendReq(request);//发送调起微信的请求

            }

        };

        Thread payThread = new Thread(payRunnable);

        payThread.start();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterInterface.onDestroy();
        presenterInterface=null;
    }
}
