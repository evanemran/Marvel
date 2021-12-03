package com.evanemran.marvel.Listeners;

import com.evanemran.marvel.Model.UpcomingResponse;

public interface UpcomingApiResponseListener {
    void onFetch(UpcomingResponse response, String message);
    void onError(String message);
}
