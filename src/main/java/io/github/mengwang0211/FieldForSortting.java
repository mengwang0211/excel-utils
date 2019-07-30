package io.github.mengwang0211;

import java.lang.reflect.Field;

/**
 * The <code>FieldForSortting</code>
 *
 * @author wmlucas.cn @gmail.com
 * @version 1.0
 */
public class FieldForSortting {
    private Field field;
    private int index;

    /**
     * Field for sortting
     *
     * @param field field
     */
    public FieldForSortting(Field field) {
        super();
        this.field = field;
    }

    /**
     * Field for sortting
     *
     * @param field field
     * @param index index
     */
    public FieldForSortting(Field field, int index) {
        super();
        this.field = field;
        this.index = index;
    }

    /**
     * Gets field *
     *
     * @return the field
     */
    public Field getField() {
        return field;
    }

    /**
     * Sets field *
     *
     * @param field the field to set
     */
    public void setField(Field field) {
        this.field = field;
    }

    /**
     * Gets index *
     *
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Sets index *
     *
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
