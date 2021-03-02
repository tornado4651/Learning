package elasticsearch.utils;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;

public class ESClient {

        public static RestHighLevelClient getClient(){

            // 创建HttpHost
            HttpHost httpHost  = new HttpHost("127.0.0.1",9200);

            // 创建RestHigh
            RestClientBuilder restClientBuilder = RestClient.builder(httpHost);

            // 创建RestHighLeveleClient，并返回
            return new RestHighLevelClient(restClientBuilder);
        }
}
