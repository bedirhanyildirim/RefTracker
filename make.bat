javac src\loginpage\*.java
jar cvfm RefTracker.jar src\RefTracker.MF src\loginpage\*.class
jar uf RefTracker.jar src\loginpage\*.fxml