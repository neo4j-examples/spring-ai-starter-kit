package com.neo4j.springaistarterkit;

import org.springframework.data.neo4j.core.schema.Id;

public record Manager(@Id Integer cik,
                      String name,
                      String address) {
}
