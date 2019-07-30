package io.github.mengwang0211;

/**
 * The <code>ExcelLog</code>
 *
 * @author wmlucas.cn @gmail.com
 * @version 1.0
 */
public class ExcelLog {
    private Integer rowNum;
    private Object object;
    private String log;

    /**
     * Gets row num *
     *
     * @return the rowNum
     */
    public Integer getRowNum() {
        return rowNum;
    }

    /**
     * Sets row num *
     *
     * @param rowNum the rowNum to set
     */
    public void setRowNum(Integer rowNum) {
        this.rowNum = rowNum;
    }

    /**
     * Gets object *
     *
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Sets object *
     *
     * @param object the object to set
     */
    public void setObject(Object object) {
        this.object = object;
    }

    /**
     * Gets log *
     *
     * @return the log
     */
    public String getLog() {
        return log;
    }

    /**
     * Excel log
     *
     * @param object object
     * @param log    log
     */
    public ExcelLog(Object object, String log) {
        super();
        this.object = object;
        this.log = log;
    }

    /**
     * Excel log
     *
     * @param object object
     * @param log    log
     * @param rowNum row num
     */
    public ExcelLog(Object object, String log, Integer rowNum) {
        super();
        this.rowNum = rowNum;
        this.object = object;
        this.log = log;
    }

    /**
     * Sets log *
     *
     * @param log the log to set
     */
    public void setLog(String log) {
        this.log = log;
    }

}
