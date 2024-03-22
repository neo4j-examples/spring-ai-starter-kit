# Spring AI Neo4j Starter Kit

This kit provides a Spring backend service connected to [OpenAI](https://platform.openai.com/docs/overview) and [Neo4j](https://neo4j.com/developer/) for powering GenAI projects. The Neo4j interface leverages [Vector Indexes](https://docs.spring.io/spring-ai/reference/api/vectordbs/neo4j.html) alongside a retrieval Cypher query to provide more accurate results.

[//]: # (![alt text]&#40;https://res.cloudinary.com/dk0tizgdn/image/upload/v1711042573/langchain_starter_kit_sample_jgvnfb.gif "Testing Neo4j Spring AI Starter Kit"&#41;)


## Requirements
- [Maven](https://maven.apache.org/) or [https://gradle.org/](Gradle) for dependency management
- [Spring AI](https://spring.io/projects/spring-ai)
- An [OpenAI API Key](https://openai.com/blog/openai-api)
- A running [local](https://neo4j.com/download/) or [cloud](https://neo4j.com/cloud/platform/aura-graph-database/) Neo4j database


## Configure
1. Update the `application.properties` file with your Neo4j and OpenAI credentials

The `application.properties` file contains read-only access credentials to a publicly hosted Neo4j instance with public EDGAR SEC data.

If you would like to load your own instance with a subset of this information. Copy, paste, and run the [edgar_import.cypher](edgar_import.cypher) in a [Neo4j browser](https://neo4j.com/docs/browser-manual/current/) connected to your instance.


## Usage
```
source ./mvnw spring-boot:run
```

A Rest API should now be running on your local port 8080/api/chat.


## Testing
After the server is running, a curl command can be triggered to test the endpoint:
```
curl "localhost:8080/api/chat?question=How many forms are there?"
```


## Learn More
If you'd like to learn more about using Neo4j with LLMs, we recommend checking out our [GraphAcademy Courses](https://graphacademy.neo4j.com).