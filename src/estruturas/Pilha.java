package estruturas;

import util.Metodos;

public class Pilha implements Metodos{
    //private ListaLigada pilha;
    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

    public Pilha(){
        //this.pilha = new ListaLigada();
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void inserir(Object info){
        Nodo elem = new Nodo(info);
        Nodo aux = inicio;
        if (tamanho == 0){
            fim = inicio;
        }
        inicio = elem;
        inicio.setProximo(aux);
        tamanho ++;
    }

    public Object remover(){
        if(inicio==null){
            return null;
        }
        Object aux = inicio.getInfo();
        inicio=inicio.getProximo();
        if(inicio != null){
            inicio.setAnterior(null);
        }else{
            fim = null;
        }
        tamanho--;
        return aux;
    }

    @Override
    public Object buscar(Object info){
        Nodo atual = inicio;
        if(inicio==null){
            System.out.println("Lista vazia");
            return null;
        }

        while(atual != null && info != atual.getInfo()){
            atual=atual.getProximo();
        }
        if(atual==null || info!=atual.getInfo()){
            return null;
        }else{
            return info;
        }
    }

    public void inserir(Object[] elemento){
        for (Object object : elemento) {
            inserir(object);
        }
    }

    @Override
    public String toString(){
        String str="";
        Nodo local= inicio;
        while (local!= null){
            str += local.getInfo() + ", ";
            local = local.getProximo();
        }

        return str;
    }

    @Override
    public String imprimir(){
        return toString();
    }

    @Override
    public Object remover(Object elemento) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

