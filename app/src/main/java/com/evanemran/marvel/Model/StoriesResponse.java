package com.evanemran.marvel.Model;

import java.util.List;

public class StoriesResponse {
    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public Data data;

    public class Item{
        public String resourceURI;
        public String name;
        public String role;
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

    public class Series{
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
        public List<Object> items;
        public int returned;
    }

    public class OriginalIssue{
        public String resourceURI;
        public String name;
    }

    public class Result{
        public int id;
        public String title;
        public String description;
        public String resourceURI;
        public String type;
        public String modified;
        public ComicResponse.Thumbnail thumbnail;
        public Creators creators;
        public Characters characters;
        public Series series;
        public Comics comics;
        public Events events;
        public OriginalIssue originalIssue;
    }

    public class Data{
        public int offset;
        public int limit;
        public int total;
        public int count;
        public List<Result> results;
    }
}
