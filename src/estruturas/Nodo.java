package estruturas;

public class Nodo {
    private Object info;
    private Nodo proximo;
    private Nodo anterior;

    public Nodo(Object info){
        this.info = info;
        this.proximo = null;
        this.anterior = null;
    }
    public Nodo(){

    }
    public void setInfo(Object info){
        this.info = info;
    }
    public void setProximo(Nodo proximo){
        this.proximo = proximo;
    }
    public void setAnterior(Nodo anterior){
        this.anterior = anterior;
    }

    public Object getInfo(){
        return info;
    }
    public Nodo getProximo(){
        return proximo;
    }
    public Nodo getAnterior(){
        return anterior;
    }
}
