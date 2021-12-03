package com.evanemran.marvel.Listeners;

import com.evanemran.marvel.Model.SeriesResponse;

public interface SeriesResponseListener {
    void onFetch(SeriesResponse response, String message);
    void onError(String message);
}
