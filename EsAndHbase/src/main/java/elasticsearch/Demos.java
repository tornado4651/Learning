package elasticsearch;

import com.tornado4651.elasticsearch.utils.ESClient;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.json.JsonXContent;
import org.junit.Test;

import java.io.IOException;

/**
 * 获取RestHighLevel的Client对象方法测试
 */
public class Demos {

    /**
     * 尝试获取客户端
     */
    @Test
    public void testClient() {
        RestHighLevelClient client = ESClient.getClient();
        System.out.println("It worked!!!Got the client: " + client.toString());
    }


    /**
     * 创建索引(mapping、setting)
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException {
        String index = "person";
        String type = "man";
        RestHighLevelClient client = ESClient.getClient();


        // 1.准备索引的setting
        Settings.Builder settingsBuilder = Settings.builder()
                .put("number_of_shards", 3)     // 设置分片数：3
                .put("number_of_replicas", 1);// 设置备份数：1

        /*
            2.准备关于索引的mappings

         */
        XContentBuilder mappings = JsonXContent.contentBuilder()    // 相当于创建出一个mappings:{}
                .startObject()  // 相当于在mappings中创建第一个fild对象
                    .startObject("properties")
                        .startObject("name")
                            .field("type","text")
                        .endObject()
                        .startObject("age")
                            .field("type","integer")
                        .endObject()
                        .startObject("name")
                            .field("type","date")
                            .field("format","yyyy-MM-dd || MMdd")
                        .endObject()
                    .endObject()
                .endObject();

        // 3.将settings和mapping封装到一个Request对象中
        CreateIndexRequest indexRequest = new CreateIndexRequest(index)
                .settings(settingsBuilder)
                .mapping(type,mappings);

        // 4.使用client发送创建请求和设置
        CreateIndexResponse createIndexResponse = client.indices().create(indexRequest, RequestOptions.DEFAULT);

        // 5.设置成功，输出查看
        System.out.println(createIndexResponse);
    }


    /**
     * 插入文档
     * @throws IOException
     */
    @Test
    public void insertDoc() throws IOException{

    }
}
