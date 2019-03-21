

import java.io.IOException;
import java.util.ArrayList;

public class ExcelReading {

    public static void main(String[] args) throws IOException {


        ExcelDataReadingInMainFolder newRead = new ExcelDataReadingInMainFolder("C:\\Users\\stepanyuk\\IdeaProjects\\Excel_Read_WebForm_Filling\\src\\test\\TestData\\RegisterTestDataAll.xlsx");

        /**
         значення однієї будь-якої ячейки
         */
        String cellValue;
        cellValue = newRead.getData(0, 5, 1);
        System.out.println("\n Cell Value - " + cellValue);

        /**
         всі значення однієї будь-якої колонки, можна починати з будь-якої ячейки
         */
        int rowCount;
        rowCount = newRead.getRowCount(0);
        ArrayList<String> arr1 = new ArrayList();
        for (int i = 4; i < rowCount; i++) {
            arr1.add(newRead.getData(0, i, 0));
        }
        System.out.println("\n Column Values - ");
        for (int j = 0; j < arr1.size(); j++) {
            System.out.println(arr1.get(j) + " ");
        }


        int columnCount;
        columnCount = newRead.getColumnCount(0,2);
        ArrayList<String> arr2 = new ArrayList();
        for (int i = 0; i <columnCount; i++) {
            arr2.add(newRead.getData(0,2, i));
        }
        System.out.print("\n Row Values - ");
        for (int j = 0; j< arr2.size(); j++) {
            System.out.println(arr2.get(j) + " ");
        }

    }

}
