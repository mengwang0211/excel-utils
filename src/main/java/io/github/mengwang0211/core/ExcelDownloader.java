package io.github.mengwang0211.core;

import io.github.mengwang0211.entity.Body;
import io.github.mengwang0211.entity.Head;
import io.github.mengwang0211.entity.Sheet;
import io.github.mengwang0211.rank.Ranker;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Excel downloader
 */
@Slf4j
public class ExcelDownloader {

    /**
     * Execute *
     *
     * @param workPath work path
     * @param sheets   sheets
     */
    public String execute(String workPath, List<Sheet> sheets, List<CellRangeAddress> bodyRegion) {
        List<Sheet> rankedSheets = Ranker.executeSheet(sheets);
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        for (Sheet sheet : rankedSheets) {
            HSSFSheet hssfSheet = workbook.createSheet(sheet.getName());
            // 绘制表头
            List<Head> heads = Ranker.executeHeadRowIndex(sheet.getHeads());
            // 按照行号分组
            Map<Integer, List<Head>> groupBy = heads.stream().collect(Collectors.groupingBy(Head::getFromRowIndex));
            int rowNumer = 0;
            for (Integer key : groupBy.keySet()) {
                List<Head> rowHead = groupBy.get(key);
                List<Head> rankedRowHead = Ranker.executeHeadFromColIndex(rowHead);
                HSSFRow __row = hssfSheet.createRow(key);
                int maxRow = 0;
                for (Head head : rankedRowHead) {
                    HSSFCell cell = __row.createCell(head.getFromColIndex());
                    cell.setCellStyle(style);
                    cell.setCellValue(head.getName());
                    // 合并区域
                    if (head.getFromRowIndex() != head.getEndRowIndex() || head.getFromColIndex() != head.getEndColIndex()) {
                        CellRangeAddress region = new CellRangeAddress(head.getFromRowIndex(), head.getEndRowIndex(), head.getFromColIndex(), head.getEndColIndex());
                        hssfSheet.addMergedRegion(region);
                    }
                    if ((head.getEndRowIndex() - head.getFromRowIndex()) > maxRow) {
                        maxRow = head.getEndRowIndex() - head.getFromRowIndex();
                    }
                }
                rowNumer += maxRow + 1;
            }

            // 绘制表内容
            Body body = sheet.getBody();
            if (null != body) {
                List<List<String>> all_body_data = body.getData();
                for (int i = 0; i < all_body_data.size(); i++) {
                    List<String> row_data = all_body_data.get(i);
                    HSSFRow __row = hssfSheet.createRow(rowNumer + i);
                    for (int j = 0; j < row_data.size(); j++) {
                        HSSFCell cell_00 = __row.createCell(j);
                        cell_00.setCellStyle(style);
                        cell_00.setCellValue(row_data.get(j));
                    }
                }
            }

            if (null != bodyRegion && bodyRegion.size() > 0) {
                // 合并body
                bodyRegion.stream().forEach(region -> {
                    hssfSheet.addMergedRegion(region);
                });
            }

            File file = new File(workPath);
            FileOutputStream fout = null;
            try {
                fout = new FileOutputStream(file);
                workbook.write(fout);
                fout.close();
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return workPath;
    }
}
