## Configuring JAVAFX

### Pre-requisite
Ensure that your JAVA JDK version is 11 or higher.

### Steps
1. Download JAVAFX-20 SDK from https://download2.gluonhq.com/openjfx/20/openjfx-20_windows-x64_bin-sdk.zip.

2. Right-click on your project in the Package Explorer and select "Build Path" > "Configure Build Path".

3. Add JAVAFX jars under the classpath.

4. Click the "Apply and Close" button to close the "Build Path" dialog.

5. Right-click on your project in the Package Explorer and select "Run As" > "Run Configurations".

6. In the "VM arguments" field, add the following lines, replacing the path with the location where you have the JavaFX modules stored:

```--module-path <path_where_jars_are_stored>```

```--add-modules javafx.controls,javafx.fxml```

7. Click the "Apply" button to save the changes, then click the "Run" button to run your project.
