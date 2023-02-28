package com.haijie.workshop26.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

//important to add static
import static com.haijie.workshop26.Constants.*;

@Repository
public class BoardGameRepository {
    
    @Autowired
    private MongoTemplate mongoTemplate;

    //default to 25 and 0
    public List<Document> getAllGames(){
        return getAllGames(25,0);
    }

    public List<Document> getGamesByRank(){
        return getGamesByRank(25,0);
    }

    public List<Document> getAllGames(int limit, int offset){
        
        Criteria c = new Criteria();

        Query q = Query.query(c).limit(limit).skip(offset);

        return mongoTemplate.find(q,Document.class,COLLECTION_GAME);
    }


    public List<Document> getGamesByRank(int limit, int offset){
        
        Criteria c = new Criteria();

        Query q = Query.query(c)
                        .with(Sort.by(Direction.ASC, FIELD_RANKING))
                        .limit(limit)
                        .skip(offset);

        return mongoTemplate.find(q, Document.class, COLLECTION_GAME);
    }

    public List<Document> getGameById(int gid){
        
        Criteria c = Criteria.where(FIELD_GID).in(gid);

        Query q = Query.query(c);

        return mongoTemplate.find(q,Document.class,COLLECTION_GAME);
    }
}
