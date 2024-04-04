package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

public record Form(@Id String formId,
                   String source) {
                //   @Relationship(value = "FILED", direction = Relationship.Direction.INCOMING) Company company) {
}
