package com.davidefalcone;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;

import javax.net.ssl.SSLContext;
import java.io.IOException;

public class ElasticSearchClient implements AutoCloseable {

    private RestHighLevelClient client;

    public ElasticSearchClient() {
        try {
            // Create an SSL context that trusts all certificates (not recommended for production)
            SSLContext sslContext = SSLContexts.custom()
                    .loadTrustMaterial(new TrustAllStrategy())
                    .build();

            BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials("elastic", "8=Adlc9-DCZWq2lltfSU"));

            RestClientBuilder builder = RestClient.builder(new HttpHost("localhost", 9200, "https"))
                    .setHttpClientConfigCallback(httpClientBuilder -> {
                        httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                        httpClientBuilder.setSSLContext(sslContext);
                        return httpClientBuilder;
                    });

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

