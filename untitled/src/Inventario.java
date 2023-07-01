//Clase inventario, se encarga de manejar lo que ocurre dentro del ineventario

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    private List<Producto> items;
    private Scanner scanner;

    public Inventario() {
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
        iniciarInventario();

    }

    ///Iniciamos el inventario, junto a sus productos con sus respectivos atributos
    ///Vale la pena aclarar que la cantidad asignada a los productos es real
    private void iniciarInventario() {
        Producto producto1 = new Producto("Arroz", 250.00, 100);
        Producto producto2 = new Producto("Arvejas", 99.00, 80);
        Producto producto3 = new Producto("Aceite", 510.00, 50);
        Producto producto4 = new Producto("Fideos", 400.00, 30);
        Producto producto5 = new Producto("Polenta",200.00, 50);
        Producto producto6 = new Producto("Lentejas",300.00, 20);
        Producto producto7 = new Producto("Garbanzos",280.00, 10);
        Producto producto8 = new Producto("Capeletinis",1000.00, 50);
        Producto producto9 = new Producto("Salchichas",350.00, 40);
        Producto producto10 = new Producto("Patys",500.00, 00);

        
        
        items.add(producto1);
        items.add(producto2);
        items.add(producto3);
        items.add(producto4);
        items.add(producto5);
        items.add(producto6);
        items.add(producto7);
        items.add(producto8);
        items.add(producto9);
        items.add(producto10);
    }

    ///Metodo que nos muestra una lista con todos los productos disponibles
    public void mostrarInventario() {
        for (Producto producto : items) {
            System.out.println("- " + producto.getNombre() + " ($" + producto.getPrecio() + ")");
        }
    }

    ///Metodo para que, de ser necesario,busque un producto (Por ejemplo, si queremos remover un producto,
    ///debemos "buscarlo" y comprobar que el mismo se encuentre dentro del inventario)
    public Producto buscarProducto(String nombre) {
        for (Producto producto : items) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    ///Metodo para que, cuando agregamos un producto o lo vendemos, se actualice la cantidad
    public void actualizarCantidad(Producto producto, int cantidad) {
        producto.setCantidad(producto.getCantidad() - cantidad);
    }

    ///Metodo para agregar un nuevo producto al inventario

    public Producto agregarProducto() {
        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();

        System.out.println("Ingrese la cantidad:");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        // Buscar el producto en el inventario
        Producto productoExistente = buscarProducto(nombre);

        if (productoExistente != null) {
            // Producto existente encontrado, actualizar la cantidad
            int nuevaCantidad = productoExistente.getCantidad() + cantidad;
            productoExistente.setCantidad(nuevaCantidad);

            System.out.println("Se agregaron " + cantidad + "unidades al producto '" + nombre + "' .");

        }else {
            // No se encontro el producto, crear uno nuevo y agregarlo al inventario
            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            items.add(nuevoProducto);

            System.out.println("Se agregó el producto al inventario.");
        }


        return productoExistente;
    }

    ///Metodo para quitar un producto existente en el inventario
    ///Incluye validacion para saber si el producto está o no en el inventario


    public void quitarProducto() {
        System.out.println("Ingresa el nombre del producto que desea quitar:");
        String nombre = scanner.nextLine();

        boolean productoQuitado = false;
        for (Producto producto : items) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                items.remove(producto);
                productoQuitado = true;
                break;
            }
        }

        if (productoQuitado) {
            System.out.println("Se quitó el producto del inventario.");
        } else {
            System.out.println("Ese producto no se encuentra en el inventario.");
        }


    }

    ///Metodo para mostrar una lista con todos los productos disponibles

    public void mostrarTodosProductos() {
        if (items.isEmpty()) {
            System.out.println("El inventario está vacio.");
        } else {
            System.out.println("Lista de articulos en el inventario:");
            for (Producto producto : items) {
                System.out.println("Nombre: " + producto.getNombre() + " | Precio: " + producto.getPrecio() + " | Stock: " + producto.getCantidad());
            }
        }


    }


}