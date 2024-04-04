# Neo4j Spring AI Starter Kit

This kit provides a Spring backend service connected to [OpenAI](https://platform.openai.com/docs/overview) and [Neo4j](https://neo4j.com/developer/) for powering GenAI projects. The Neo4j interface leverages [Vector Indexes](https://docs.spring.io/spring-ai/reference/api/vectordbs/neo4j.html) alongside a retrieval Cypher query to provide more accurate results.


## Requirements
- [Maven](https://maven.apache.org/) or [https://gradle.org/](Gradle) for dependency management
- [Spring AI](https://spring.io/projects/spring-ai)
- An [OpenAI API Key](https://openai.com/blog/openai-api)
- A running [local](https://neo4j.com/download/) or [cloud](https://neo4j.com/cloud/platform/aura-graph-database/) Neo4j database


## Configuration
1. Update the `application.properties` file with your Neo4j and OpenAI credentials

The `application.properties` file contains read-only access credentials to a publicly hosted Neo4j instance with public EDGAR SEC data.

If you would like to load your own instance with a subset of this information. Copy, paste, and run the [edgar_import.cypher](edgar_import.cypher) in a [Neo4j browser](https://neo4j.com/docs/browser-manual/current/) connected to your instance.

### Database Setup
If you would like to load your own instance with a subset of this information. Add your own OpenAI key to the Cypher code in the [edgar_import.cypher](edgar_import.cypher) file and run it in your instance's [Neo4j browser](https://neo4j.com/docs/browser-manual/current/).

For more information on how this load script works, see [this notebook](https://github.com/neo4j-examples/sec-edgar-notebooks/blob/main/notebooks/kg-construction/1-mvg.ipynb).

## Usage
```
./mvnw spring-boot:run
```

A Rest API should now be running on your local port 8080/api/chat.


## Testing
After the server is running, a curl command can be triggered to test the endpoint:
```
curl "http://localhost:8080/api/chat?question=How%20many%20forms%20are%20there%3F"
```

## Feedback
Please provide feedback and report bugs as [GitHub issues](https://github.com/neo4j-examples/spring-ai-starter-kit/issues)

## Contributing
Want to improve this kit? See the [contributing guide](./CONTRIBUTING.md)

## Learn More
At [Neo4j GraphAcademy](https://graphacademy.neo4j.com), we offer a wide range of courses completely free of charge, including several related to [LLMs with Neo4j](https://graphacademy.neo4j.com/categories/llms/).