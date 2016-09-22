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

import pages.Dashboard;
import pages.Home;
import tools.Util;

/**
 * @author eduardo.sa
 *
 */
public class FecharAppTest {

	@Test(groups = { "Teste CRUD" }, dependsOnMethods = { "tests.LoginTest.loginApp" })
	public void fecharApp() throws ClientProtocolException, IOException, InterruptedException {
		Dashboard d = new Dashboard();
		Home h = new Home();
		System.out.println("Teste - Sair do Aplicativo.");	
		
		d.fecharApp();
		Assert.assertEquals(h.loadLoginPage(), false);
		Util.gerarEvidenciaTeste();
	}
}
