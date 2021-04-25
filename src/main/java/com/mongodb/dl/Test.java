package com.mongodb.dl;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.*;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;
import static java.util.Arrays.asList;

public class Test {
    public static void main(String[] args) {
        
        listAllCollections();
    }

    private static void listAllCollections() {
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("KataConnect");
        DBCollection col = db.getCollection("TestCases");

        // Check collections
        mD.getCollections().forEach(System.out::println);
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


    private static void practice03_QueryCollection() {
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("KataConnect");
        DBCollection col = db.getCollection("TestCases");

        // Query
        BasicDBObject  query = new BasicDBObject();
        query.put("covername", new BasicDBObject("$in", Arrays.asList("hai")));
        DBCursor cursor = col.find(query);

//        DBCursor myCursor = col.find().sort(new BasicDBObject("date",-1)).limit(10);

        List<DBObject> results  = cursor.toArray();

        List testcases = results.stream()
//                .filter(m -> m.get(""))
                .map(m -> m.get("testcase"))
                .collect(Collectors.toList());

        results.forEach(System.out::println);
        testcases.forEach(System.out::println);
    }

}
