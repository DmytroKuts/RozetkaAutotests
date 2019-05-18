package Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javafx.util.Pair;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

public class RecordToExcel {
    public void recordToExcel(List<Pair<String, Integer>> listPairs) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet1 = workbook.createSheet("Sheet 1");
        HSSFSheet sheet2 = workbook.createSheet("Sheet 2");

        // Creat Titles. For the First sheet
        int rownum = 0;
        Cell cell;
        Row row;

        row = sheet1.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Name model");

        cell = row.createCell(1, CellType.NUMERIC);
        cell.setCellValue("Price");

        // Creat Titles. For the Second sheet
        int rownum2 = 0;
        Cell cell2;
        Row row2;
        row2 = sheet2.createRow(rownum);

        cell2 = row2.createCell(0, CellType.STRING);
        cell2.setCellValue("Name model");

        cell2 = row2.createCell(1, CellType.NUMERIC);
        cell2.setCellValue("Price");

        // Data
        for (Pair<String, Integer> element : listPairs) {
            rownum++;
            if (rownum < 10) {    // Amoun of elements on the First sheet
                row = sheet1.createRow(rownum);
            } else {
                rownum2++;
                row = sheet2.createRow(rownum2);
            }
            // A
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(element.getKey());
            // B
            cell = row.createCell(1, CellType.NUMERIC);
            cell.setCellValue(element.getValue());
        }

        File file = new File("files\\SmartphonesNamePrice.xls");
        file.getParentFile().mkdirs();

        try {
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
