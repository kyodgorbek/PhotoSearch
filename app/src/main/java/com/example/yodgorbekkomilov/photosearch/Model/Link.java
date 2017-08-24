package com.example.yodgorbekkomilov.photosearch.Model;

import java.io.Serializable;

/**
 * Created by yodgorbekkomilov on 8/24/17.
 */

public class Link implements Serializable {
    private String id;
    private String secret;
    private String server;
    private String farm;
    private String tite;
    public Link(String id, String secret, String server, String farm,String title) {
        this.id = id;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.tite = title;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return "http://farm" + farm + ".static.flickr.com/" + server + "/" + id + "_" + secret + ".jpg";
    }

    public String getTite() {
        return tite;
    }
}
