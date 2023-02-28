package com.haijie.workshop26.models;

import java.util.LinkedList;
import java.util.List;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

import java.time.LocalDateTime;

public class Games {

    private List<Game> listOfGame= new LinkedList<>();
    private int offset;
    private int limit;
    private int total;
    private LocalDateTime timestamp;

    public List<Game> getListOfGame() {
        return listOfGame;
    }
    public void setListOfGame(List<Game> listOfGame) {
        this.listOfGame = listOfGame;
    }
    public int getOffset() {
        return offset;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public JsonObject toJSON(){
        //Converting from Java Object: List to JSON object: Array
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        List<JsonObjectBuilder> listOfGames = this.getListOfGame()
        .stream()
        //Using Game.java JsonObjectBuilder toJSON method to build JsonObject for Game
        .map(g -> g.toJSON())
        .toList();
        //Iterate and add into ArrayBuilder
        for (JsonObjectBuilder x : listOfGames)
        arrBuilder.add(x);
    
        return Json.createObjectBuilder()
        //.add("games", this.GetGames().toString()) ; if String form suffice
        .add("games", arrBuilder)
        .add("offset", this.getOffset())
        .add("limit", this.getLimit())
        .add("total", this.getTotal())
        .add("timestamp", this.getTimestamp().toString())
        .build();
    }

    
    public JsonObject toJSON2(){
        //Converting from Java Object: List to JSON object: Array
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        List<JsonObjectBuilder> listOfGames = this.getListOfGame()
        .stream()
        //game.tojson to decide what comes out for the json obj
        .map(g -> g.toJSON2())
        .toList();
        //Iterate and add into ArrayBuilder
        for (JsonObjectBuilder x : listOfGames)
        arrBuilder.add(x);
    
        return Json.createObjectBuilder()
        //.add("games", this.GetGames().toString()) ; if String form suffice
        .add("games", arrBuilder)
        .add("offset", this.getOffset())
        .add("limit", this.getLimit())
        .add("total", this.getTotal())
        .add("timestamp", this.getTimestamp().toString())
        .build();
    }
    
}
