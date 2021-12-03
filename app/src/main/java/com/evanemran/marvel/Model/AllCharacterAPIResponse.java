package com.evanemran.marvel.Model;

import java.util.List;

public class AllCharacterAPIResponse {
    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public Data data;

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public String getEtag() {
        return etag;
    }

    public Data getData() {
        return data;
    }

    public class Data{
        public int offset;
        public int limit;
        public int total;
        public int count;
        public List<Result> results;

        public int getOffset() {
            return offset;
        }

        public int getLimit() {
            return limit;
        }

        public int getTotal() {
            return total;
        }

        public int getCount() {
            return count;
        }

        public List<Result> getResults() {
            return results;
        }
    }

    public class Result{
        public int id;
        public String name;
        public String description;
        public String modified;
        public Thumbnail thumbnail;
        public String resourceURI;
        public Comics comics;
        public Series series;
        public Stories stories;
        public Events events;
        public List<Url> urls;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getModified() {
            return modified;
        }

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public String getResourceURI() {
            return resourceURI;
        }

        public Comics getComics() {
            return comics;
        }

        public Series getSeries() {
            return series;
        }

        public Stories getStories() {
            return stories;
        }

        public Events getEvents() {
            return events;
        }

        public List<Url> getUrls() {
            return urls;
        }
    }
    public class Url{
        public String type;
        public String url;
    }

    public class Events{
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

    public class Item{
        public String resourceURI;
        public String name;
        public String type;
    }

    public class Thumbnail{
        public String path;
        public String extension;
    }
}
