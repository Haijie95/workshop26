package com.haijie.workshop26.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haijie.workshop26.models.Game;
import com.haijie.workshop26.repositories.BoardGameRepository;

@Service
public class BoardGameService {
    
    @Autowired
    BoardGameRepository bgr;

    public List<Game> getAllGames(int limit, int offset){
        return bgr.getAllGames(limit, offset)
        .stream()
        .map(g->Game.create(g))
        .toList(); //convert to list
    }

    
    public List<Game> getGamesByRank(int limit, int offset){
        return bgr.getGamesByRank(limit, offset)
        .stream()
        .map(g->Game.create(g))
        .toList(); //convert to list
    }

    public List<Game> getGameById(int gid){
        return bgr.getGameById(gid)
        .stream()
        .map(g->Game.create(g))
        .toList();
    }

}
