package com.bw.movie.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtil {
    /**     * 无网络状态     */
    private static final int NETWORK_NONET = -1;
    /**     * 数据网络状态     */
    private static final int NETWORK_DATA = 0;
    /**     * WIFI网络状态     */
    private static final int NETWORK_WIFI = 1;
    /**     * 网络不可用状态     */
    private static final int NETWORK_NO_WORK = 100;
    /**     * wifi网络状态，且网络可用     */
    public static final int WIFI_NET_WORKED =201;
    /**     * WiFi网络不可用     */
    public static final int WIFI_NET_USELESS = 200;
    /**     * wifi状态未连接（网络是否可用未知）     */
    public static final int WIFI_STATU_DISABLE = 300;
    /**     * WiFi状态已连接（网络是否可用未知）     */
    public static final int WIFI_STATU_ENABLE =301;
    /**     * WiFi正在断开中     */
    public static final int WIFI_STATU_DISABLING = 302;
    /**     * WiFi正在连接中（网络是否可用未知）     */
    public static final int WIFI_STATU_ENABLING = 303;
    /**     * WiFi未知状态     */
    public static final int WIFI_STATU_UNKNOW = 305;

    public static int getNetWorkState(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetWorkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetWorkInfo!=null && activeNetWorkInfo.isConnected()){
            if (activeNetWorkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                return NETWORK_WIFI;
            }else if (activeNetWorkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                return NETWORK_DATA;
            }else {
                return NETWORK_NONET;
            }
        }else {
            return NETWORK_NONET;
        }
    }

}
