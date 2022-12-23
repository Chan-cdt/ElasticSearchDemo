package com.cdt.elasticsearch.vo;

/**
 * @Description
 * @Author chendongtian
 * @Date 2022/12/22 10:14
 * @Version 1.0
 */
import lombok.Data;

/**
 * <p>文档视图层对象</p>
 * @author 土味儿
 * Date 2022/9/17
 * @version 1.0
 */
@Data
public class EsDocVo {
    /**
     * 文档id
     */
    private String id;
    /**
     * 类型
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
     * 文档url
     */
    private String url;
    /**
     * 属主
     */
    private String owner;
    /**
     * 时间
     * 1年前、5个月前、3星期前、5天前、8小时前、47分钟前、刚刚
     */
    private String time;
}

