package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {


    public static void main(String[] args) throws IOException {

        //XSSWorkbook -> xlsx
        //HSSFWorkbook-> xls

        String path = "employee.xlsx";


        /*to read from excel we need to load it to FileInputStream
        workbook>sheet>row>cell
         */
        FileInputStream fileInputStream = new FileInputStream(path);

        //create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //get the sheet form the workbook we just created, the name of the sheet is sheet
        XSSFSheet sheet = workbook.getSheet("sheet");

        //go to row1, cell1
        System.out.println(sheet.getRow(1).getCell(0));

        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getLastRowNum());

        //erdogan's role

        System.out.println(sheet.getRow(11).getCell(1));

        for (int i = 0; i <= sheet.getLastRowNum(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase("erdogan")) {

                System.out.println(sheet.getRow(i).getCell(2));

            }


        }
    }
}
