package screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class ScreenShotCapture {
	
	WebDriver driver;
	
	public ScreenShotCapture(WebDriver driver) {
		this.driver=driver;
	}
	
	public void captureScreenshot(String filename) throws IOException {
		File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scrFile, new File("screenshots/"+filename));
	}

}
