package util;

import model.Product;
import value.Unit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderSingleton {

    public static final String FILE_PATH = "src/main/resources/products_oop.txt";
    private static FileReaderSingleton instance;

    public static FileReaderSingleton getInstance() {
        if (instance == null) {
            instance = new FileReaderSingleton();
        }
        return instance;
    }

    public Product[] readProductsFromFile(String filePath) {
        int lengthWithHeader = countLinesInFile(filePath);
        int length = lengthWithHeader - 1;
        Product[] products = new Product[length];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean skipFirstLine = true;
            int index = 0;

            while ((line = br.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length != 4) { // error handling ...
                    continue; // Skip lines with incorrect format
                }

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double quantity = Double.parseDouble(parts[2]);
                String unitAbbreviation = parts[3].trim(); // trim() -> remove leading and trailing spaces and make a String of it!
                /*if (unitAbbreviation.equalsIgnoreCase("liter")) {
                    unitAbbreviation = "l";
                }*/
                Unit unit = Unit.getEnumValueFromString(unitAbbreviation); // Unit unit = Unit.fromAbbreviation(parts[3].trim());

                Product product = new Product(id, name, quantity, unit);
                products[index] = product; // Set the product at the current index
                index++; // Increment the index for the next product
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return products;
    }

    private int countLinesInFile(String filePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lineCount++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return lineCount;
    }

    private FileReaderSingleton() {
    }
}
