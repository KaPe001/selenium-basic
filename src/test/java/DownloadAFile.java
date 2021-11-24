import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class DownloadAFile {

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        String downloadPath = "C:\\Users\\kpetkowska\\IdeaProjects\\selenium-basic\\src\\test\\resources";

        Map<String, Object> prefs = new HashMap<String, Object>();
        //prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://seleniumui.moderntester.pl/form.php");

        driver.findElement(By.cssSelector(".needs-validation div:nth-child(12) a")).click();

        try{
            Thread.sleep(2500);
        }catch(Exception e){
            e.printStackTrace();
        }

        // w/o the wait block, the file is saving with the wrong coding
        driver.quit();

        //read how many files is in directory
        File myNewDirectory = new File(downloadPath);
        int fileCount = myNewDirectory.list().length;
        System.out.println("File count: " + fileCount);

        //print all files
        Files.list(new File(downloadPath).toPath())
                .limit(10)
                .forEach(path -> {
                    System.out.println(path);
                });
    }
}
