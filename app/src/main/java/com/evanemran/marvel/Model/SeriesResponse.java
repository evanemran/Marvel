package com.evanemran.marvel.Model;

import java.util.List;

public class SeriesResponse {
    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public Data data;

    public class Url{
        public String type;
        public String url;
    }

    public class Thumbnail{
        public String path;
        public String extension;
    }

    public class Item{
        public String resourceURI;
        public String name;
        public String role;
        public String type;
    }

    public class Creators{
        public int available;
        public String collectionURI;
        public List<Item> items;
        public int returned;
    }

    public class Characters{
        public int available;
        public String collectionURI;
        public List<Item> items;
        public int returned;
    }

    public class Stories{
        public int available;
        public String collectionURI;
        public List<Item> items;
        public int returned;
    }

    public class Comics{
        public int available;
        public String collectionURI;
        public List<Item> items;
        public int returned;
    }

    public class Events{
        public int available;
        public String collectionURI;
        public List<Item> items;
        public int returned;
    }

    public class Next{
        public String resourceURI;
        public String name;
    }

    public class Previous{
        public String resourceURI;
        public String name;
    }

    public class Result{
        public int id;
        public String title;
        public String description;
        public String resourceURI;
        public List<Url> urls;
        public int startYear;
        public int endYear;
        public String rating;
        public String type;
        public String modified;
        public Thumbnail thumbnail;
        public Creators creators;
        public Characters characters;
        public Stories stories;
        public Comics comics;
        public Events events;
        public Next next;
        public Previous previous;
    }

    public class Data{
        public int offset;
        public int limit;
        public int total;
        public int count;
        public List<Result> results;
    }
}
