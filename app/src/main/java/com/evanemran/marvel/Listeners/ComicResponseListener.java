package com.evanemran.marvel.Listeners;

import com.evanemran.marvel.Model.ComicResponse;

public interface ComicResponseListener {
    void onFetch(ComicResponse response, String message);
    void onError(String message);
}
