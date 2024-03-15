package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface DocumentRepository extends Neo4jRepository<Chunk, String> {
    @Query("MATCH (c:Chunk)-[r:PART_OF]->(f:Form) " +
            "WHERE c.chunkId IN $similarChunkIds " +
            "OPTIONAL MATCH (f)<-[r2:FILED]-(co:Company) " +
            "OPTIONAL MATCH (co)<-[r3:OWNS_STOCK_IN]-(m:Manager) " +
            "RETURN c, collect(r), collect(f), collect(r2), collect(co), collect(r3), collect(m);")
    List<Chunk> getRelatedEntitiesForSimilarChunks(List<String> similarChunkIds);
}
