package utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExcelMethods {

    public static List<List<String>> getDataFromExcel(String path, String sheetName) {
        List<List<String>> returnList = new ArrayList<>();

        FileInputStream fileInputStream;
        Workbook workbook;
        Sheet sheet = null;
        try {
            fileInputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(fileInputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            ;
        }
        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            List<String> innerList = new ArrayList<>();
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                Cell cell = row.getCell(j);
                innerList.add(cell.toString());
            }
            returnList.add(innerList);

        }
        return returnList;
    }

    public static void writeScenarioInfoToExcel(Scenario scenario, LocalDateTime startTime, LocalDateTime endTime, Duration duration) {
        String path = "src/test/java/ApachePOI/resources/scenarioInfo.xlsx";
        try (Workbook workbook = new XSSFWorkbook(new FileInputStream(path));
             FileOutputStream outputStream = new FileOutputStream(path)){

            Sheet sheet = workbook.getSheet("TestResults");
            int rowCount = sheet.getLastRowNum() + 1;
            Row row = sheet.createRow(rowCount);
            row.createCell(0).setCellValue(scenario.getId());
            row.createCell(1).setCellValue(scenario.getName());
            row.createCell(2).setCellValue(scenario.getStatus().toString());

            workbook.write(outputStream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
