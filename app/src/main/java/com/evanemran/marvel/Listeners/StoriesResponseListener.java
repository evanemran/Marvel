package com.evanemran.marvel.Listeners;

import com.evanemran.marvel.Model.SeriesResponse;
import com.evanemran.marvel.Model.StoriesResponse;

public interface StoriesResponseListener {
    void onFetch(StoriesResponse response, String message);
    void onError(String message);
}
