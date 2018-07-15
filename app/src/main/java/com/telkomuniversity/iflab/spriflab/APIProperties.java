package com.telkomuniversity.iflab.spriflab;

public class APIProperties {
    private static final String ROOT_URL = "http://10.30.40.32/KPAPI%20v.2/v1/api.php?apicall=";

    public static final String CREATE_BOOKING_URL = ROOT_URL + "createBooking";
    public static final String GET_BOOKING_URL = ROOT_URL + "getBookings";
    public static final String UPDATE_STATUS_URL = ROOT_URL + "updateStatus";
    public static final String DELETE_BOOKING_URL = ROOT_URL + "deleteBooking&id=";
}
