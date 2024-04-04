package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface DocumentRepository extends Neo4jRepository<Chunk, String> {
    @Query("MATCH (chunk:Chunk)-[r:PART_OF]->(form:Form) " +
            "WHERE chunk.chunkId IN $similarChunkIds " +
            "OPTIONAL MATCH (form)<-[r2:FILED]-(company:Company) " +
            "OPTIONAL MATCH (company)<-[r3:OWNS_STOCK_IN]-(manager:Manager) " +
            "RETURN chunk, collect(r), collect(form), collect(r2), collect(company), collect(r3), collect(manager);")
    List<Chunk> getRelatedEntitiesForSimilarChunks(List<String> similarChunkIds);
}
