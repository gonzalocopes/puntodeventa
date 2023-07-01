//En esta parte del codigo tenemos la informacion y funcionalidad de los empleados
//Incluye como obtener sus nombres, legajos, y también su puesto en el Almacen para lo cual
//se utilizó herencia

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Empleado {
    private String nombre;
    private int legajo;

    public Empleado(String nombre, int legajo) {
        this.nombre = nombre;
        this.legajo = legajo;
    }

    public String getnombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getlegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }
}



///Acá usamos HERENCIA para extener la clase Empleado y poder darle a los mismos un rol dentro del Almacen
class Mantenimiento extends Empleado {
    private String puesto;

    public Mantenimiento(String nombre, int legajo, String puesto) {
        super(nombre, legajo);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}

class Vendedor extends Empleado {
    private String puesto;

    public Vendedor(String nombre, int legajo, String puesto) {
        super(nombre, legajo);
        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}

///Dado que no pudimos implementar una base de datos como tal, decidimos utilizar una arraylist
///para poder guardar un pequeño numero de empleados con su respectivo nombre, legajo y puesto.

class baseDatosEmpleado {
    private List<Empleado> Empleados;

    public baseDatosEmpleado() {
        Empleados = new ArrayList<>();
        iniciarEmpleados();
    }
    
    //Para que se puedan visualizar es importante que la lista de empleados esté declarada e iniciada

    private void iniciarEmpleados() {
        Empleados.add(new Vendedor("Flavio Salas", 38455360, "Mantenimiento"));
        Empleados.add(new Mantenimiento("Nicolas Piedimonte", 39407023, "Cajero"));
        Empleados.add(new Vendedor("Gonzalo Copes", 38681596, "Seguridad"));
        Empleados.add(new Vendedor("Ayelen Rivero", 35974707, "Vendedora"));
        ///Siguiendo los ejemplos anteriores, se pueden agregar tantos empleados sean necesarios
        ///Algo que no se pudo implementar es que, por ejemplo, si se inicia sesión con un usuario que
        ///NO sea vendedor, que no permita usar esa funcionalidad del menú.
    }

    ///Metodo para agregar empleado, pide un nombre y el legajo y se verá reflejado dentro de la lista
    ///que podemos ver más arriba
    public void agregarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo empleado:");
        String nombre = scanner.nextLine();
        System.out.println("Ahora ingrese su legajo:");
        int legajo = scanner.nextInt();
        Empleado newEmpleado = new Empleado(nombre, legajo);
        Empleados.add(newEmpleado);
        System.out.println("El empleado" + nombre + " ha sido agregado.");
    }

    ///Lo mismo pero para quitar un empleado existente.
    public void quitarEmpleado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el legajo del empleado que desea quitar:");
        int legajo = scanner.nextInt();
        Empleado EmpleadoAQuitar = null;
        for (Empleado Empleado : Empleados) {
            if (Empleado.getlegajo() == legajo) {
                EmpleadoAQuitar = Empleado;
                break;
            }
        }
        ///Validamos si el empleado que vamos a quitar está o no en la lista de los mismos
        if (EmpleadoAQuitar != null) {
            Empleados.remove(EmpleadoAQuitar);
            System.out.println("El empleado " + EmpleadoAQuitar.getnombre() + " se ha quitado.");
        } else {
            System.out.println("No se encontró ningun empleado con legajo " + legajo );
        }
    }

    ///Metodo que devuelve una lista con todos los empleados y sus respectivos legajos
    public void mostrarTodosEmpleados() {
        for (Empleado Empleado : Empleados) {
            System.out.println("nombre: " + Empleado.getnombre() + ", legajo: " + Empleado.getlegajo());
        }
    }

    ///Acá validamos que, al iniciar sesion e ingresar nuestro legajo, éste sea correcto
    ///Asi devuelve un mensaje de bienvenida + el nombre asignado al legajo
    public Empleado encontrarEmpleado(int legajo) {
        for (Empleado Empleado : Empleados) {
            if (Empleado.getlegajo() == legajo) {
                return Empleado;
            }
        }
        return null;
    }
}
