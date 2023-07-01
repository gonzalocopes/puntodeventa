///Clase venta, se encarga de agregar los productos que se verán reflejados en el recibo

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venta {
    private Scanner scanner;
    private Inventario inventario;
    private List<Producto> carrito;

    public Venta(Inventario inventario) {
        scanner = new Scanner(System.in);
        this.inventario = inventario;
        carrito = new ArrayList<>();
    }

    ///Menu principal de la venta. Muestra una lista con los productos y le pregunta al usuario cual
    ///desea agregar e indicar la cantidad. También un metodo para que, en caso de abrir éste menu por error,
    ///podamos vovler al menu anterior
    public void iniciarVenta() {
        System.out.println("---NUEVA VENTA---");
        boolean seguirAgregando = true;

        while (seguirAgregando) {
            System.out.println("\nProductos disponibles:");
            inventario.mostrarInventario();

            System.out.print("Ingrese el nombre del producto que desea agregar (Ingrese '0' para terminar): ");
            String nombreProducto = scanner.nextLine();

            if (nombreProducto.equals("0")) {
                if (carrito.isEmpty()) {
                    System.out.println("No se han agregado productos a la venta. Regresando al menú principal...");
                    return;
                } else {
                    seguirAgregando = false;
                }
            } else {
                Producto producto = inventario.buscarProducto(nombreProducto);

                if (producto != null) {
                    System.out.print("Ingrese la cantidad de unidades: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();

                    ///Aca validamos que el producto que queremos agregar tenga stock suficiente basandose
                    ///en la cantidad indicada por el usuario
                    if (cantidad <= producto.getCantidad()) {
                        Producto productoCarrito = new Producto(producto.getNombre(), producto.getPrecio(), cantidad);
                        carrito.add(productoCarrito);
                        inventario.actualizarCantidad(producto, cantidad);
                        System.out.println("Producto agregado al carrito.");
                    } else {
                        System.out.println("La cantidad ingresada supera la disponibilidad del producto.");
                    }
                } else {
                    System.out.println("El producto ingresado no existe en el inventario.");
                }
            }
        }

        ///Una vez terminada la venta, se generara el recibo llamando a su metodo en la clase correspondiente.

        Recibo.generarRecibo(carrito);
        carrito.clear();

        ///Una vez impreso el recibo, dará la opción de iniciar una nueva venta

        System.out.println("\n¿Desea iniciar una nueva venta? (S/N): ");
        String opcion = scanner.nextLine();

        if (opcion.equalsIgnoreCase("S")) {
            iniciarVenta();
        } else {
            System.out.println("¡Hasta luego!");
        }
    }
}

