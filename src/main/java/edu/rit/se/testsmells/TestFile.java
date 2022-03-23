package edu.rit.se.testsmells;

public class TestFile {
    String[] data;
    private String testFilePath, productionFilePath, srcDirectory;

    public TestFile(String srcDirectory, String testFilePath) {
        this.testFilePath = testFilePath;
        this.srcDirectory = srcDirectory;
        data = this.testFilePath.split("\\\\");
    }

    public String getFileName() {
        return data[data.length - 1];
    }

    public String getTestFilePath() {
        return testFilePath;
    }

    public String getProductionFilePath() {
        return productionFilePath;
    }

    public void setProductionFilePath(String productionFilePath) {
        this.productionFilePath = productionFilePath;
    }

    public String getProjectRootFolder() {
        return srcDirectory;
    }

}
