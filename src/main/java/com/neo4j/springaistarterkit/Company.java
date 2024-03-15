package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

public record Company(@Id String cusip6,
                      String cusip,
                      Integer cik,
                      String name,
                      String all_names,
                      @Relationship(value = "OWNS_STOCK_IN", direction = Relationship.Direction.INCOMING) List<Manager> managers) {
}
