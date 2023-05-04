import javax.swing.*;
import java.util.*;

public class RedSocial {
    Queue<Persona> PersonasActivas = new PriorityQueue<>((a,b) -> a.getPrioridad() - b.getPrioridad());
    Queue <Persona> EsperaActivos;
    Stack<Persona> Eliminados;

    public RedSocial() {
        EsperaActivos = new LinkedList<Persona>();
        Eliminados = new Stack<Persona>();
    }
    public void AgregarPersona(Persona persona){
        boolean repetido = false;
        for(Persona p: EsperaActivos){
            if(p.getNombre().equalsIgnoreCase(persona.getNombre())){
                repetido = true;
                break;
            }
        }
        if(repetido){
            JOptionPane.showMessageDialog(null, "El nombre ya se encuentra registrado");
        }
        else{
            JOptionPane.showMessageDialog(null,"Se ha agregado una persona");
            EsperaActivos.offer(persona);
        }
    }

    public void DatosPredefinidos(){

        EsperaActivos.offer(new Persona(1, 52,20, 22, "Guillermo"));
        EsperaActivos.offer(new Persona(2, 2,20, 22, "Mateo"));
        EsperaActivos.offer(new Persona(3, 32,50, 22, "Jose"));
        EsperaActivos.offer(new Persona(4, 55,80, 22, "Pepe"));
        EsperaActivos.offer(new Persona(5, 21,100, 22, "Andres"));

    }
    public Persona BuscarIDEspera(int id){
        for (Persona p: EsperaActivos){
            if(p.getId() == id){
                return p;

            }
        }
        return null;
    }

    public Persona BuscarIDActivos(int id){
        for (Persona p: PersonasActivas){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public List<Persona> buscarPrioridadEspera()
    {
        List<Persona> personasEncontradas = new ArrayList<>();
        for (Persona p: EsperaActivos) {
            if (p.getPrioridad() >= 50) {
                personasEncontradas.add(p);
            }
        }
        return personasEncontradas;
    }

    public List<Persona>  buscarPrioridadAcitvos(){
        List<Persona> personasEncontradas = new ArrayList<>();
        for (Persona p: PersonasActivas) {
            if (p.getPrioridad() >= 50) {
                personasEncontradas.add(p);
            }
        }
        return personasEncontradas;
    }

    public Persona ActivarUsuario(){
        if(!EsperaActivos.isEmpty()){
            Persona p = EsperaActivos.poll();
            PersonasActivas.offer(p);
            return p;
        }
        else{
            JOptionPane.showMessageDialog(null, "No hay usuarios en espera");
            return null;
        }
    }

    public List<Persona> ActivarTodos(){
        if(!EsperaActivos.isEmpty()){
            List<Persona> personasActivadaslista = new ArrayList<>(EsperaActivos);
            PersonasActivas.addAll(EsperaActivos);
            EsperaActivos.clear();
            return personasActivadaslista;
        }
        else {
            JOptionPane.showMessageDialog(null, "No hay usuarios en espera");
            return null;
        }
    }

    public Persona EliminarUsuario() {
        if(!PersonasActivas.isEmpty()){
            Persona personaEliminada = PersonasActivas.remove();
            Eliminados.push(personaEliminada);
            return personaEliminada;
        }
        return null;
    }

    public List<Persona> EliminarUsuarios() {
        if(!PersonasActivas.isEmpty()){
            List<Persona> personasEliminadasList = new ArrayList<>(PersonasActivas);
            Eliminados.addAll(PersonasActivas);
            PersonasActivas.clear();
            return personasEliminadasList;
        }
        return null;
    }

    public Persona RestablecerPersona() {
        if(!Eliminados.isEmpty()){
            Persona personaRestablecida = Eliminados.peek();
            Eliminados.pop();
            PersonasActivas.offer(personaRestablecida);
            return personaRestablecida;
        }
        else{
            return null;
        }
    }

    public List<Persona> RestablecerPersonas() {
        if(!Eliminados.isEmpty()){
            List<Persona> personaRestablecidas = new ArrayList<>(Eliminados);
            PersonasActivas.addAll(Eliminados);
            Eliminados.clear();
            return personaRestablecidas;
        }
        return null;
    }
    public String toStringEliminados() {
        return  "La lista de Eliminados" + Eliminados;
    }
    public String toStringActivos() {
        return  "La lista de Activos" + PersonasActivas;
    }
    public String toStringEspera() {
        return  "La lista de Espera" + EsperaActivos;
    }

    @Override
    public String toString() {
        return "RedSocial{" +
                "PersonasActivas=" + PersonasActivas +
                ", EsperaActivos=" + EsperaActivos +
                ", Eliminados=" + Eliminados +
                '}';
    }
}
