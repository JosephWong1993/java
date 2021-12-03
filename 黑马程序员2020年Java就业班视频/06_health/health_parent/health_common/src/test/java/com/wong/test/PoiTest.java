package com.wong.test;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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

    //向Excel文件写入数据，并提供客户端客户端下载
    @Test
    public void test3() throws IOException {
        //在内存中创建一个Excel文件对象
        XSSFWorkbook excel = new XSSFWorkbook();
        //在表格中创建一个工作表对象
        XSSFSheet sheet = excel.createSheet("wong");
        //在工作表中创建行
        XSSFRow title = sheet.createRow(0);
        //在行中创建单元格
        title.createCell(0).setCellValue("编号");
        title.createCell(1).setCellValue("姓名");
        title.createCell(2).setCellValue("地址");

        XSSFRow row1 = sheet.createRow(1);
        row1.createCell(0).setCellValue("u001");
        row1.createCell(1).setCellValue("小明");
        row1.createCell(2).setCellValue("北京");

        XSSFRow row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue("u002");
        row2.createCell(1).setCellValue("小李");
        row2.createCell(2).setCellValue("南京");

        //使用输出流将文件写到磁盘
        OutputStream out = new FileOutputStream("D:\\temp\\wong.xlsx");
        excel.write(out);
        out.flush();
        out.close();
        excel.close();
    }
}
