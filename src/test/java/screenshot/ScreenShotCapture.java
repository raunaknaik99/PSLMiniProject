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
		this.driver = driver;
	}

	public String captureScreenshot(String filename) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("screenshots" + filename);
		String errflpath = Dest.getAbsolutePath();
		Files.copy(scrFile, Dest);
		return errflpath;
	}

}
