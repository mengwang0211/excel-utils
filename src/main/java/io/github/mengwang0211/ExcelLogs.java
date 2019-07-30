package io.github.mengwang0211;

import java.util.ArrayList;
import java.util.List;

/**
 * The <code>ExcelLogs</code>
 *
 * @author wmlucas.cn @gmail.com
 * @version 1.0
 */
public class ExcelLogs {
    private Boolean hasError;
    private List<ExcelLog> logList;

    /**
     * Excel logs
     */
    public ExcelLogs() {
        super();
        hasError = false;
    }

    /**
     * Gets has error *
     *
     * @return the hasError
     */
    public Boolean getHasError() {
        return hasError;
    }

    /**
     * Sets has error *
     *
     * @param hasError the hasError to set
     */
    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    /**
     * Gets log list *
     *
     * @return the logList
     */
    public List<ExcelLog> getLogList() {
        return logList;
    }

    /**
     * Gets error log list *
     *
     * @return the error log list
     */
    public List<ExcelLog> getErrorLogList() {
        List<ExcelLog> errList = new ArrayList<ExcelLog>();
        for (ExcelLog log : this.logList) {
            if (log != null && ExcelUtil.isNotBlank(log.getLog())) {
                errList.add(log);
            }
        }
        return errList;
    }

    /**
     * Sets log list *
     *
     * @param logList the logList to set
     */
    public void setLogList(List<ExcelLog> logList) {
        this.logList = logList;
    }

}
