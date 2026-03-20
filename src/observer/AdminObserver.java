package observer;

/**
 * Clase AdminObserver que implementa el patrón Observer para notificaciones administrativas.
 * Esta clase representa a un observador que es un administrador del sistema de biblioteca.
 * Cuando ocurre un evento, el administrador recibe una notificación concisa con la información
 * esencial del evento, incluyendo el tipo, material y usuario involucrado.
 */
public class AdminObserver implements IObserver{
    /**
     * Nombre del administrador que recibe las notificaciones.
     * Este campo identifica al administrador específico en el sistema.
     */
    private String adminName;

    /**
     * Constructor de AdminObserver.
     * Inicializa el observador con el nombre del administrador.
     *
     * @param adminName El nombre del administrador que será mostrado en las notificaciones
     */
    public AdminObserver(String adminName){
        this.adminName= adminName;
    }

    /**
     * Método update implementado de IObserver.
     * Se ejecuta cuando el publicador notifica un evento. Imprime una notificación
     * administrativa en la consola con el formato específico para administradores,
     * incluyendo el nombre del admin, tipo de evento, material y usuario.
     *
     * @param event El objeto LibraryEvent con la información del evento ocurrido
     */
    @Override
    public void update(LibraryEvent event){
        if (event.getEventType().equals("MATERIAL_REGISTERED")) {
            System.out.println("New registered material: " + event.getMaterialName());
        } else if (event.getEventType().equals("MATERIAL_LOANED")) {
            System.out.println("Material '" + event.getMaterialName() + "' loaned to: " + event.getNameUser());
        } else if (event.getEventType().equals("MATERIAL_RETURNED")) {
            System.out.println("Material returned: " + event.getMaterialName());
        }
    }
}
