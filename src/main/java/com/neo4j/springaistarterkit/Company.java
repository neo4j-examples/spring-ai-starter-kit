package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

public record Company(@Id Integer cik,
                      String cusip6,
                      String name,
                      String all_names,
                      String cusip,
                      @Relationship(value = "OWNS_STOCK_IN", direction = Relationship.Direction.INCOMING) List<Manager> managers) {
}
