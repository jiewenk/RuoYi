package com.ruoyi.common.core.page;

import com.ruoyi.common.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * 分页数据
 *
 * @author ruoyi
 */
@Getter
@Setter
public class PageDomain {
    /** 当前记录起始索引 */
    private Integer pageNum;

    /** 每页显示记录数 */
    private Integer pageSize;

    /** 排序列 */
    private String orderByColumn;

    /** 排序的方向desc或者asc */
    private String isAsc = "asc";

    /** 分页参数合理化 */
    private boolean reasonable = true;

    public String getOrderBy() {
        if (StringUtils.isEmpty(orderByColumn)) {
            return "";
        }
        // fixme 优化掉这个字符串工具类
        return StringUtils.toUnderScoreCase(orderByColumn) + " " + isAsc;
    }
}