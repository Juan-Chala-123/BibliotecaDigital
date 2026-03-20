package observer;

import java.util.List;
import java.util.ArrayList;

/**
 * Clase LibraryEventPublisher que actúa como el publicador (subject) en el patrón Observer.
 * Esta clase es responsable de mantener una lista de observadores interesados en los eventos
 * de la biblioteca digital y notificarlos cuando ocurre un evento. Implementa las operaciones
 * básicas del patrón Observer: agregar observadores, remover observadores y notificar
 * a todos los observadores registrados.
 */
public class LibraryEventPublisher{
    /**
     * Lista de observadores registrados que serán notificados cuando ocurra un evento.
     * Se utiliza una ArrayList para almacenar los objetos que implementan IObserver.
     */
    private List<IObserver> observers= new ArrayList<>();

    /**
     * Agrega un nuevo observador a la lista de observadores.
     * Una vez agregado, el observador recibirá notificaciones de todos los eventos futuros.
     *
     * @param o El objeto observador que implementa IObserver y que se desea registrar
     */
    public void addObserver(IObserver o){
        observers.add(o);
    }

    /**
     * Remueve un observador de la lista de observadores.
     * Después de ser removido, el observador ya no recibirá notificaciones de eventos.
     *
     * @param o El objeto observador que se desea remover de la lista
     */
    public void removeObserver(IObserver o){
        observers.remove(o);
    }

    /**
     * Notifica a todos los observadores registrados sobre la ocurrencia de un evento.
     * Este método itera a través de la lista de observadores y llama al método update()
     * de cada uno, pasando el evento como parámetro.
     *
     * @param event El objeto LibraryEvent que contiene la información del evento ocurrido
     */
    public void notifyObserver(LibraryEvent event){
        for(IObserver o: observers){
            o.update(event);
        }
    }

}