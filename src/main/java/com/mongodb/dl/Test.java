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
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("FlashHatch");
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


        // Check collections
        mD.getCollections().forEach(System.out::println);

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
