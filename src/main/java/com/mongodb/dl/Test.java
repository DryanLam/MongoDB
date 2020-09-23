package com.mongodb.dl;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import org.bson.Document;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        MongoDb mD = new MongoDb();
        DB db = mD.getDB("FlashHatch");
        DBCollection col = db.getCollection("TestCases");

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

//        mD.getCollections().forEach(System.out::println);
    }
}
