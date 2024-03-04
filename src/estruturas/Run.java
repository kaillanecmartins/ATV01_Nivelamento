package estruturas;

import util.*;
import java.util.StringTokenizer;
public class Run {
    public static void main(String[] args) {
        LeituraArquivo dados = new LeituraArquivo("src/entradas/dados.txt");
        LeituraArquivo comandos = new LeituraArquivo("src/entradas/exec.txt");
        Controlador ctrl = new Controlador();
        int count =  1;
        String entrada = comandos.lerEnesima(count).toString();
        StringTokenizer aux;
        String estrutura;
        aux = new StringTokenizer(entrada, " ");
        estrutura = aux.nextToken();

        System.out.println("Kaillane Corrêa Martins");
        System.out.println("-------Iniciando-------");
        System.out.println("");

        ctrl.inserirTodos(dados.lerTudo());

        Object comando[] = comandos.lerTudo();
        try{
            for (int i = 1; i < comando.length; i++) {
                ctrl.tratar(comando[i].toString(), estrutura);
            }
        }catch(Exception e){
            System.err.println(e);
        }

    }
}
