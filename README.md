# TestFileMapping
This program maps the specified test file with the the production (SUT) file

## Prerequisites
A csv file containing the path of the test file and the directory containing the source files. This file needs to be passed as input.

Example of the structure of this file:

`
C:\Projects\MyProject\src\main,C:\Projects\MyProject\src\test\java\org\example\common\PluginResourceBundleTest.java
C:\Projects\MyProject\src\main,C:\Projects\MyProject\src\test\java\org\example\inspection\ConditionalInspectionTest.java
C:\Projects\MyProject\src\main,C:\Projects\MyProject\src\test\java\org\example\inspection\DuplicateInspectionTest.java
C:\Projects\MyProject\src\main,C:\Projects\MyProject\src\test\java\org\example\inspection\GeneralInspectionTest.java
`

## Usage
Run the jar file:

`C:\Projects\TestFileMapping>java -jar TestFileMapping.jar C:\Work\input.csv`

## Output
The output csv file will be saved in the same directory as the jar. The file will contain the path of the test file and the corresponding production file (if found).
