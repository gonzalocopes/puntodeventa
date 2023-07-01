///Clase donde se encuentra lo que sucede en el menú
///Se utilizan diferentes metodos segun lo requerido del caso

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Inventario inventario;
    baseDatosEmpleado baseDatosEmpleado = new baseDatosEmpleado();
    private Ventas ventas;

    ///Es importante iniciar la venta junto al inventario porque, en caso contrario, si agregamos nuevos productos
    ///y luego iniciamos una venta, lo nuevo que agregemos no se verá reflejado en la lista de productos existentes
    public void iniciarVenta() {
        Venta venta = new Venta(inventario);
        venta.iniciarVenta();
    }

    public Menu() {
        scanner = new Scanner(System.in);
        inventario = new Inventario();
        ventas = new Ventas();
    }

    ///Una vez que iniciamos sesion, pasamos el menú que vemos debajo
    public void mostrarMenu() {
        while (true) {
            System.out.println("\n---MENU---");
            System.out.println("1. Iniciar nueva venta");
            System.out.println("2. Administrar el inventario");
            System.out.println("3. Administrar los empleados");
            System.out.println("4. Salir");
            System.out.print("¿Que desea realizar? ");
            int choice = scanner.nextInt();

            ///Con los case 1, 2, etc lo que hacemos es llamar al metodo indicado para que lo que
            ///selecciones del menú cumpla alguna función

            switch (choice) {
                case 1:
                    iniciarVenta();
                    break;
                case 2:
                    manejoInventario();
                    break;
                case 3:
                    manejoEmpleados();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    System.exit(0); ///Con esto forzamos a que el programa cierre
                default:
                    System.out.println("Opción incorrecta. Selecciona nuevamente.");
            }
        }
    }

    ///Menu para manejar el inventario, en esta instancia simplemente va a llamar a los metodos dentro
    ///de la clase Inventario para que pueda realizar la funcionalidad requerida
    private void manejoInventario() {
        boolean volverMenuAnterior = false;

        while (!volverMenuAnterior) {
            System.out.println("---BIENVENIDO AL INVENTARIO---");
            System.out.println("1. Agregar un nuevo producto");
            System.out.println("2. Quitar un producto");
            System.out.println("3. Mostrar todos los productos");
            System.out.println("4. Volver al menu anterior");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            ///Mismo caso que los case anteriores, sólo que ésta vez estamos llamando a los metodos
            ///que se encuentran DENTRO de otra clase (Por ejemplo: Case 1 = llama al metodo agregarProducto que
            // está dentro de la clase Inventario)

            switch (opcion) {
                case 1:
                    inventario.agregarProducto();
                    break;
                case 2:
                    inventario.quitarProducto();
                    break;
                case 3:
                    inventario.mostrarTodosProductos();
                    break;
                case 4:
                    volverMenuAnterior = true;
                    break;
                default:
                    System.out.println("Opción incorrecta. Selecciona nuevamente.");
                    break;
            }
        }

        mostrarMenu(); // De nuevo, sin iniciar no vuelve al menu y ya no funca
    }

    ///Misma funcionalidad que los anteriores, sólo que este menú nos permitirá administrar los empleados
    private void manejoEmpleados(){
        boolean volverMenuAnterior = false;

        while (!volverMenuAnterior) {
            System.out.println("---ADMINISTRACIÓN DE EMPLEADOS");
            System.out.println("1. Agregar un nuevo empleado");
            System.out.println("2. Remover un empleado existente");
            System.out.println("3. Mostrar todos los empleados");
            System.out.println("4. Volver al menu anterior");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    baseDatosEmpleado.agregarEmpleado();
                    break;
                case 2:
                    baseDatosEmpleado.quitarEmpleado();
                    break;
                case 3:
                    baseDatosEmpleado.mostrarTodosEmpleados();
                    break;
                case 4:
                    volverMenuAnterior = true;
                    break;
                default:
                    System.out.println("Esa opción es incorrecta. Selecciona nuevamente.");
                    break;
            }
        }

        mostrarMenu(); ///Al poner mostrarMenu nos aseguramos que, cuando terminemos de operar,
        ///en vez de que el programa se cierre, se vuelva a abrir el menu para agilizar el funcionamiento
        ///del programa
    }
}
