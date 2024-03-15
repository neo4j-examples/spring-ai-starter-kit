package com.neo4j.springaistarterkit;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.ai.vectorstore.Neo4jVectorStore;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class DocumentController {
    private final OpenAiChatClient client;
    private final Neo4jVectorStore vectorStore;
    private final DocumentRepository repo;

    public DocumentController(OpenAiChatClient client, Neo4jVectorStore vectorStore, DocumentRepository repo) {
        this.client = client;
        this.vectorStore = vectorStore;
        this.repo = repo;
    }

    @GetMapping("/chat")
    String getGeneratedResponse(@RequestParam String question) {
        List<Document> results = vectorStore.similaritySearch(SearchRequest.query(question));

        System.out.println("Id list to graph: " + results.stream()
                .map(Document::getId)
                .collect(Collectors.toList()));

        List<Chunk> docList = repo.getRelatedEntitiesForSimilarChunks(results.stream()
                .map(Document::getId)
                .collect(Collectors.toList()));

        var template = new PromptTemplate("""
                You are a helpful question-answering agent. Your task is to analyze
                and synthesize information from the top result from a similarity search
                and relevant data from a graph database.
                Given the user's query: {question}, provide a meaningful and efficient answer based
                on the insights derived from the following data:
                                
                {graph_result}
                """,
                Map.of("question", question,
                        "graph_result", docList.stream().map(chunk -> chunk.toString()).collect(Collectors.joining("\n"))));
        System.out.println("----- PROMPT -----");
        System.out.println(template.render());

        return client.call(template.create().getContents());
    }
}
