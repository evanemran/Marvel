package com.evanemran.marvel;

import android.content.Context;
import android.widget.Toast;

import com.evanemran.marvel.Listeners.AllCharactersResponseListener;
import com.evanemran.marvel.Listeners.ComicResponseListener;
import com.evanemran.marvel.Listeners.SeriesResponseListener;
import com.evanemran.marvel.Listeners.StoriesResponseListener;
import com.evanemran.marvel.Listeners.UpcomingApiResponseListener;
import com.evanemran.marvel.Model.AllCharacterAPIResponse;
import com.evanemran.marvel.Model.ComicResponse;
import com.evanemran.marvel.Model.SeriesResponse;
import com.evanemran.marvel.Model.StoriesResponse;
import com.evanemran.marvel.Model.UpcomingResponse;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RequestManager {
    Context context;
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443/v1/public/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    //for upcoming api
    Retrofit retrofit_upcoming = new Retrofit.Builder()
            .baseUrl("https://whenisthenextmcufilm.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RequestManager(Context context) {
        this.context = context;
    }

    public void getAllCharacters(AllCharactersResponseListener listener){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetAllCharacters getAllCharacters =retrofit.create(GetAllCharacters.class);
        Call<AllCharacterAPIResponse> call = getAllCharacters.callAllCharacters("99", "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<AllCharacterAPIResponse>() {
            @Override
            public void onResponse(Call<AllCharacterAPIResponse> call, Response<AllCharacterAPIResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<AllCharacterAPIResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void searchCharacters(AllCharactersResponseListener listener, String name){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        SearchAllCharacters searchAllCharacters =retrofit.create(SearchAllCharacters.class);
        Call<AllCharacterAPIResponse> call = searchAllCharacters.searchAllCharacters("99", name, "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<AllCharacterAPIResponse>() {
            @Override
            public void onResponse(Call<AllCharacterAPIResponse> call, Response<AllCharacterAPIResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<AllCharacterAPIResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void getCharacter(AllCharactersResponseListener listener, String character_id){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetCharacter getCharacter =retrofit.create(GetCharacter.class);
        Call<AllCharacterAPIResponse> call = getCharacter.callAllCharacters(character_id, "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<AllCharacterAPIResponse>() {
            @Override
            public void onResponse(Call<AllCharacterAPIResponse> call, Response<AllCharacterAPIResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<AllCharacterAPIResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void getCharacterComic(ComicResponseListener listener, String character_id){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetCharacterComics getCharacterComics =retrofit.create(GetCharacterComics.class);
        Call<ComicResponse> call = getCharacterComics.callAllCharacters(character_id, "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<ComicResponse>() {
            @Override
            public void onResponse(Call<ComicResponse> call, Response<ComicResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<ComicResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }


    public void getComicDetails(ComicResponseListener listener, String comic_id){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetComicDetails getComicDetails =retrofit.create(GetComicDetails.class);
        Call<ComicResponse> call = getComicDetails.callComicDetails(comic_id, "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<ComicResponse>() {
            @Override
            public void onResponse(Call<ComicResponse> call, Response<ComicResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<ComicResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void getCharacterSeries(SeriesResponseListener listener, String character_id){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetCharacterSeries getCharacterSeries =retrofit.create(GetCharacterSeries.class);
        Call<SeriesResponse> call = getCharacterSeries.callCharacterSeries(character_id, "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<SeriesResponse>() {
            @Override
            public void onResponse(Call<SeriesResponse> call, Response<SeriesResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<SeriesResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void getCharacterStories(StoriesResponseListener listener, String character_id){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetCharacterStories getCharacterStories =retrofit.create(GetCharacterStories.class);
        Call<StoriesResponse> call = getCharacterStories.callCharacterStories(character_id, "1", context.getString(R.string.api_key), context.getString(R.string.hash_key));

        call.enqueue(new Callback<StoriesResponse>() {
            @Override
            public void onResponse(Call<StoriesResponse> call, Response<StoriesResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<StoriesResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }

    public void getUpcomingMovie(UpcomingApiResponseListener listener){
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        GetUpcomingMovie getUpcomingMovie =retrofit_upcoming.create(GetUpcomingMovie.class);
        Call<UpcomingResponse> call = getUpcomingMovie.callUpcomingMovies();

        call.enqueue(new Callback<UpcomingResponse>() {
            @Override
            public void onResponse(Call<UpcomingResponse> call, Response<UpcomingResponse> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(context, "Request Unsuccessful!", Toast.LENGTH_SHORT).show();
                    return;
                }
                listener.onFetch(response.body(), response.message());
            }

            @Override
            public void onFailure(Call<UpcomingResponse> call, Throwable t) {
                listener.onError(t.getMessage());
            }
        });
    }


    private interface GetAllCharacters {
        @GET("characters")
        Call<AllCharacterAPIResponse> callAllCharacters(
                @Query("limit") String limit,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }
    private interface SearchAllCharacters {
        @GET("characters")
        Call<AllCharacterAPIResponse> searchAllCharacters(
                @Query("limit") String limit,
                @Query("name") String name,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }
    private interface GetCharacter {
        @GET("characters/{character_id}")
        Call<AllCharacterAPIResponse> callAllCharacters(
                @Path("character_id") String character_id,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }

    private interface GetCharacterComics {
        @GET("characters/{character_id}/comics")
        Call<ComicResponse> callAllCharacters(
                @Path("character_id") String character_id,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }

    private interface GetCharacterSeries {
        @GET("characters/{character_id}/series")
        Call<SeriesResponse> callCharacterSeries(
                @Path("character_id") String character_id,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }

    private interface GetCharacterStories {
        @GET("characters/{character_id}/stories")
        Call<StoriesResponse> callCharacterStories(
                @Path("character_id") String character_id,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }

    private interface GetComicDetails {
        @GET("comics/{comic_id}")
        Call<ComicResponse> callComicDetails(
                @Path("comic_id") String comic_id,
                @Query("ts") String time_stamp,
                @Query("apikey") String api_key,
                @Query("hash") String hash
        );
    }

    private interface GetUpcomingMovie {
        @GET("api")
        Call<UpcomingResponse> callUpcomingMovies();
    }

//    private String getHash(String ts) throws NoSuchAlgorithmException {
//        String plaintext = ts+;
//        MessageDigest m = MessageDigest.getInstance("MD5");
//        m.reset();
//        m.update(plaintext.getBytes());
//        byte[] digest = m.digest();
//        BigInteger bigInt = new BigInteger(1,digest);
//        String hashtext = bigInt.toString(16);
//// Now we need to zero pad it if you actually want the full 32 chars.
//        while(hashtext.length() < 32 ){
//            hashtext = "0"+hashtext;
//        }
//    }
}
