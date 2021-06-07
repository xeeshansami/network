package com.dk.tengerms.network.apiInterface;

import com.dk.tengerms.network.networkmodels.request.LoginRequest;
import com.dk.tengerms.network.networkmodels.response.baseResponses.LoginResponse;
import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    @NotNull
    String HEADER_TAG = "@";
    @NotNull
    String HEADER_POSTFIX = ": ";
    @NotNull
    String HEADER_TAG_PUBLIC = "public";

    @POST("login.php")
    Call<LoginResponse> getLogin(@Body LoginRequest loginRequest);
}
