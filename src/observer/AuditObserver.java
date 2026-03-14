
package observer;
import java.time.format.DateTimeFormatter;

/**
 * Clase AuditObserver que implementa el patrón Observer para auditoría del sistema.
 * Esta clase representa a un observador especializado en el registro detallado de eventos
 * para fines de auditoría. Proporciona un registro completo y formateado de cada evento,
 * incluyendo fecha y hora, tipo de evento, material y usuario, con un formato visual
 * claro para facilitar la revisión de logs.
 *
 * @author JUAN
 */
public class AuditObserver implements IObserver{
    /**
     * Formateador estático para las fechas y horas en el formato "yyyy-MM-dd HH:mm:ss".
     * Se utiliza para convertir el LocalDateTime del evento en una cadena legible
     * para los registros de auditoría.
     */
    private static final DateTimeFormatter FORMAT= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Método update implementado de IObserver.
     * Se ejecuta cuando ocurre un evento. Formatea la fecha y hora del evento
     * y imprime un registro de auditoría detallado en la consola, con líneas
     * separadoras para mejorar la legibilidad. Incluye todos los detalles del evento:
     * fecha/hora, tipo, material y usuario.
     *
     * @param event El objeto LibraryEvent con toda la información del evento ocurrido
     */
    @Override
    public void update(LibraryEvent event) {
        String formattedDate= event.getDatetime().format(FORMAT);

        System.out.println("-------------------------------------------------");
        System.out.println("[AUDIT]");
        System.out.println("- Date and time: "+formattedDate);
        System.out.println("- Event Type: "+event.getEventType());
        System.out.println("- Material: "+event.getMaterialName());
        System.out.println("- User: "+ event.getNameUser());
        System.out.println("-------------------------------------------------");
    }
}
