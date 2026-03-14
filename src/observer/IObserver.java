package observer;

/**
 * Interfaz IObserver que define el contrato para los observadores en el patrón Observer.
 * Los observadores implementan esta interfaz para recibir notificaciones de eventos
 * ocurridos en el sistema de biblioteca digital. El patrón Observer permite que múltiples
 * objetos (observadores) sean notificados automáticamente cuando ocurre un cambio en
 * el estado de otro objeto (el publicador).
 */
public interface IObserver {
    /**
     * Método que se llama cuando ocurre un evento en el sistema.
     * Los observadores concretos deben implementar este método para definir
     * cómo responder a los eventos de la biblioteca.
     *
     * @param event El objeto LibraryEvent que contiene la información del evento
     *              ocurrido, incluyendo tipo de evento, material involucrado,
     *              usuario y fecha/hora.
     */
    void update(LibraryEvent event);
}