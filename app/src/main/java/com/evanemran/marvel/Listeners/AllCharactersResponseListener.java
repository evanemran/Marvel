package com.evanemran.marvel.Listeners;

import com.evanemran.marvel.Model.AllCharacterAPIResponse;

public interface AllCharactersResponseListener {
    void onFetch(AllCharacterAPIResponse response, String message);
    void onError(String message);
}
