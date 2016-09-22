/**
 * @author Eduardo C. de S�
 *
 * 13/08/2015
 */
package pages;

import io.appium.java_client.android.AndroidKeyCode;

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
public class Dashboard {

	public Dashboard() {
	}

	public boolean loadLoginPage(String id) {
		boolean resultado;
		try {
			WebDriverWait wait = new WebDriverWait(WebdriverAndroid.getInstance(),30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
			resultado = true;
		} catch (Exception e) {
			resultado = false;
		}
		return resultado;
	}
	
	public void fecharApp() {
		try {
			WebdriverAndroid.getInstance().sendKeyEvent(AndroidKeyCode.HOME);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchProximoAntessala() {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.Button[@text='Próximo']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchEntendiAntessala() {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.Button[@text='Entendi']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchCadastrar() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/fab_button");
	}

	public String getSaldo() {
		String saldo = "";
		try {
			saldo = WebdriverAndroid.getInstance().findElement(By.id("com.minhaseconomias:id/tv_value")).getText();
		} catch (Exception e) {
			System.out.println(e);
		}
		return saldo;
	}

	public void touchReceita() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/tipoReceita");
	}

	public void touchResultadoPeriodo() {	
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/resultado_vermais");
	}

	public void touchDespesa() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/tipoDespesa");
	}

	public void insertDescricaoTransacao(String descricaoTransacao) {
		try {
			Input.setText(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/trsDescricao", descricaoTransacao);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchNumberCalculadora(String number) {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.TextView[@text='"+number+"']")).click();
		} catch (Exception e) {
			System.out.println(e);;
		}
	}

	public void touchOkCalculadora() {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.TextView[@text='OK']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchCategoria(String categoria) {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.LinearLayout[@index='5']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchSubCategoria(String subCategoria) {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchConta(String conta) {
		try {
			WebdriverAndroid.getInstance().findElement(By.xpath("//android.widget.LinearLayout[@index='0']")).click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void touchSalvarVoltar() {
		Button.oneTouch(WebdriverAndroid.getInstance(), "com.minhaseconomias:id/menu_trs_salvar_sair");
	}

	public String verificaSaldo(String saldoAnt, String saldoPos) {
		String saldoCalc = "";
		saldoAnt = saldoAnt.replaceAll("[^0-9]", "");
		saldoPos = saldoPos.replaceAll("[^0-9]", "");
		int saldoAntInt = Integer.valueOf(saldoAnt);
		int saldoPosInt = Integer.valueOf(saldoPos);
		saldoCalc = String.valueOf(saldoPosInt - saldoAntInt);
		return saldoCalc;
	}

	public String saldoDespesa(String saldoAnt, int despesa) {
		String saldoCalc = "";
		saldoAnt = saldoAnt.replaceAll("[^0-9]", "");
		int saldoAntInt = Integer.valueOf(saldoAnt);
		saldoCalc = String.valueOf(saldoAntInt - despesa);
		return saldoCalc;
	}
}
