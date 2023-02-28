package com.haijie.workshop26.controllers;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.haijie.workshop26.models.Game;
import com.haijie.workshop26.models.Games;
import com.haijie.workshop26.services.BoardGameService;

@Controller
public class BoardGameController {

    @Autowired
    BoardGameService bgs;

    @GetMapping("/games")
    public ResponseEntity<String> listAllGames(@RequestParam(defaultValue = "25") int limit, @RequestParam(defaultValue = "0") int offset){

        List<Game> results = bgs.getAllGames(limit, offset);

        //for printing the endpoint
        Games games = new Games();

        games.setListOfGame(results);
        games.setOffset(offset);
        games.setLimit(limit);
        games.setTotal(results.size());
        games.setTimestamp(LocalDateTime.now());

         if (results.isEmpty()){
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON)
        .body("No Data. Please check your code.");
        }

        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(games.toJSON().toString());
        // this toJSON is the one that prints out the game id and name
    }

    @GetMapping("/games/rank")
    public ResponseEntity<String> getGamesByRank(@RequestParam(defaultValue = "25") int limit, @RequestParam(defaultValue = "0") int offset){

        List<Game> results = bgs.getGamesByRank(limit, offset);

        //for printing the endpoint
        Games games = new Games();

        games.setListOfGame(results);
        games.setOffset(offset);
        games.setLimit(limit);
        games.setTotal(results.size());
        games.setTimestamp(LocalDateTime.now());

         if (results.isEmpty()){
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .contentType(MediaType.APPLICATION_JSON)
        .body("No Data. Please check your code.");
        }

        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(games.toJSON2().toString());
        // this toJSON is the one that prints out the game id and name
    }
    
    @GetMapping("/game/{gid}")
    public ResponseEntity<String> getGameById(@PathVariable int gid){
        List<Game> results = bgs.getGameById(gid);
    
        Game g = results.get(0);

        if (results.isEmpty()){
            return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .contentType(MediaType.APPLICATION_JSON)
            .body("No Data. Please check your code.");
        }
        return ResponseEntity
        .status(HttpStatus.OK)
        .contentType(MediaType.APPLICATION_JSON)
        .body(g.toJSON3().toString());
    
    }
}
