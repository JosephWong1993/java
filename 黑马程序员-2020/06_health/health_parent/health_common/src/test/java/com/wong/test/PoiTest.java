package com.wong.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class PoiTest {
    /**
     * 从Excel文件读取数据
     */
    @Test
    public void test1() throws IOException {
        //构造一个Excel对象
        XSSFWorkbook excel = new XSSFWorkbook("D:\\temp\\poi.xlsx");
        //获得第一个工作表对象
        XSSFSheet sheet = excel.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum(); //获得最后一个行的行号，从0开始
        for (int i = 0; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum(); //获取最后一个单元格编号
            for (int j = 0; j < lastCellNum; j++) {
                XSSFCell cell = row.getCell(j);
                System.out.println(cell.getStringCellValue());
            }
        }
        excel.close();
    }
}
