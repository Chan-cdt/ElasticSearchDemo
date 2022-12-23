package com.cdt.elasticsearch.pojo;

/**
 * @Description
 * @Author chendongtian
 * @Date 2022/12/22 10:15
 * @Version 1.0
 */

import com.cdt.elasticsearch.vo.EsDocVo;
import lombok.Data;

import java.util.List;

/**
 * @author 土味儿
 * Date 2022/9/17
 * @version 1.0
 */
@Data
public class EsPage {
    private String keyword;
    private Long total;
    private Integer current = 1;
    private Integer pageSize = 10;
    private List<EsDocVo> records;
}
