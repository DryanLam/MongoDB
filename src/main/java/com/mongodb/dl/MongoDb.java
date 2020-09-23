package com.mongodb.dl;

import com.mongodb.*;

import java.util.List;

public class MongoDb {

    final String CONNECTION = "localhost";
    final int PORT = 27017;

    MongoClient dbClient;
    DB db;

    MongoDb() {
        dbClient = new MongoClient(CONNECTION, PORT);
    }

    public DB getDB(String dbName) {
        db = dbClient.getDB(dbName);
        return db;
    }

    public MongoClient getClient() {
        return dbClient;
    }

    public List getCollections() {
//        dbClient.getDatabaseNames().forEach(System.out::println);
        return dbClient.getDatabaseNames();
    }
}
