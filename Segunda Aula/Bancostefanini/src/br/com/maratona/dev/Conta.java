package br.com.maratona.dev;

public abstract class Conta {
	
	private Integer conta;
	private Integer agencia;
	private Double  saldo;
	private EnumStatusConta status;
	private Long codigoPix;
	
	
	public void setStatus(EnumStatusConta status) {
		this.status = status;
	}
	public EnumStatusConta getStatus() {
		return status;
	}
	public Integer getConta() {
		return conta;
	}
	public void setConta(Integer conta) {
		this.conta = conta;
	}
	public Integer getAgencia() {
		return agencia;
	}
	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public void sacar(Double valorSaque) {
		System.out.println("PAI");
		this.saldo = this.saldo - valorSaque;
	}
	public void setCodigoPix(Long codigoPix) {
		this.codigoPix = codigoPix;
	}
	public Long getCodigoPix() {
		return codigoPix;
	}
	
}
