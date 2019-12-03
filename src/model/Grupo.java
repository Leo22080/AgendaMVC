package model;

import java.util.ArrayList;
import json.JSONArray;
import json.JSONObject;

public class Grupo {
    
    private String nome;

    public Grupo() {
    }
    
    public Grupo(JSONObject json){
        this.nome = json.getString("nome");
    }

    public Grupo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("nome",this.nome);
        return json;
    }

    public boolean Persistir(){
        JSONObject json = this.toJson();
        
        String base = Arquivo.Read("grupo.txt");
        JSONArray jA = new JSONArray();
        if(!base.isEmpty() && base.length()>5)
            jA = new JSONArray(base);
        
        jA.put(json);
        Arquivo.Write(jA.toString(), "grupo.txt");
       
        return true;
    }
    
    public static ArrayList<Grupo> getGrupos(){
        ArrayList<Grupo> grupos = new ArrayList();
        String base = Arquivo.Read("grupo.txt");
        if(base.isEmpty() || base.length()<5)
            return null;
        
        JSONArray jA = new JSONArray(base);
        for(int i=0;i<jA.length();i++){
            Grupo G = new Grupo(jA.getJSONObject(i));
            grupos.add(G);
        }
        return grupos;
    }    
    
}
