package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

public record Chunk(@Id String chunkId,
                    Integer chunkSeqId,
                    String text,
                    @Relationship(value = "PART_OF") Form form) {
}
