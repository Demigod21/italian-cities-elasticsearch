package com.davidefalcone.cliversion;

import com.davidefalcone.cliversion.client.ElasticSearchClient;
import com.davidefalcone.cliversion.searcher.ElasticSearchSearcher;

import java.util.List;
import java.util.Map;

public class CliSearcher {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: ElasticSearchSearcher <query>");
            return;
        }

        String query = args[0];
        try (ElasticSearchClient esClient = new ElasticSearchClient()) {
            List<Map<String, Object>> results = ElasticSearchSearcher.saerchEverywhere(esClient, query);
            results.forEach(System.out::println);
        }
    }
}
