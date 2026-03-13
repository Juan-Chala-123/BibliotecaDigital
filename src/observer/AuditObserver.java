
package observer;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author JUAN
 */
public class AuditObserver implements IObserver{
    private static final DateTimeFormatter FORMAT= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
