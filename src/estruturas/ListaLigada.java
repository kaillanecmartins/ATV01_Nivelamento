package estruturas;

import util.Metodos;

public class ListaLigada implements Metodos{
    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

    public void inserirInicio(Object info){
        Nodo elem = new Nodo(info);
        Nodo aux = inicio;

        if (tamanho == 0){
            fim = inicio;
        }

        inicio = elem;
        inicio.setProximo(aux);

        tamanho ++;
    }

    public Object retirarInicio(){
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

    public void inserirFim(Object info){
        Nodo elem = new Nodo();
        elem.setInfo(info);
        elem.setProximo(null);
        elem.setAnterior(fim);
        if(fim != null){
            fim.setProximo(elem);
        }
        fim = elem;
        if (tamanho == 0){
            inicio = fim;
        }
        tamanho ++;
    }

    public Object retirarFim(){
        if(fim==null){
            return null;
        }
        Object aux = fim.getInfo();
        fim = fim.getAnterior();
        if(fim != null){
            fim.setAnterior(null);
        }else{
            inicio = null;
        }
        tamanho--;
        return aux;
    }

    public void inserirpos(int pos,Object info){
        if(pos <=0){
            inserirInicio(info);
        }else if(pos>= tamanho){
            inserirFim(info);
        }else{
            Nodo local = inicio;
            for (int i=0; i<pos-1;i++){
                local=local.getProximo();
            }
            Nodo elem = new Nodo();
            elem.setInfo(info);
            elem.setAnterior(local);
            elem.setProximo(local.getProximo());
            local.setProximo(elem);
            elem.getProximo().setAnterior(elem);
            tamanho++;
        }

    }

    public Object retirarpos(int pos){
        if(pos<0 || pos>= tamanho || inicio == null){
            return null;
        }else if(pos == 0){
            return retirarInicio();
        }else if(pos == tamanho-1){
            return retirarFim();
        }

        Nodo local = inicio;
        for (int i= 0; i< pos;i++){
            local = local.getProximo();
        }
        if(local.getAnterior() != null){
            //local.anterior.proximo = local.proximo;
            local.getAnterior().setProximo(local.getProximo());
        }
        if(local.getProximo() != null){
            //local.proximo.anterior = local.anterior;
            local.getProximo().setAnterior(local.getAnterior());
        }
        tamanho--;
        return local.getInfo();
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
    public void inserir(Object elemento) {
        inserirFim(elemento);
    }

    public void inserir(Object[] elemento){
        for (Object object : elemento) {
            inserir(object);
        }
    }

    @Override
    public Object remover(Object elemento) {
        if(tamanho > 0){
            Nodo atual = inicio;
            while(atual != null && !elemento.equals(atual.getInfo())){
                atual=atual.getProximo();
            }
            if(atual != null){
                if(atual.getAnterior() != null){
                    //atual.anterior.proximo = atual.proximo;
                    atual.getAnterior().setProximo(atual.getProximo());
                }
                if(atual.getProximo() != null){
                    //atual.proximo.anterior = atual.anterior;
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                tamanho--;
                return atual.getInfo();
            }
        }
        return null;
    }
}

