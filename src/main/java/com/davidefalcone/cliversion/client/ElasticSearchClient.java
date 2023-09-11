package com.davidefalcone.cliversion.client;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;

import java.io.IOException;

public class ElasticSearchClient implements AutoCloseable {

    private RestHighLevelClient client;

    public ElasticSearchClient() {
        try {
            RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "http"));
            client = new RestHighLevelClient(builder);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean indexExists(String indexName) throws IOException {
        return client.indices().exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
    }

    public RestHighLevelClient getClient() {
        return client;
    }

    public void close() throws Exception {
        client.close();
    }
}

