import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DownloadAFile {
    static Logger logger = LoggerFactory.getLogger(DownloadAFile.class);

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        String downloadPath = "C:\\Users\\kpetkowska\\IdeaProjects\\selenium-basic\\src\\test\\resources";

        Map<String, Object> prefs = new HashMap<>();
        //prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadPath);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://seleniumui.moderntester.pl/form.php");

        File myNewDirectory = new File(downloadPath);
        int fileCountBeforeDownload = Objects.requireNonNull(myNewDirectory.list()).length;
        System.out.println("File count before downloading a new file: " + fileCountBeforeDownload);

        driver.findElement(By.cssSelector(".needs-validation div:nth-child(12) a")).click();
        logger.info("Document downloaded correctly");

        try {
            Thread.sleep(2500);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // w/o the wait block, the file is saved with the wrong coding
        driver.quit();

        //read how many files is in directory
        int fileCountAfterTheDownload = Objects.requireNonNull(myNewDirectory.list()).length;
        System.out.println("File count after downloading a new file: " + fileCountAfterTheDownload);

        //print all files
        Files.list(new File(downloadPath).toPath())
                .limit(10)
                .forEach(System.out::println);
    }
}
