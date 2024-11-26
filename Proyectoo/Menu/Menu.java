package Proyectoo.Menu;


import Proyectoo.Cliente.Cliente;
import Proyectoo.Pedido.Pedido;
import Proyectoo.PedidoDAO.PedidoDAO;

import java.util.Scanner;

class Menu {
    private Scanner scanner = new Scanner(System.in);
    private double precioSabor;
    private String saborSeleccionado;
    private double precioBase;
    private String baseSeleccionada;
    private double precioTamaño;
    private String tamañoSeleccionado;

    public static void main(String[] args) {
        Menu menu = new Menu();
        Cliente cliente = new Cliente();
        System.out.println();
        menu.mostrarMenu();
    }

    public void mostrarMenu() {
        int opcion;

        System.out.println("Bienvenido al Menú de Jugos Happy Healthy");
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Menú de sabores");
            System.out.println("2. Seleccione el sabor (por número)");
            System.out.println("3. Elija la base del sabor (Agua o Leche)");
            System.out.println("4. Seleccione el tamaño del jugo");
            System.out.println("5. Mostrar total del pedido");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    mostrarSabores();
                    break;
                case 2:
                    seleccionarSabor();
                    break;
                case 3:
                    seleccionarBase();
                    break;
                case 4:
                    seleccionarTamaño();
                    break;
                case 5:
                    mostrarTotalPedido();
                    PedidoDAO.guardarPedido();
                    break;
                case 6:
                    System.out.println("Gracias por su visita. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private void mostrarSabores() {
        System.out.println("\nMenú de Sabores:");
        System.out.println("1. Mango - Bs. 4.00");
        System.out.println("2. Fresa - Bs. 3.00");
        System.out.println("3. Piña - Bs. 4.00");
        System.out.println("4. Maracuya - Bs. 5.00");
        System.out.println("5. Platano - Bs. 3.00");
        System.out.println("6. Papaya - Bs. 4.00");
        System.out.println("7. Manzana - Bs. 5.00");
        System.out.println("8. Naranja - Bs. 4.00");
        System.out.println("9. Sandia - Bs. 4.00");
        System.out.println("10. Verde - Bs. 10.00");
    }

    private void seleccionarSabor() {
        System.out.print("Seleccione el número de sabor: ");
        int sabor = scanner.nextInt();
        scanner.nextLine();

        switch (sabor) {
            case 1:
                saborSeleccionado = "Mango - Bs. 4.00";
                precioSabor = 4.00;
                System.out.println("Sabor seleccionado: Mango - Bs. 4.00");
                break;
            case 2:
                saborSeleccionado = "Fresa - Bs. 3.00";
                precioSabor = 3.00;
                System.out.println("Sabor seleccionado: Fresa - Bs. 3.00");
                break;
            case 3:
                saborSeleccionado = "Piña - Bs. 4.00";
                precioSabor = 4.00;
                System.out.println("Sabor seleccionado: Piña - Bs. 4.00");
                break;
            case 4:
                saborSeleccionado = "Maracuya - Bs. 5.00";
                precioSabor = 5.00;
                System.out.println("Sabor seleccionado: Maracuya - Bs. 5.00");
                break;
            case 5:
                saborSeleccionado = "Platano - Bs. 3.00";
                precioSabor = 3.00;
                System.out.println("Sabor seleccionado: Platano - Bs. 3.00");
                break;
            case 6:
                saborSeleccionado = "Papaya - Bs. 4.00";
                precioSabor = 4.00;
                System.out.println("Sabor seleccionado: Papaya - Bs. 4.00");
                break;
            case 7:
                saborSeleccionado = "Manzana - Bs. 5.00";
                precioSabor = 5.00;
                System.out.println("Sabor seleccionado: Manzana - Bs. 5.00");
                break;
            case 8:
                saborSeleccionado = "Naranja - Bs. 4.00";
                precioSabor = 4.00;
                System.out.println("Sabor seleccionado: Naranja - Bs. 4.00");
                break;
            case 9:
                saborSeleccionado = "Sandia - Bs. 4.00";
                precioSabor = 4.00;
                System.out.println("Sabor seleccionado: Sandia - Bs. 4.00");
                break;
            case 10:
                saborSeleccionado = "Verde - Bs. 10.00";
                precioSabor = 10.00;
                System.out.println("Sabor seleccionado: Verde - Bs. 10.00");
                break;
            default:
                System.out.println("Opción inválida. Por favor seleccione un sabor válido.");
        }
    }

    private void seleccionarBase() {
        System.out.print("Seleccione la base del jugo (agua o leche): ");
        baseSeleccionada = scanner.nextLine();
        Pedido.setBase(baseSeleccionada);

        if (baseSeleccionada.equalsIgnoreCase("agua")) {
            System.out.println("Base seleccionada: Agua");
        } else if (baseSeleccionada.equalsIgnoreCase("leche")) {
            System.out.println("Base seleccionada: Leche");
        } else {
            System.out.println("Opción inválida. Seleccione 'agua' o 'leche'.");
        }
    }

    private void seleccionarTamaño() {
        System.out.println("\nSeleccione el tamaño del jugo:");
        System.out.println("1. Pequeño (Bs. 0.00)");
        System.out.println("2. Mediano (Bs. 1.00)");
        System.out.println("3. Grande (Bs. 2.00)");

        int tamañoSeleccionadoInt = scanner.nextInt();
        scanner.nextLine();
        Pedido.setJugoId(tamañoSeleccionadoInt);

        switch (tamañoSeleccionadoInt) {
            case 1:
                tamañoSeleccionado = "Pequeño";
                precioTamaño = 0.00;
                break;
            case 2:
                tamañoSeleccionado = "Mediano";
                precioTamaño = 1.00;
                break;
            case 3:
                tamañoSeleccionado = "Grande";
                precioTamaño = 2.00;
                break;
            default:
                System.out.println("Opción inválida. Seleccione un tamaño válido.");
                return;
        }

        System.out.println("Tamaño seleccionado: " + tamañoSeleccionado);
    }

    private void mostrarTotalPedido() {
        double precioTotal = precioSabor + precioTamaño;

        System.out.println("\nResumen del pedido:");
        System.out.println("Sabor: " + saborSeleccionado);
        System.out.println("Base: " + baseSeleccionada);
        System.out.println("Tamaño: " + tamañoSeleccionado);
        System.out.println("Precio Total: Bs. " + precioTotal);

    }
}