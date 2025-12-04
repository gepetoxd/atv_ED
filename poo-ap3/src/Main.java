import Report.Relatorio;
import entities.Cliente;
import entities.Item;
import entities.Pedido;
import entities.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criando Produtos
        Produto p1 = new Produto("001", "Mouse Gamer", 120.0);
        Produto p2 = new Produto("002", "Teclado Mecânico", 250.0);

        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(p1);
        listaProdutos.add(p2);

        // Relatório de produtos
        Relatorio<Produto> relProdutos = new Relatorio<>();
        System.out.println("RELATÓRIO DE PRODUTOS:\n");
        relProdutos.imprimirLog(listaProdutos);

        // 2. Cliente e pedido
        Cliente c1 = new Cliente("123.456.789-00", "Carlos Henrique", "carlos@email.com");
        Cliente c2 = new Cliente("611.270.933-39", "Carlos Andrey", "CarlosAndrey@email.com");
        Pedido pedido = new Pedido(1, new Date(), c1);

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(c1);
        clientes.add(c2);

        pedido.adicionarItem(new Item(2, p1));
        pedido.adicionarItem(new Item(1, p2));

        List<Pedido> listaPedidos = new ArrayList<>();
        listaPedidos.add(pedido);

        // Relatório de pedidos
        Relatorio<Pedido> relPedidos = new Relatorio<>();
        System.out.println("\nRELATÓRIO DE PEDIDOS:\n");
        relPedidos.imprimirLog(listaPedidos);

        Relatorio<Cliente> relClientes = new Relatorio<>();
        System.out.println("\nRELATÓRIO DE CLIENTES:\n");
        relClientes.imprimirLog(clientes);}
}

