import java.util.*;
import javax.swing.JOptionPane;
public class RedSocialFicticia {
    public class SocialNetwork {
        Queue <Persona> PersonasActivas = new PriorityQueue<>();
        Queue <Persona> EsperaActivos;
        Stack <Persona> Eliminados;

        public SocialNetwork() {
         EsperaActivos = new LinkedList<Persona>();
         Eliminados = new Stack<Persona>();
         }



        public void DatosPredefinidos(){

            EsperaActivos.offer(new Persona(1, 52,20, 22, "Guillermo"));
            EsperaActivos.offer(new Persona(2, 2,20, 22, "Mateo"));
            EsperaActivos.offer(new Persona(3, 32,50, 22, "Jose"));
            EsperaActivos.offer(new Persona(4, 55,80, 22, "Pepe"));
            EsperaActivos.offer(new Persona(5, 21,100, 22, "Andres"));

        }
        public Persona BuscarID(int id){
            for (Persona p: EsperaActivos){
                if(p.getId() == id){
                    return p;
                }
            }
            return null;
        }

        public Persona buscarPrioridad(int prioridad)
        {
            for (Persona p: EsperaActivos) {
                if (p.getPrioridad() >= 50) {
                    return p;
                }
            }
            return null;
        }

        public Persona buscarPrioridadAcitvos(int prioridad){
            for (Persona p: PersonasActivas) {
                if (p.getPrioridad() >= 50) {
                    return p;
                }
            }
            return null;
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
                Eliminados.clear();
                return personasEliminadasList;
            }
            return null;
        }

        public Persona RestablecerPersona() {
            if(!Eliminados.isEmpty()){
                Persona personaRestablecida = Eliminados.pop();
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
                personaRestablecidas.clear();
                return personaRestablecidas;
            }
            return null;
        }

    }

}
