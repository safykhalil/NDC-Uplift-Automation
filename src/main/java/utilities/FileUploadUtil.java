package utilities;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadUtil {
    // Static method to upload a file
    public static void uploadFile(WebDriver driver, By fileInputLocator, String filePath) {
        // Use SHAFT's typeFileLocationForUpload method to upload the file
        new ElementActions(driver)
                .typeFileLocationForUpload(fileInputLocator, filePath);
    }
}
