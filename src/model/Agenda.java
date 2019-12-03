
package model;

import java.util.ArrayList;
import java.util.Observable;
import json.JSONArray;
import json.JSONObject;

public class Agenda extends Observable{
    private static Agenda instance = null;
    
    private ArrayList<Contato> contatos;

    private Agenda() {
        contatos = new ArrayList<Contato>();
    }
    
    public static Agenda getInstance(){
        if(instance == null){
            instance = new Agenda();
        }
        return instance;
    }
    
    public boolean inserirContato(String nome, String email, String telefone){
        Contato contato = new Contato(nome, email, telefone);
        contatos.add(contato);
        return persistir(contato);
    }
    
    public void notifyCharged(){
        setChanged();
        notifyObservers();                
    }

    
    public boolean persistir(Contato c){
        notifyCharged();
        JSONObject json = c.toJson();
        
        String base = Arquivo.Read("base.txt");
        JSONArray jA = new JSONArray();
        if(!base.isEmpty() && base.length()>5)
            jA = new JSONArray(base);
        
        jA.put(json);
        Arquivo.Write(jA.toString(), "base.txt");
       
        return true;
    }
    
    public static ArrayList<Contato> getContatos(){
        ArrayList<Contato> contatos = new ArrayList();
        String base = Arquivo.Read("base.txt");
        if(base.isEmpty() || base.length()<5)
            return null;
        
        JSONArray jA = new JSONArray(base);
        for(int i=0;i<jA.length();i++){
            Contato A = new Contato(jA.getJSONObject(i));
            contatos.add(A);
        }
        return contatos;
    }
    
    public void limpar(){
        Arquivo.limpar("base.txt");
    }

    public void auterarContato(String grupo, int idice) {
        Contato a = new Contato();
        System.out.println(grupo);
        ArrayList<Contato> A = this.getContatos();
        A.get(idice).setGrupo(grupo);
        limpar();
        for(int i=0; i<A.size(); i++){
            persistir(A.get(i));
        }
        notifyCharged();
    }
    
}
