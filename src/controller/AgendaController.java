package controller;

import model.Contato;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import model.Agenda;
import model.Grupo;

public class AgendaController implements Observer{
    private static AgendaController instance = null;
    Agenda model;

    private AgendaController() {
        model = Agenda.getInstance();
    }
    
    public static AgendaController getInstance(){
        if(instance == null){
            instance = new AgendaController();
        }
        return instance;
    }
    
    public void initialized(){
        model.notifyCharged();
    }
    
    public boolean salvarContato(String nome, String email, String telefone){
        boolean ok = model.inserirContato(nome, email, telefone);
        model.notifyCharged();
        return ok;
    }
    
    public ArrayList<String[]> getContatos(){
        ArrayList<String[]> contatos = new ArrayList();
        
        ArrayList<Contato> A = model.getContatos();
        if(A!=null){
            for(int i=0;i<A.size();i++){
                String a[] = new String[3];
                a[0] = A.get(i).getNome();
                a[1] = A.get(i).getEmail();
                a[2] = A.get(i).getTelefone();
                contatos.add(a);
            }
        }        
        return contatos;
    }
    
    public static void salvaGrupo(String nome){
        Grupo g = new Grupo(nome);
        g.Persistir();
    }
    
    public ArrayList<String[]> getContatos(String grupo){
        ArrayList<String[]> contatos = new ArrayList();
        
        ArrayList<Contato> A = model.getContatos();
        if(A!=null){
            for(int i=0;i<A.size();i++){
                String a[] = new String[4];
                if(grupo.equals(A.get(i).getGrupo())){
                    a[0] = A.get(i).getNome();
                    a[1] = A.get(i).getEmail();
                    a[2] = A.get(i).getTelefone();
                    contatos.add(a);
                }
            }
        }        
        return contatos;
    }
    
    public void auterarContato(String grupo, int idice){
        model.notifyCharged();
        model.auterarContato(grupo, idice);
    }   
    
    public ArrayList<String> getGrupo(){
        ArrayList<String> grupos = new ArrayList();
      
        ArrayList<Grupo> G = Grupo.getGrupos();
        if(G!=null){
            for(int i=0;i<G.size();i++){
                String a = G.get(i).getNome();

                grupos.add(a);
            }
        }        
        return grupos;
    }
    
    public void atualizar(){
        model.notifyCharged();
    }

    @Override
    public void update(Observable o, Object arg) {      
    }
    
}
