package com.telkomuniversity.iflab.spriflab.ApiUtils;

public class APIProperties {
    private static final String ROOT_URL = "http://192.168.137.1/KPAPI%20v.2/v1/";

    public static final String CREATE_BOOKING_URL = ROOT_URL + "createBooking";
    public static final String GET_BOOKING_URL = ROOT_URL + "getBookings";
    public static final String UPDATE_STATUS_URL = ROOT_URL + "updateStatus";
    public static final String DELETE_BOOKING_URL = ROOT_URL + "deleteBooking&id=";

    public static UserService getUserService(){
        return RetrofitClient.getClient(ROOT_URL).create(UserService.class);
    }
}
