package com.example.yodgorbekkomilov.photosearch.Model;

/**
 * Created by yodgorbekkomilov on 8/24/17.
 */

public class Photos {

    public SimplePhoto photos;

    public static class SimplePhoto{
        /*
        * "page": 1,
        "pages": 1856,
        "perpage": 100,
        "total": "185548",*/
        public int page;
        public int pages;
        public int perpage;
        public String total;
        public Photo[] photo;
        public String stat;


    }
    public static class Photo{
        /*
        *       "id": "36753557705",
                "owner": "155259285@N04",
                "secret": "3564896972",
                "server": "4435",
                "farm": 5,
                "title": "Scoop: tonight show starring jimmy fallon 8/10 - 8/16 on nbc",
                "ispublic": 1,
                "isfriend": 0,
                "isfamily": 0
        * */
        private String id;
        private String owner;
        private String secret;
        private String server;
        private int farm;
        private String title;
        private int ispublic;
        private int isfriend;
        private int isfamily;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public int getFarm() {
            return farm;
        }

        public void setFarm(int farm) {
            this.farm = farm;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getIspublic() {
            return ispublic;
        }

        public void setIspublic(int ispublic) {
            this.ispublic = ispublic;
        }

        public int getIsfriend() {
            return isfriend;
        }

        public void setIsfriend(int isfriend) {
            this.isfriend = isfriend;
        }

        public int getIsfamily() {
            return isfamily;
        }

        public void setIsfamily(int isfamily) {
            this.isfamily = isfamily;
        }
    }
}

