package estruturas;

import util.Metodos;

public class Arvore implements Metodos{
    private Object raiz;
    private Arvore esquerda;
    private Arvore direita;

    @Override
    public void inserir(Object elemento){
        if(raiz==null){
            raiz = elemento;
        }
        else{
            if(raiz.hashCode() < elemento.hashCode()){
                if(direita == null)
                    direita = new Arvore();
                direita.inserir(elemento);
            }else if(raiz.hashCode() > elemento.hashCode()){
                if(esquerda == null)
                    esquerda = new Arvore();
                esquerda.inserir(elemento);
            }
        }
    }
    public void inserir(Object[] elemento){
        for (int i = 0; i < elemento.length; i++) {
            inserir(elemento[i]);
        }
    }

    @Override
    public Object buscar(Object elemento){
        if(this != null){
            if(raiz.hashCode() == elemento.hashCode()){
                return raiz;
            }else if(raiz.hashCode() > elemento.hashCode()){
                if(esquerda != null){
                    return esquerda.buscar(elemento);
                }
            }else if(raiz.hashCode() < elemento.hashCode()){
                if(direita != null){
                    return direita.buscar(elemento);
                }
            }
        }

        return null;
    }

    @Override
    public Object remover(Object elemento){
        Object result = null;

        if(elemento != null){
            Arvore aux = this;
            Arvore paiAux = null;


            while(aux != null){
                if(aux.raiz.hashCode() == elemento.hashCode()){
                    break;
                }else if(aux.raiz.hashCode() > elemento.hashCode()){
                    paiAux = aux;
                    aux = aux.esquerda;
                }else if(aux.raiz.hashCode() < elemento.hashCode()){
                    paiAux = aux;
                    aux = aux.direita;
                }

            }

            if(aux != null){
                if(aux.direita == null && aux.esquerda == null){
                    if(paiAux != null){
                        if(paiAux.raiz.hashCode() > aux.raiz.hashCode()) {
                            paiAux.esquerda = null;
                        }else{
                            paiAux.direita = null;
                        }
                        result = aux;
                        aux = null;
                    }else{
                        result = raiz;
                        raiz = null;
                    }
                    return result;

                }
                else if (aux.direita != null && aux.esquerda == null || aux.direita == null && aux.esquerda != null){
                    if(paiAux != null){
                        if(aux.direita != null){
                            result = aux;
                            aux = aux.direita;
                        }else if(aux.esquerda != null){
                            result = aux;
                            aux = aux.esquerda;
                        }

                        if(paiAux.raiz.hashCode() > aux.raiz.hashCode()) {
                            paiAux.esquerda = aux;
                        }else{
                            paiAux.direita = aux;
                        }
                    }else{
                        if(aux.direita != null){
                            result = raiz;
                            raiz = aux.direita.getRaiz();
                            esquerda = aux.direita.esquerda;
                            direita = aux.direita.direita;
                        }else if(aux.esquerda != null){
                            result = raiz;
                            raiz = aux.esquerda.getRaiz();
                            direita = aux.esquerda.direita;
                            esquerda = aux.esquerda.esquerda;
                        }
                    }

                }
                else if(aux.direita != null && aux.esquerda != null){
                    Arvore menor = aux.direita;
                    Arvore paiDoMenor = null;

                    if(menor.esquerda != null){
                        //pega o menor filho da esquerda
                        while(menor.esquerda != null){
                            paiDoMenor = menor;
                            menor = menor.esquerda;
                        }

                        //caso não existe filhos do lado esquerdo
                        if(paiDoMenor != null){
                            if(menor.direita != null){
                                paiDoMenor.esquerda = menor.direita;
                            }
                            else{
                                paiDoMenor.esquerda = null;
                            }
                        }


                        if(paiAux != null){
                            menor.esquerda = aux.esquerda;
                            menor.direita = aux.direita;

                            if(paiAux.raiz.hashCode() > aux.raiz.hashCode()) {
                                paiAux.esquerda = menor;
                            }else{
                                paiAux.direita = menor;
                            }
                            result = aux.getRaiz();
                        }else{
                            result = raiz;
                            raiz = menor.getRaiz();
                        }
                    }
                    else{
                        result = aux.raiz;
                        aux.direita = menor.direita;
                        aux.raiz = menor.raiz;
                    }
                }
            }
        }
        return result;
    }

    public String ordem(){
        String result = "";

        if(esquerda != null)
            result += esquerda.ordem();
        if(raiz != null)
            result += raiz + ", ";
        if(direita != null)
            result += direita.ordem();

        return result;
    }
    public String preOrdem(){
        String result = "";

        if(raiz != null)
            result += raiz + ", ";
        if(esquerda != null)
            result += esquerda.preOrdem();
        if(direita != null)
            result += direita.preOrdem();

        return result;
    }
    public String posOrdem(){
        String result = "";

        if(esquerda != null)
            result += esquerda.posOrdem();
        if(direita != null)
            result += direita.posOrdem();
        if(raiz != null)
            result += raiz + ", ";

        return result;
    }

    public Object getRaiz(){
        return raiz;
    }
    @Override
    public String imprimir() {
        return toString();
    }

    @Override
    public String toString() {
        return ordem();
    }


}
