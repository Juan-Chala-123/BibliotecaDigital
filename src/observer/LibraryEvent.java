
package observer;
import java.time.LocalDateTime;
/**
 *
 * @author JUAN
 */
public class LibraryEvent {
    private String eventType;
    private String materialName;
    private String nameUser;
    private LocalDateTime datetime;
    
    public LibraryEvent(String evenType, String materialName, String nameUser, LocalDateTime datetime){
        this.eventType= eventType;
        this.materialName= materialName;
        this.nameUser= nameUser;
        this.datetime= datetime;
    }

    public String getEventType() {
        return eventType;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getNameUser() {
        return nameUser;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }
    
    
}
