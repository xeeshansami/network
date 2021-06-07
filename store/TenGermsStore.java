package com.dk.tengerms.network.store;

import android.app.Application;

import com.dk.tengerms.network.ResponseHandlers.callbacks.LoginCallBack;
import com.dk.tengerms.network.ResponseHandlers.handler.LoginBaseHR;
import com.dk.tengerms.network.apiInterface.APIInterface;
import com.dk.tengerms.network.enums.RetrofitEnums;
import com.dk.tengerms.network.networkmodels.request.LoginRequest;
import com.dk.tengerms.network.timeoutInterface.IOnConnectionTimeoutListener;
import com.dk.tengerms.utils.GlobalClass;
import com.dk.tengerms.network.retrofitBuilder.RetrofitBuilder;
public class TenGermsStore extends Application implements IOnConnectionTimeoutListener {

    private static TenGermsStore consumerStore;

    //    APIInterface globalBaseUrl = RetrofitBuilder.INSTANCE.getRetrofitInstance(GlobalClass.applicationContext, RetrofitEnums.URL_HBL);
    public static TenGermsStore getInstance() {
        if (consumerStore == null)
            return new TenGermsStore();
        else
            return consumerStore;
    }

    //:TODO post getLogin
    public void getLogin(RetrofitEnums url, LoginRequest loginRequest, LoginCallBack loginCallBack) {
        APIInterface privateInstanceRetrofit = RetrofitBuilder.INSTANCE.getRetrofitInstance(GlobalClass.applicationContext, url);
        privateInstanceRetrofit.getLogin(loginRequest).enqueue(new LoginBaseHR(loginCallBack));
    }

    @Override
    public void onConnectionTimeout() {

    }
}
