package util;

import estruturas.*;
import java.util.StringTokenizer;

public class Controlador {
    private Arvore arv;
    private ListaLigada lista;
    private Pilha pilha;
    private Fila fila;
    private StringTokenizer comando;

    public Controlador(){
        arv = new Arvore();
        pilha = new Pilha();
        fila = new Fila();
        lista = new ListaLigada();
    }


    public void tratar(String comando){
        Metodos estrDado = null;

        this.comando = new StringTokenizer(comando, " ");
        String estrutura = this.comando.nextToken().toLowerCase();
        String metodo = this.comando.nextToken().toLowerCase();

        //Escolher estrutura
        if(estrutura.equals("pilha")){
            estrDado = pilha;
        }
        else if(estrutura.equals("arvore")){
            estrDado = arv;
        }
        else if(estrutura.equals("fila")){
            estrDado = fila;
        }
        else if(estrutura.equals("lista")){
            estrDado = lista;
        }else{
            System.out.println("Estrutura inválida.");
        }

        if(estrDado != null){
            System.out.print(estrDado.getClass().getSimpleName() + ": ");

            //Escolher método
            if(metodo.equals("inserir")){
                if(this.comando.hasMoreElements()){
                    if(estrDado.getClass() != lista.getClass()){
                        Object dado = this.comando.nextToken("\n").substring(1);
                        estrDado.inserir(dado);
                        System.out.println(dado + " adicionado");
                    }
                    else{
                        int index = Integer.parseInt(this.comando.nextElement().toString());
                        Object dado = this.comando.nextToken("\n").substring(1);
                        lista.inserirpos(index, dado);
                        System.out.println(dado + " adicionado");
                    }

                }else{
                    System.out.println("Dado inválido");
                }

            }
            else if(metodo.equals("remover")){

                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);
                    System.out.println(estrDado.remover(dado).toString() + " removido");
                }
                else if(estrDado.getClass() == pilha.getClass()){
                    System.out.println(pilha.remover().toString() + " removido");
                }
                else if(estrDado.getClass() == fila.getClass()){
                    System.out.println(fila.remover().toString() + " removido");
                }
                else{
                    System.out.println("Comando inválido");
                }

            }
            else if(metodo.equals("imprimir")){
                if(estrDado.getClass() == arv.getClass()){
                    if(this.comando.hasMoreTokens()){
                        Object dado = this.comando.nextToken("\n").substring(1);
                        if(dado.equals("ordem")){
                            System.out.println("Ordem: " + arv.ordem());
                        }else if(dado.equals("pre-ordem")){
                            System.out.println("Pré-Ordem: " + arv.preOrdem());
                        }else if(dado.equals("pos-ordem")){
                            System.out.println("Pós-Ordem: " + arv.posOrdem());
                        }
                    }
                    else{
                        System.out.println("Falta argumento");
                    }

                }else{
                    System.out.println(estrDado.imprimir());
                }
            }
            else if(metodo.equals("buscar")){
                if(this.comando.hasMoreElements()){
                    Object dado = this.comando.nextToken("\n").substring(1);

                    if(estrDado.buscar(dado) == null){
                        System.out.println(dado + " não foi encontrado");
                    }
                    else{
                        System.out.println(dado + " foi encontrado");
                    }
                }else{
                    System.out.println("Dado inválido");
                }

            }
            else{
                System.out.println("Método inválido.");
            }

        }
    }

    public void inserirTodos(Object[] dados){
        if(dados != null){
            arv.inserir(dados);
            pilha.inserir(dados);
            fila.inserir(dados);
            lista.inserir(dados);
        }

    }
}

