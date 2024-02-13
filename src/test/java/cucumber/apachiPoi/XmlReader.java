package cucumber.apachiPoi;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class XmlReader {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("src/test/java/cucumber/apachiPoi/temp.xlsx"); // connection
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheet("Persons");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(1);

        System.out.println(sheet.getRow(1).getCell(1));
        System.out.println(row.getCell(0));
        System.out.println(sheet.getFirstRowNum());
        System.out.println(sheet.getLastRowNum());
        System.out.println(sheet.getPhysicalNumberOfRows());
        System.out.println(sheet.getRow(2).getPhysicalNumberOfCells());
        System.out.println(sheet.getRow(2).getLastCellNum());





    }
}
