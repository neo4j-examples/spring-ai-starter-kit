package com.neo4j.springaistarterkit;

import org.neo4j.driver.Driver;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.ai.openai.OpenAiEmbeddingClient;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.vectorstore.Neo4jVectorStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiStarterKitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiStarterKitApplication.class, args);
	}

	@Bean
	public EmbeddingClient embeddingClient() {
		return new OpenAiEmbeddingClient(new OpenAiApi(System.getenv("SPRING_AI_OPENAI_API_KEY")));
	}

	@Bean
	public Neo4jVectorStore vectorStore(Driver driver, EmbeddingClient embeddingClient) {
		return new Neo4jVectorStore(driver, embeddingClient,
				Neo4jVectorStore.Neo4jVectorStoreConfig.builder()
						.withIndexName("form_10k_chunks")
						.withLabel("Chunk")
						.withEmbeddingProperty("textEmbedding")
						.build());
	}

}
