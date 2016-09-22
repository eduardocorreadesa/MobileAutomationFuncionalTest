/**
 * @author Eduardo C. de S�
 *
 * 13/08/2015
 */
package tools;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * @author eduardo.sa
 *
 */
public class WebdriverAndroid {

	@SuppressWarnings("rawtypes")
	private static AndroidDriver driver;


	@SuppressWarnings("rawtypes")
	public static void configureDevice(String platform, String device, String name) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		caps.setCapability("name", name);
		caps.setCapability("app","sauce-storage:minhasEconomias.apk");
		caps.setCapability("app-package","com.minhaseconomias");
		caps.setCapability("app-activity","com.minhaseconomias.controller.activities.MeconActivity");
		driver = new AndroidDriver(new URL("http://"+Util.USERSAUCELABS+":"+Util.KEYSAUCELABS+"@ondemand.saucelabs.com:80/wd/hub"), caps);

	}

	@SuppressWarnings("rawtypes")
	public static AndroidDriver getInstance() {
		if (driver == null) {
			System.out.println("---> Driver == null");
		}
		return driver;
	}


	public static void quitInstance() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
