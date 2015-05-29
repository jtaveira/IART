package fileIO;

import java.io.File;

/**
 *
 * @author RicardoJorge
 */
public class FileIO {
    
    private String trainingFilePath;
    private String testingFilePath;    

    public FileIO() {}
    
    public Boolean uploadTrainingFile(String trainingFilePath) {
        File f = new File(trainingFilePath);
        if (f.exists() && !f.isDirectory()) {
            this.trainingFilePath = trainingFilePath;
            return true;
        }        
        return false;
    }
    
    public Boolean uploadTestingFile(String testingFilePath) {
        File f = new File(testingFilePath);
        if (f.exists() && !f.isDirectory()) {
            this.testingFilePath = testingFilePath;
            return true;
        }        
        return false;
    }

    public String getTrainingFilePath() {
        return trainingFilePath;
    }

    public void setTrainingFilePath(String trainingFilePath) {
        this.trainingFilePath = trainingFilePath;
    }

    public String getTestingFilePath() {
        return testingFilePath;
    }

    public void setTestingFilePath(String testingFilePath) {
        this.testingFilePath = testingFilePath;
    }
    
    public void trainingFileParser()
    {
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
