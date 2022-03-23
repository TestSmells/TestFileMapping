package edu.rit.se.testsmells;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static List<TestFile> testFiles;

    public static void main(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            System.out.println("Please provide the file containing the paths to the collection of test files");
            return;
        }

        if (!args[0].isEmpty()) {
            File inputFile = new File(args[0]);
            if (!inputFile.exists() || inputFile.isDirectory()) {
                System.out.println("Please provide a valid file containing the paths to the collection of test files");
                return;
            }
        }


        System.out.println("Started!");

        MappingDetector mappingDetector;
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        String str;

        testFiles = new ArrayList<>();

        System.out.println("Reading input.");
        while ((str = in.readLine()) != null) {
            System.out.println("Detecting: " + str);
            mappingDetector = new MappingDetector();
            testFiles.add(mappingDetector.detectMapping(str));
        }

        System.out.println("Saving results. Total lines:" + testFiles.size());
        ResultsWriter resultsWriter = ResultsWriter.createResultsWriter();
        List<String> columnNames = new ArrayList<>();
        List<String> columnValues = null;
        columnNames.add(0, "TestFilePath");
        columnNames.add(1, "ProductionFilePath");
        resultsWriter.writeColumnName(columnNames);

        for (int i = 0; i < testFiles.size(); i++) {
            columnValues = new ArrayList<>();
            columnValues.add(0, testFiles.get(i).getTestFilePath());
            columnValues.add(1, testFiles.get(i).getProductionFilePath());
            resultsWriter.writeLine(columnValues);
        }

        System.out.println("Completed!");
    }
}
