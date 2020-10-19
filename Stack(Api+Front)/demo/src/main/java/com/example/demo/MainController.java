package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * MainController
 */
@RestController
public class MainController {
    @CrossOrigin()
    @GetMapping(value = "/lista")
    public Map<String, Object> getMethodName() throws JSONException {
        HashMap<String, Object> js = new HashMap<>();
        js = MySqlConnection.getLista();
        return js;
        
    }
    @CrossOrigin
    @PostMapping(value="/listaNome")
    public Map<String, Object> Lista(@RequestBody String Nome){
        return MySqlConnection.getListacomNome(Nome);
    }
    @CrossOrigin
    @PostMapping(value="/add")
    public Map<String, Object> CriaRegistro(@RequestBody String newRegistro){
    Registro Reg = new Registro(); 
    Reg = Reg.CriarRegistro(newRegistro.replace("{", "").replace("}", ""));   
    return MySqlConnection.addInfo(Reg.buscaNome(), Reg.buscaDescricao());
    }

    @CrossOrigin
    @PostMapping(value="/delete")
    public Map<String, Object> DeletaRegistro(@RequestBody String Nome){
        Registro Reg = new Registro(); 
        Reg = Reg.CriarRegistro(Nome.replace("{", "").replace("}", ""));
        return MySqlConnection.DeleteInfo(Reg.buscaNome());
    }
    @CrossOrigin
    @PostMapping(value="/update")
    public Map<String, Object> AtualizaRegist(@RequestBody String base){
        Registro Reg = new Registro(); 
        Reg = Reg.CriarRegistro(base.replace("{", "").replace("}", ""));   
        return MySqlConnection.UpdateInfo(Reg.buscaNome(), Reg.buscaDescricao());
    } 
}