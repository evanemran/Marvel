package com.evanemran.marvel.Model;

public class UpcomingResponse {
    public int days_until;
    public FollowingProduction following_production;
    public String overview;
    public String poster_url;
    public String release_date;
    public String title;
    public String type;

    public class FollowingProduction{
        public int days_until;
        public String overview;
        public String poster_url;
        public String release_date;
        public String title;
        public String type;
    }
}
