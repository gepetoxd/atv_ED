package Report;

import interfaces.Imprimivel;

import java.util.List;

public class Relatorio<T extends Imprimivel>  {
    public void imprimirLog(List<T> lista){
        if (lista.isEmpty()) return;

        System.out.println(lista.get(0).getCabecalho());

        for (T item : lista){
            System.out.println(item.getDadosFormatados());
        }
    }

}
