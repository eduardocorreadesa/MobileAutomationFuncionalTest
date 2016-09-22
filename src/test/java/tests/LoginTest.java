/**
 * @author Eduardo C. de S�
 *
 * 06/08/2015
 */
package tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Home;
import tools.Util;

/**
 * @author eduardo.sa
 *
 */
public class LoginTest {

	@Test(groups = { "Teste CRUD" })
	public void loginApp() throws ClientProtocolException, IOException, InterruptedException{
		Home h = new Home();
		System.out.println("Teste - Login no app.");	

		h.skipIntroductionPage();
		h.touchHaveAccount();
		h.enterEmail(Util.LOGINAPPMINHACONTA);
		h.enterPassword(Util.PASSWORDAPPMINHACONTA);
		h.touchSend();
		Assert.assertEquals(h.loadLoginPage(), true);
		Util.gerarEvidenciaTeste();
	}
}
