package model;

import java.util.ArrayList;
import json.JSONArray;
import json.JSONObject;

public class Contato {
    private String nome;
    private String email;
    private String telefone;
    private String grupo;

    public Contato() {
    }

    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.grupo = "geral";
    }
    
    public Contato(JSONObject json) {
        this.nome = json.getString("nome");
        this.email = json.getString("email");
        this.telefone = json.getString("telefone");
        this.grupo = json.getString("grupo");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGrupo() {
        return grupo;
    }
    
    public void setGrupo(String grupo){
        this.grupo = grupo;
    }
    
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("nome",this.nome);
        json.put("email",this.email);
        json.put("telefone",this.telefone);
        json.put("grupo", this.grupo);
        return json;
    }  
    
    
}
