package com.haijie.workshop26.models;

import org.bson.Document;

import java.time.LocalDateTime;

import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonObject;

public class Game {
    private int gid;
    private String name;
    private int year;
    private int ranking;
    private int usersRated;
    private String url;
    private String image;

    //conver document to game object
    public static Game create(Document doc){
        Game g = new Game();
        g.setGid(doc.getInteger("gid"));
        g.setName(doc.getString("name"));
        g.setYear(doc.getInteger("year"));
        g.setRanking(doc.getInteger("ranking"));
        g.setUsersRated(doc.getInteger("users_rated"));
        g.setUrl(doc.getString("url"));
        g.setImage(doc.getString("image"));

        return g;
    }

    public int getGid() {
        return gid;
    }
    public void setGid(int gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getRanking() {
        return ranking;
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
    public int getUsersRated() {
        return usersRated;
    }
    public void setUsersRated(int usersRated) {
        this.usersRated = usersRated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    //this controls what comes out
    //this is for showing all game
    public JsonObjectBuilder toJSON(){
        return Json.createObjectBuilder()
        .add("gid", this.getGid())
        .add("name", this.getName());
    }
    
    //this is for showing all games with rank and asc order
    public JsonObjectBuilder toJSON2(){
        return Json.createObjectBuilder()
        .add("gid", this.getGid())
        .add("name", this.getName())
        .add("ranking", this.getRanking());
    }

    //this is for search game by id
    public JsonObject toJSON3(){
        return Json.createObjectBuilder()
        .add("gid", this.getGid())
        .add("name", this.getName())
        .add("year", this.getYear())
        .add("ranking", this.getRanking())
        .add("users_rated", this.getUsersRated())
        .add("url", this.getUrl())
        .add("image", this.getImage())
        .add("timestamp", LocalDateTime.now().toString())
        .build();
    }

}
