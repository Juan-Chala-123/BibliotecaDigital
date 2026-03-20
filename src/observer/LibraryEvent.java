package observer;
import java.time.LocalDateTime;

/**
 * Clase LibraryEvent que representa un evento ocurrido en el sistema de biblioteca digital.
 * Esta clase encapsula toda la información relevante sobre un evento, como el tipo de evento,
 * el material involucrado, el usuario que lo realizó y la fecha y hora en que ocurrió.
 * Los objetos LibraryEvent se utilizan para notificar a los observadores sobre cambios
 * en el estado de la biblioteca.
 *
 * @author JUAN
 */
public class LibraryEvent {
    /**
     * Tipo de evento que ocurrió (por ejemplo, "PRESTAMO", "DEVOLUCION", "RESERVA", etc.).
     * Este campo describe la acción realizada en la biblioteca.
     */
    private String eventType;

    /**
     * Nombre del material bibliográfico involucrado en el evento
     * (por ejemplo, título de un libro, revista, etc.).
     */
    private String materialName;

    /**
     * Nombre del usuario que realizó la acción que generó el evento.
     * Puede ser un estudiante, profesor u otro tipo de usuario del sistema.
     */
    private String nameUser;

    /**
     * Fecha y hora exacta en que ocurrió el evento.
     * Se utiliza LocalDateTime para una representación precisa del momento.
     */
    private LocalDateTime datetime;

    /**
     * Constructor de la clase LibraryEvent.
     * Inicializa todos los campos del evento con los valores proporcionados.
     * Nota: Hay un error tipográfico en el parámetro 'evenType' que debería ser 'eventType'.
     *
     * @param evenType Tipo de evento (parámetro con error tipográfico, debería ser eventType)
     * @param materialName Nombre del material involucrado
     * @param nameUser Nombre del usuario que realizó la acción
     * @param datetime Fecha y hora del evento
     */
    public LibraryEvent(String evenType, String materialName, String nameUser, LocalDateTime datetime){
        this.eventType = evenType;
        this.materialName= materialName;
        this.nameUser= nameUser;
        this.datetime= datetime;
    }

    /**
     * Obtiene el tipo de evento.
     *
     * @return El tipo de evento como cadena de texto
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Obtiene el nombre del material involucrado en el evento.
     *
     * @return El nombre del material como cadena de texto
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * Obtiene el nombre del usuario que realizó la acción.
     *
     * @return El nombre del usuario como cadena de texto
     */
    public String getNameUser() {
        return nameUser;
    }

    /**
     * Obtiene la fecha y hora del evento.
     *
     * @return El objeto LocalDateTime representando la fecha y hora del evento
     */
    public LocalDateTime getDatetime() {
        return datetime;
    }


}
