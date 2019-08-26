package io.github.mengwang0211.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Body
 */
@Data
public class Body {

    /**
     * Data
     */
    List<List<String>> data = new ArrayList<List<String>>();

}
