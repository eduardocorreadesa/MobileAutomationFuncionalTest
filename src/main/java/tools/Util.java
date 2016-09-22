/**
 * @author Eduardo C. de S�
 *
 * 13/08/2015
 */
package tools;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.saucelabs.saucerest.SauceREST;

/**
 * @author eduardo.sa
 *
 */
public class Util {

	public static final String LOGINSAUCELABS = " ";
	public static final String PASSWORDSAUCELABS = " ";
	public static final String USERSAUCELABS = "eduardodesaa";
	public static final String KEYSAUCELABS = " ";
	public static final String LOGINAPPMINHACONTA = " ";
	public static final String PASSWORDAPPMINHACONTA = " ";
	public static String sessionId = " ";
	public static SauceREST client;


/**Curl Commands
 *
 * Upload App - curl -u eduardodesaa: -X POST -H "Content-Type: application/octet-stream" https://saucelabs.com/rest/v1/storage/eduardodesaa/minhasEconomias.apk?overwrite=true --data-binary @C:/app/minhasEconomias/minhasEconomias.apk
 * Set Status Test - curl -X PUT https://eduardodesaa: @saucelabs.com/rest/v1/eduardodesaa/jobs/ff74a6069b9b406c8f0a4a68da25249c -H "Content-Type: application/json" -d "{\"passed\": false}"
 * Email SauceLabs - eduardodesaa@hotmail.com
 * Username - eduardodesaa
 * Senha SauceLabs -
 */

	public static final void gerarEvidenciaTeste() {
		String nameMethod = Thread.currentThread().getStackTrace()[2].getMethodName();
		String namePath = nameMethod + "-" + System.currentTimeMillis()+ ".png";
		try {
			File screenshot = ((TakesScreenshot) WebdriverAndroid.getInstance()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("test-output/evidencias/" + namePath));
		} catch (Exception e) {
			System.out.println("Exception ao capturar evidencia. \n"+e);
		}
	}
}
