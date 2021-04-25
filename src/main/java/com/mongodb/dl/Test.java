package com.mongodb.dl;

import com.mongodb.*;
import com.mongodb.util.JSON;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

//        listAllCollections();
        Properties prop = System.getProperties();
        String conn = prop.getProperty("mongodb.host");
        String port = prop.getProperty("mongodb.port");
        if(conn == null){
            conn = "localhost";
        }

        if(port == null){
            port = "27017";
        }

        System.out.println(conn);
        System.out.println(port);

        listAllCollections(conn, Integer.parseInt(port));
    }

    private static void listAllCollections() {
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("KataConnect");
        DBCollection col = db.getCollection("TestCases");

        // Check collections
//        mD.getCollections().forEach(System.out::println);
        List<String> cols = mD.getCollections();
        for (String i : cols ) {
            System.out.println(i);
        }
    }

    private static void practice01_InsertMapObject() {
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("KataConnect");
        DBCollection col = db.getCollection("TestCases");

        // Work well
        // Set name
        Set tcs = new TreeSet();
        tcs.add("hai");
        tcs.add("ghe");

        // Data catching
        Map data = new LinkedHashMap();
        data.put("testcase", "Dryan");
        data.put("covername", tcs);

        // Insert into collection
        col.insert(new BasicDBObject(data));
    }


    private static void practice02_InsertJsonObject() {
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("KataConnect");
        DBCollection col = db.getCollection("TestCases");


        // Work well
        // Working with JSON string
        String json = "{ 'name' : 'lokesh' , " +
                "'website' : 'howtodoinjava.com' , " +
                "'address' : { 'addressLine1' : 'Some address' , " +
                "'addressLine2' : 'Karol Bagh' , " +
                "'addressLine3' : 'New Delhi, India'}" +
                "}";

        DBObject dbObject = (DBObject) JSON.parse(json);
        col.insert(dbObject);
    }


//    private static void practice03_QueryCollection() {
//        MongoDb mD = new MongoDb();
//        DB db = mD.getDB("KataConnect");
//        DBCollection col = db.getCollection("TestCases");
//
//        // Query
//        BasicDBObject query = new BasicDBObject();
//        query.put("covername", new BasicDBObject("$in", Arrays.asList("hai")));
//        DBCursor cursor = col.find(query);
//
////        DBCursor myCursor = col.find().sort(new BasicDBObject("date",-1)).limit(10);
//
//        List<DBObject> results = cursor.toArray();
//
//        List testcases = results.stream()
////                .filter(m -> m.get(""))
//                .map(m -> m.get("testcase"))
//                .collect(Collectors.toList());
//
//        results.forEach(System.out::println);
//        testcases.forEach(System.out::println);
//    }


    private static void listAllCollections(String conn, int port) {
        MongoDb mD = new MongoDb(conn, port);
        DB db = mD.getDB("KataConnect");
        DBCollection col = db.getCollection("TestCases");

        // Check collections
        List<String> cols = mD.getCollections();
        for (String i : cols ) {
            System.out.println(i);
        }
    }
}
