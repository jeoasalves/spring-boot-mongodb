package br.com.jeoas.angularboot.helper;

public class PedidoHelperTest {
	private String getCodigoAleatorio() {
		return  ("" + (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L).substring(0, 10);
	}
	
	public static String codigo() {
		return new PedidoHelperTest().getCodigoAleatorio();
	}
}
