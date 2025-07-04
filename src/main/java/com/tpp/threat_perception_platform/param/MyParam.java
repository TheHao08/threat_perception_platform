package com.tpp.threat_perception_platform.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 通用参数对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyParam {
    /**
     * 页码
     */
    private Integer page=1;
    /**
     * 限制
     */
    private Integer limit=5;
    /**
     * 开始时间
     */
    private String start;
    /**
     * 结束时间
     */
    private String end;
    /**
     * 搜索关键字
     */
    private String keywords;
    /**
     * 数据ID
     */
    private Integer id;
    /**
     * 角色ID
     */
    private Integer roleId;
    // 在 MyParam.java 中添加
    private String macAddress;



}
