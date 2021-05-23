package com.mongodb.dl;

import com.mongodb.*;

import java.util.List;

public class MongoDb {

    private String CONNECTION = "localhost";
    private int PORT = 27017;

    MongoClient dbClient;
    DB db;

    MongoDb() {
        dbClient = new MongoClient(CONNECTION, PORT);
    }
    MongoDb(String connection, int port) {
        CONNECTION = connection;
        PORT = port;
        dbClient = new MongoClient(connection, port);
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
