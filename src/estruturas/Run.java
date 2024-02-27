package estruturas;

import util.*;
public class Run {
    public static void main(String[] args) {
        LeituraArquivo dados = new LeituraArquivo("src/entradas/dados.txt");
        LeituraArquivo comandos = new LeituraArquivo("src/entradas/exec.txt");
        Controlador ctrl = new Controlador();

        System.out.println("Kaillane Corrêa Martins");
        System.out.println("-------Iniciando-------");
        System.out.println("");

        ctrl.inserirTodos(dados.lerTudo());

        Object comando[] = comandos.lerTudo();
        try{
            for (int i = 0; i < comando.length; i++) {
                ctrl.tratar(comando[i].toString());
            }
        }catch(Exception e){
            System.err.println(e);
        }

    }
}
