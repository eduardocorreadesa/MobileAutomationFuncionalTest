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
public class CadastrarDespesaTest {

	@Test(groups = { "Teste CRUD" }, dependsOnMethods = { "tests.LoginTest.loginApp" })
	public void cadastrarDespesa() throws ClientProtocolException, IOException, InterruptedException {
		Dashboard d = new Dashboard();
		Home h = new Home();
		System.out.println("Teste - Cadastrar Despesa.");	
		
		String saldoAnt = d.getSaldo();
		d.touchCadastrar();
		d.touchDespesa();
		d.touchNumberCalculadora("1");
		d.touchNumberCalculadora("0");
		d.touchNumberCalculadora("0");
		d.touchNumberCalculadora("0");
		d.touchOkCalculadora();
		d.touchCategoria("Casa");
		d.touchSubCategoria("Internet");
		d.touchConta("Carteira");
		d.insertDescricaoTransacao("Despesa "+System.currentTimeMillis());
		d.touchSalvarVoltar();
		String saldoPos = d.getSaldo();
		Assert.assertEquals("-1000", d.verificaSaldo(saldoAnt, saldoPos));
		Assert.assertEquals(h.loadLoginPage(), true);
		Util.gerarEvidenciaTeste();
	}
}
