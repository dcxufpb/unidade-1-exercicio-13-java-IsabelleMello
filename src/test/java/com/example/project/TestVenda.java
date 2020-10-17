package com.example.project;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestVenda {
    
    private void verificarCampoObrigatorio(String mensagemEsperada, Venda venda) {
		try {
			venda.dadosVenda();
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
	} 

	private String NOME_LOJA = "Loja 1";
	private String LOGRADOURO = "Log 1";
	private int NUMERO = 10;
	private String COMPLEMENTO = "C1";
	private String BAIRRO = "Bai 1";
	private String MUNICIPIO = "Mun 1";
	private String ESTADO = "E1";
	private String CEP = "11111-111";
	private String TELEFONE = "(11) 1111-1111";
	private String OBSERVACAO = "Obs 1";
	private String CNPJ = "11.111.111/1111-11";
    private String INSCRICAO_ESTADUAL = "123456789";
    private String CCF_VENDA = "021784";
	private String COO_VENDA = "035804";
	public String  DATA_ATUAL = "11/11/1111 11:11V";
 
                                        
private Endereco paramEndereco = new Endereco(LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO, MUNICIPIO, ESTADO, CEP);

private Loja paramLoja = new Loja(NOME_LOJA, paramEndereco, TELEFONE, OBSERVACAO, CNPJ ,INSCRICAO_ESTADUAL);


@Test
	public void validarLoja() {
		Venda validarLoja = new Venda(null, DATA_ATUAL, CCF_VENDA, COO_VENDA);
		verificarCampoObrigatorio("O campo loja da venda é obrigatório", validarLoja);               
	}
	
@Test
	public void validarDataHora() {
		Venda validarDataHora = new Venda(paramLoja, "", CCF_VENDA, COO_VENDA);
		verificarCampoObrigatorio("O campo datahora da venda é obrigatório", validarDataHora);               
    }

@Test
	public void validarCcf() {
		Venda ccfVazio = new Venda(paramLoja, DATA_ATUAL ,"", COO_VENDA);
		verificarCampoObrigatorio("O campo CCF da venda é obrigatório", ccfVazio);               
    }

@Test
	public void validarCoo() {
		Venda cooVazio = new Venda(paramLoja, DATA_ATUAL, CCF_VENDA, "");
		verificarCampoObrigatorio("O campo COO da venda é obrigatório", cooVazio);               
    }
}