package com.example.demo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registro {
    private String Nome;
    private String Descricao;
    private String DataInscricao;
    private String DataUpdate;

    Registro() {}

    Registro(String Nome, String Descricao, String DataInscricao, String DataUpdate){
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.DataInscricao = DataInscricao;
        this.DataUpdate = DataUpdate;
    }

    public Registro CriarRegistro(String Base){
        String[] res = Base.split(",");
        String Nome = res[0].replace("nome", "").replace("\"", "").replace(":", "");
        String Descricao = res[1].replace("descricao", "").replace("\"", "").replace(":", "");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String DataDeAtualizacao = dateFormat.format(new Date());
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.DataInscricao = DataDeAtualizacao;
        this.DataUpdate = DataDeAtualizacao;
        return this;
    }

    public String buscaNome(){
        return this.Nome;
    }
    public String buscaDescricao(){
        return this.Descricao;
    }
    public String buscaDataInscricao(){
        return this.DataInscricao;
    }
    public String buscaDataUpdate(){
        return this.DataUpdate;
    }

    public void defineNome(String Nome){
        this.Nome = Nome;
    }
    public void defineDescricao(String Descricao){
        this.Descricao = Descricao;
    }
    public void defineDataInscricao(String dataInscricao){
        this.DataInscricao = dataInscricao;
    }
    public void defineDataUpdate(String dataUpdate){
        this.DataUpdate = dataUpdate;
    }
    @Override
    public String toString() {
      return "{ Nome:" + this.Nome + ", Descricao:" + this.Descricao + ", DatadeInscrição:" + this.DataInscricao + ", UltimoUpdate:" + this.DataUpdate + '}';
    }
}
