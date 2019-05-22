package com.bw.movie.acitivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class isNetWorkAcailable {

    public static boolean getNetWorkAvailable(Context context) {

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo info = manager.getActiveNetworkInfo();

        if (info != null){

            return info.isAvailable();
        }

        return false;
    }
}
