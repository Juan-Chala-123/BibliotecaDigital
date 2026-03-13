package observer;

/**
 * Clase UserObserver que implementa el patrón Observer para notificaciones a usuarios.
 * Esta clase representa a un observador que es un usuario regular del sistema de biblioteca.
 * Cuando ocurre un evento, el usuario recibe una notificación simplificada que incluye
 * el tipo de evento y el material involucrado, pero omite detalles como el nombre del usuario
 * (ya que el observador conoce su propio nombre).
 */
public class UserObserver implements IObserver{

    /**
     * Nombre del usuario que recibe las notificaciones.
     * Este campo identifica al usuario específico en el sistema.
     */
    private String userName;

    /**
     * Constructor de UserObserver.
     * Inicializa el observador con el nombre del usuario.
     *
     * @param userName El nombre del usuario que será mostrado en las notificaciones
     */
    public UserObserver(String userName){
        this.userName= userName;
    }

    /**
     * Método update implementado de IObserver.
     * Se ejecuta cuando el publicador notifica un evento. Imprime una notificación
     * simplificada en la consola con el formato específico para usuarios,
     * incluyendo el nombre del usuario, tipo de evento y material involucrado.
     * No incluye el nombre del usuario del evento ya que el observador es el usuario mismo.
     *
     * @param event El objeto LibraryEvent con la información del evento ocurrido
     */
    @Override
    public void update(LibraryEvent event){
        System.out.println("[USER - "+userName+"]"
                +event.getEventType()
                +"-"+event.getMaterialName());
    }

}
