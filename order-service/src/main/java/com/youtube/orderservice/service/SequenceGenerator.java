package com.youtube.orderservice.service;

import com.youtube.orderservice.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;


import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {
    @Autowired
    private MongoOperations mongoOperations;

 public int generateNextOrderID() {
    // Find the document with _id "sequence" and increment the seq field by 1
    Sequence counter = mongoOperations.findAndModify(
        query(where("_id").is("sequence")), // Query to find the document with _id "sequence"
        new Update().inc("seq", 1), // Update to increment the seq field by 1
        options().returnNew(true).upsert(true), // Options to return the new document and upsert if not found
        Sequence.class // The class type of the document
    );
    // Return the updated sequence number, ensuring the counter is not null
    return Objects.requireNonNull(counter).getSeq();
}
}
