package com.evanemran.marvel.Model;

import java.util.List;

public class ComicResponse {
    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public Data data;


    public class Data{
        public int offset;
        public int limit;
        public int total;
        public int count;
        public List<Result> results;
    }

    public class Result{
        public int id;
        public int digitalId;
        public String title;
        public int issueNumber;
        public String variantDescription;
        public String description;
        public String modified;
        public String isbn;
        public String upc;
        public String diamondCode;
        public String ean;
        public String issn;
        public String format;
        public int pageCount;
        public List<TextObject> textObjects;
        public String resourceURI;
        public List<Url> urls;
        public Series series;
        public List<Variant> variants;
        public List<Collection> collections;
        public List<CollectedIssue> collectedIssues;
        public List<Date> dates;
        public List<Price> prices;
        public Thumbnail thumbnail;
        public List<Image> images;
        public Creators creators;
        public Characters characters;
        public Stories stories;
        public Events events;
    }

    public class TextObject{
        public String type;
        public String language;
        public String text;
    }

    public class Url{
        public String type;
        public String url;
    }

    public class Series{
        public String resourceURI;
        public String name;
    }

    public class Variant{
        public String resourceURI;
        public String name;
    }

    public class Collection{
        public String resourceURI;
        public String name;
    }

    public class CollectedIssue{
        public String resourceURI;
        public String name;
    }

    public class Date{
        public String type;
        public Object date;
    }

    public class Price{
        public String type;
        public double price;
    }

    public class Thumbnail{
        public String path;
        public String extension;
    }

    public class Image{
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

    public class Events{
        public int available;
        public String collectionURI;
        public List<Item> items;
        public int returned;
    }
}
