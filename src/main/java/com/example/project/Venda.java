package com.example.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venda {
    private Loja loja;
    private String datahora;
    private String ccf;
    private String coo;

    public Venda(Loja loja, String datahora, String ccf, String coo) {
        this.loja = loja;
        this.datahora = dataAtual();
        this.ccf = ccf;
        this.coo = coo;
    }

    public Loja getLoja() {
        return this.loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public String getDataHora() {
        return this.datahora;
    }

    public void setDataHora(String datahora) {
        this.datahora = datahora;
    }
    public String getCcf() {
        return this.ccf;
    }

    public void setCcf(String ccf) {
        this.ccf = ccf;
    }

    public String getCoo() {
        return this.coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public void validarCamposObrigatorios() {

        if(getCcf() == "") {
            throw new RuntimeException("O campo CCF da venda é obrigatório");
        }

        if(getCoo() == "") {
            throw new RuntimeException("O campo COO da venda é obrigatório");
        }
    }

    public static String dataAtual(){
        
        LocalDateTime agora = LocalDateTime.now();

        DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        String dataFormatada = formatterData.format(agora);

        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = formatterHora.format(agora);

        return dataFormatada + " " + horaFormatada + "V";
    }

    public String dadosVenda() {

        validarCamposObrigatorios();

        String _ccf = " CCF: " + getCcf();
        String _coo = " COO: " + getCoo();
        return dataAtual() + _ccf + _coo;

    }

}