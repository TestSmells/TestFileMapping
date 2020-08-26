package edu.rit.se.testsmells;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.regex.Pattern;

public class TestFile {
    private String filePath, productionFilePath;
    private String[] data;

    public TestFile(String filePath) {
        this.filePath = filePath;
        data = splitFilepath(filePath);
    }

    public String getFileName() {
        return data[data.length - 1];
    }

    public String getUnixFilePath() {
        return filePath;
    }

    public String getProductionFilePath() {
        return productionFilePath;
    }

    public void setProductionFilePath(String productionFilePath) {
        this.productionFilePath = productionFilePath;
    }

    public String getProjectRootFolder() {
        return get5LevelsPath(data).toString();
    }

    public String getAppName() {
        return data[3];
    }

    public String getTagName() {
        return data[4];
    }

    public String getRelativeTestFilePath() {
        return getUnixFilePath(filePath);
    }

    public String getRelativeProductionFilePath() {
        if (!StringUtils.isEmpty(productionFilePath)) {
            return getUnixFilePath(productionFilePath);
        }
        return "";
    }

    private String getUnixFilePath(String filePath) {
        String[] splitString = splitFilepath(filePath);
        return filePath.substring(get5LevelsPath(splitString).toString().length()).replace(File.separator, "/");
    }

    private StringBuilder get5LevelsPath(String[] splitString) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            stringBuilder.append(splitString[i]).append(File.separator);
        }
        return stringBuilder;
    }

    public String[] splitFilepath(String filePath) {
        return filePath.split(Pattern.quote(File.separator));
    }
}
