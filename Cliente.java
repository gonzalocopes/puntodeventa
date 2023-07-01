public class Cliente  extends Persona{
    public Cliente(String nombre, String apellido, Integer dni, Long cuit, Integer num_cliente) {
        super(nombre, apellido, dni);
        this.cuit = cuit;
        this.num_cliente = num_cliente;
    }


    Long cuit;
    Integer num_cliente;

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

    public Integer getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(Integer num_cliente) {
        this.num_cliente = num_cliente;
    }
}
