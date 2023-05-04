public class Persona {
    private String nombre;
    private int id, edad, prioridad, amigos;

    public Persona(int id, int edad, int prioridad, int amigos, String nombre) {
        this.id = id;
        this.edad = edad;
        this.prioridad = prioridad;
        this.amigos = amigos;
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "\nId: " + id +
                "\nNombre: " + nombre +
                "\nEdad: " + edad +
                "\nPrioridad: " + prioridad +
                "\nAmigos: " + amigos;
    }
    public int getId(){
        return id;
    }

    public int getPrioridad(){

        return prioridad;
    }

    public String getNombre() {
        return nombre;
    }
}
