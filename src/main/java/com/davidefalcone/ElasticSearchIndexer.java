package com.davidefalcone;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class ElasticSearchIndexer {

    private static final String INDEX_NAME = "cities";

    public static void main(String[] args) throws Exception {

        try (ElasticSearchClient esClient = new ElasticSearchClient()) {

            if (!esClient.indexExists(INDEX_NAME)) {
                System.out.println("Non esiste");
                esClient.getClient().indices().create(new CreateIndexRequest(INDEX_NAME), RequestOptions.DEFAULT);
            }else{
                System.out.println("Esiste");
            }


            ObjectMapper objectMapper = new ObjectMapper();

            // Reading the JSON from the classpath
            InputStream is = ElasticSearchIndexer.class.getClassLoader().getResourceAsStream("italian_cities.json");
            List<Map<String, Object>> cities = objectMapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {
            });

            for (Map<String, Object> city : cities) {
                IndexRequest request = new IndexRequest(INDEX_NAME).source(city, XContentType.JSON);
                System.out.println("Inserting request "+request.toString());
                esClient.getClient().index(request, RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
