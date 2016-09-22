/**
 * @author Eduardo C. de S�
 *
 * 13/08/2015
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import tools.WebdriverAndroid;
import components.Button;
import components.Input;

/**
 * @author eduardo.sa
 *
 */
public class Home {

	public Home() {
	}

	public boolean loadLoginPage() {
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(WebdriverAndroid.getInstance(),30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.minhaseconomias:id/tv_value")));
			resultado = true;
		} catch (Exception e) {
			resultado = false;
		}
		return resultado;
	}

	public void skipIntroductionPage() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/skip");
	}

	public void touchRegister(String id) {
		Button.oneTouch(WebdriverAndroid.getInstance(), id);
	}
	
	public void touchSend() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/button_enviar");
	}
	
	public void touchHaveAccount() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/button_login");
	}

	public void enterEmail(String email) {
		Input.setText(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/campo_email", email);
	}

	public void repeatEnterEmail(String id, String email) {
		Input.setText(WebdriverAndroid.getInstance(), id, email);
	}

	public void enterPassword(String senha) {
		Input.setText(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/campo_senha", senha);
	}
}
