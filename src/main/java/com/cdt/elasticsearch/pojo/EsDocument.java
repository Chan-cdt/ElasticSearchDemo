package com.cdt.elasticsearch.pojo;

/**
 * @Description
 * @Author chendongtian
 * @Date 2022/12/22 10:13
 * @Version 1.0
 */
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * <p>ES文档实体类</p>
 * ----------------------
 * 一定要有无参构造器；否则反序列化会失败
 * ----------------------
 *
 * @author 土味儿
 * Date 2022/8/9
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class EsDocument {
    /**
     * 文档id
     */
    private String id;
    /**
     * 文档类型
     * 公共 0、私有 1...
     */
    private Integer type;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档内容
     */
    private String content;
    /**
     * 文档属主
     * 公开文档没有属主
     */
    private String owner;
    /**
     * 文档url
     */
    private String url;
    /**
     * 时间（采集/更新）
     */
    //@JsonDeserialize(using = LocalDateTimeDeserializer.class) // 反序列化
    //@JsonSerialize(using = LocalDateTimeSerializer.class) // 序列化
    //private LocalDateTime time;
    private Long time;

    public EsDocument(String id, Integer type, String title, String content, String owner, String url) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.url = url;
        //this.time = LocalDateTime.now();
        //this.time = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
        // 当前时刻
        this.time = Instant.now().getEpochSecond();
    }
}

