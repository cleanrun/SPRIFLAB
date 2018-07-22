package com.telkomuniversity.iflab.spriflab.ApiUtils;

import com.telkomuniversity.iflab.spriflab.Model.BookingInfo;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("api.php?apicall=getBookings")
    Call<List<BookingInfo>> getBookings();

    @FormUrlEncoded
    @POST("api.php?apicall=createBooking")
    Call<BookingInfo> addBooking(@FieldMap HashMap<String, String> booking);

    @PUT("api.php?apicall=updateStatus")
    Call<BookingInfo> updateStatus(@Path("status") String status, @Body BookingInfo booking);

    @DELETE("api.php?apicall=deleteBooking&={id}")
    Call<BookingInfo> deleteBooking(@Path("id") int id);

}
