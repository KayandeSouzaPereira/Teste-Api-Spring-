package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;



public class MySqlConnection {

    public static String usuario = "";
    public static String senha = "";
    
    
    

    public static String query(String Nome, String Descricao){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String DataDeAtualizacao = dateFormat.format(new Date());
        String Query = "Insert Into kayan.api (NomeCompleto,Descricao,DataDeCriacao,DataDeAtualizacao) values ( '" + Nome + "', '" + Descricao + "', '" + DataDeAtualizacao + "', '" + DataDeAtualizacao + "');";
        return Query;    
    }

    public static HashMap<String, Object> getListacomNome(String Nome){
        HashMap <String, Object> plus = new HashMap<String, Object>();
        HashMap<String, String> regs = new HashMap<String, String>();
        try
        {   
            String myUrl = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
            Connection conn = null;
            conn = createConnection("com.mysql.cj.jdbc.Driver", myUrl, usuario, senha);
            String Query = "SELECT * FROM kayan.api where NomeCompleto = '" + Nome + "'";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query);
            
            while (rs.next())
            {
                String nome = rs.getString("NomeCompleto");
                String Descricao = rs.getString("Descricao");
                String DataInscricao = rs.getString("DataDeCriacao");
                String DataUpdate = rs.getString("DataDeAtualizacao");
                regs.put("Nome", nome);
                regs.put("Descricao", Descricao);
                regs.put("DataInscricao", DataInscricao);
                regs.put("DataUpdate", DataUpdate);
                plus.put("Cadastro", regs);
            }
            
            return plus;
            
        }
        catch (Exception e){
            plus.put("erro", e.getMessage());
                return plus;
        }
    }

    public static int getlinhas(){
        try{
            Integer cont = 0;
            String myUrl = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
            Connection conn = null;
            conn = createConnection("com.mysql.cj.jdbc.Driver", myUrl, usuario, senha);
            String Query = "SELECT count(*) FROM kayan.api";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query);
            while (rs.next())
            {
                cont = Integer.parseInt(rs.getString(1));
            }
            return cont;
        }
        catch (Exception e){
            return 0;
        }
    }


    public static HashMap<String, Object> getLista(){
        HashMap<String, String> regs = new HashMap<>();
        HashMap<String, Object> plus = new HashMap<>();
        try
        {   
            String myUrl = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
            Connection conn = null;
            conn = createConnection("com.mysql.cj.jdbc.Driver", myUrl, usuario, senha);
            String Query = "SELECT * FROM kayan.api";
            java.sql.Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(Query);
            ; 
            while (rs.next())
            {
                
                String nome = rs.getString("NomeCompleto");
                String Descricao = rs.getString("Descricao");
                String DataInscricao = rs.getString("DataDeCriacao");
                String DataUpdate = rs.getString("DataDeAtualizacao");

                
                regs.put("Nome", nome);
                regs.put("Descricao", Descricao);
                regs.put("DataInscricao", DataInscricao);
                regs.put("DataUpdate", DataUpdate);
                plus.put("Cadastro", regs);
            }
            
            return plus;
        }
            catch (Exception e){
                plus.put("erro", e.getMessage());
                return plus;
            }
    }

    

	public static HashMap<String, Object> addInfo(String Nome, String Descricao){
        HashMap <String, Object> plus = new HashMap<String, Object>();
        HashMap<String, String> regs = new HashMap<String, String>();
        try
        {   
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String DataDeAtualizacao = dateFormat.format(new Date());
            String myUrl = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
            Connection conn = null;
            conn = createConnection("com.mysql.cj.jdbc.Driver", myUrl, usuario, senha);
            String Query = "Insert Into kayan.api (NomeCompleto,Descricao,DataDeCriacao,DataDeAtualizacao) values ( '" + Nome + "', '" + Descricao + "', '" + DataDeAtualizacao + "', '" + DataDeAtualizacao + "');";
            PreparedStatement pst = conn.prepareStatement(Query);
            pst.execute();
            regs.put("Message", "Adicionado com Sucesso");
            plus.put("Message", regs);
            return plus;
        }
        catch (Exception e){
            plus.put("erro", e.getMessage());
            return plus;
        }
    }

    public static HashMap<String, Object> DeleteInfo(String Nome){
        HashMap <String, Object> plus = new HashMap<String, Object>();
        HashMap<String, String> regs = new HashMap<String, String>();
        try
        {
            String myUrl = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
            Connection conn = null;
            conn = createConnection("com.mysql.cj.jdbc.Driver", myUrl, usuario, senha);
            String Query = "DELETE FROM kayan.api where NomeCompleto = '" + Nome + "'";
            PreparedStatement pst = conn.prepareStatement(Query);
            pst.execute();
            regs.put("Message", "Registro Deletado");
            plus.put("Message", regs);
            return plus;
        }
        catch (Exception e){
            plus.put("erro", e.getMessage());
            return plus;
        }
    }

    public static HashMap<String, Object> UpdateInfo(String Nome, String Descricao){
        HashMap <String, Object> plus = new HashMap<String, Object>();
        HashMap<String, String> regs = new HashMap<String, String>();
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String DataDeAtualizacao = dateFormat.format(new Date());
            String myUrl = "jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC";
            Connection conn = null;
            conn = createConnection("com.mysql.cj.jdbc.Driver", myUrl, usuario, senha);
            String Query = "Update kayan.api set Descricao ='" + Descricao + "', DataDeAtualizacao ='" + DataDeAtualizacao + "' WHERE NomeCompleto = '" + Nome + "'";
            PreparedStatement pst = conn.prepareStatement(Query);
            pst.execute();
            regs.put("Message", "Registro Atualizado");
            plus.put("Message", regs);
            return plus;
        }
        catch (Exception e){
            plus.put("erro", e.getMessage());
            return plus;
        }
    }

    


    public static Connection createConnection(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        if ((username == null) || (password == null) || (username.trim().length() == 0) || (password.trim().length() == 0)) {
            return DriverManager.getConnection(url);
        } else {
            return DriverManager.getConnection(url, username, password);
        }
    }
}
