package com.cdt.elasticsearch.test;

/**
 * @Description
 * @Author chendongtian
 * @Date 2022/12/22 10:18
 * @Version 1.0
 */

import co.elastic.clients.elasticsearch.indices.*;
import com.cdt.elasticsearch.pojo.EsDocument;
import com.cdt.elasticsearch.pojo.EsPage;
import com.cdt.elasticsearch.utils.EsUtil;
import com.cdt.elasticsearch.vo.EsDocVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resources;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {
    @Autowired
    EsUtil esUtil;

    // 目标索引
    String indexName = "tuwer_index001";


    // --------------------------- 工具类方法 ---------------------------------
    // -----索引-----
    @Test
    public void testCreateIndexByUtil() {
        //System.out.println(EsClientUtil.createIndex(indexName));
        //EsClientUtil.createIndex("INDEX_abc");
        esUtil.index.create(indexName);
    }

    @Test
    public void testQueryIndexByUtil() {
        Map<String, IndexState> result = esUtil.index.query(indexName);
        //Map<String, IndexState> result = EsClientUtil.indexQueryAsync("tuwer_index");
/*        for (Map.Entry<String, IndexState> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/
        for (String s : result.keySet()) {
            System.out.println(result.get(s).dataStream());
        }
    }

    @Test
    public void testGetAllIndex(){
        Set<String> idxs = esUtil.index.all();
        for (String idx : idxs) {
            System.out.println(idx);
        }
    }

    @Test
    public void testDeleteIndexByUtil() {
        boolean b = esUtil.index.del("tuwer_index001");
        System.out.println(b);
    }

    // -----文档-----
    @Test
    public void testCreateDocument() {
        EsDocument esDocument = new EsDocument("123",0,"标题","测试123","admin","abc123");
        String res = esUtil.doc.createOrUpdate(indexName, "ABC", esDocument);
        System.out.println(res);
    }

    @Test
    public void testBatchCreateDocument() {
        Map<String, EsDocument> userMap = new HashMap<>();
        //for (int i = 0; i < 3; i++) {
        EsDocument doc1 = new EsDocument("11",0,"中","没123世213界人","","abc123");
        userMap.put(doc1.getId(), doc1);
        EsDocument doc2 = new EsDocument("12",0,"世","河231人测123南测试中","","abc123");
        userMap.put(doc2.getId(), doc2);
        EsDocument doc3 = new EsDocument("13",0,"原中","天大1231去131南","","abc123");
        userMap.put(doc3.getId(), doc3);

        EsDocument doc4 = new EsDocument("21",1,"中","没123世213界人","admin","abc123");
        userMap.put(doc4.getId(), doc4);
        EsDocument doc5 = new EsDocument("22",1,"世","河231人测123南测试中","34admin","abc123");
        userMap.put(doc5.getId(), doc5);
        EsDocument doc6 = new EsDocument("23",1,"原中","天大1231去131南","admin67","abc123");
        userMap.put(doc6.getId(), doc6);
        //}

        int i  = esUtil.doc.createOrUpdateBth(indexName, userMap);
        /*for (BulkResponseItem item : bulkResponse.items()) {
            System.out.println(item.id());
        }*/
        System.out.println(i);
    }

    @Test
    public void testDocIsExist(){
        //System.out.println(EsClientUtil.docIsExist(indexName, "8001"));
        System.out.println(esUtil.doc.isExist("tuwer_IndeX001", "8001"));
    }

    @Test
    public void testDeleteDocument() {
        List<String> documentIds = new ArrayList<>();
        documentIds.add("101");
        documentIds.add("102");
        documentIds.add("100");
        documentIds.add("201");
        documentIds.add("202");
        documentIds.add("203");
        documentIds.add("ABC");
        documentIds.add("_search");

        int i = esUtil.doc.del(indexName, documentIds);
        System.out.println(i);
    }

    @Test
    public void testDocDelAll(){
        esUtil.doc.delAll(indexName);
    }

    @Test
    public void testQueryDocument() {
        List<EsDocVo> docs = esUtil.doc.query(indexName, "中");
        //List<Hit<User>> users = EsClientUtil.queryDocumentByField(indexName, "name", "test_6001");

        for (EsDocVo doc : docs) {
            System.out.println(doc);
        }
    }

    @Test
    public void testDocPage(){
        //EsPage p = esUtil.doc.page(indexName, "中", 1, 5);
        EsPage p = esUtil.doc.page(indexName, "世", 1, 20);
        //esUtil.doc.page(indexName, "中", 1, 20);
        //EsPage p = esUtil.doc.page(indexName, "世", "admin67",1, 20);
        //EsPage p = esUtil.doc.page(indexName, "中");
        //System.out.println(p);
        System.out.println("--------------");
        for (EsDocVo record : p.getRecords()) {
            System.out.println(record);
        }
    }

    @Test
    public void testDocLastTime(){
        //EsPage p = esUtil.doc.page(indexName, "中", 1, 5);
        //EsPage p = esUtil.doc.page(indexName, "中", "admin",1, 5);
//        EsPage p = esUtil.doc.page(indexName, "中");
//        Long lastTime = esUtil.doc.lastTime(indexName, 1);
//        System.out.println(lastTime);
    }
}



