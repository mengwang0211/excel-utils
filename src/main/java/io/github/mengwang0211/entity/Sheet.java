package io.github.mengwang0211.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * sheet
 */
@Data
public class Sheet {

    /**
    *  排序
    */
    private int order;

    /**
    *  名称
    */
    private String name;

    /**
     * 表头
     */
    List<Head> heads = new ArrayList<Head>();

    private Body body;
}
