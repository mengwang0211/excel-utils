package io.github.mengwang0211.entity;

import lombok.Data;

/**
 * 表头
 */
@Data
public class Head {

    /**
    *  名称
    */
    private String name;

    /**
    *  第几行开始
    */
    private int fromRowIndex;

    /**
     *  第几行结束
     */
    private int endRowIndex;

    /**
    *  第几列开始
    */
    private int fromColIndex;

    /**
    *  第几列结束
    */
    private int endColIndex;
}
