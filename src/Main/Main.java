package Main;

import servicos.ControleDePedidos;
import ui.Cardapio;
import ui.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cardapio cardapio = new Cardapio();
        ControleDePedidos controleDePedidos = new ControleDePedidos();

        Menu.menuCafeSinos(cardapio, controleDePedidos);
    }
}



