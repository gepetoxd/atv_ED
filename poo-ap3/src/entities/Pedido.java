package entities;

import interfaces.Imprimivel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido implements Imprimivel {
    private Integer numero;
    private Date data;
    private Cliente cliente;
    private List<Item> listaItems;

    public Pedido(Integer numero, Date data, Cliente cliente) {
        this.numero = numero;
        this.data = data;
        this.cliente = cliente;
        this.listaItems = new ArrayList<>();
    }

    public void adicionarItem(Item item){
        listaItems.add(item);
    }

    public Double valorTotal(){
        return listaItems.stream()
                .mapToDouble(Item::subTotal)
                .sum();
    }

    @Override
    public String getCabecalho() {
        return "Numero Pedido  | Data Pedido  | Cliente | Total ";
    }

    @Override
    public String getDadosFormatados() {
        return numero + "|" + data + "|"  + cliente.getNome() + "|" + valorTotal();
    }
}
