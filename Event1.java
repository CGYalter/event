import java.text.ParseException;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.Date;  
import java.util.InputMismatchException;  
import java.util.Scanner;  
  
public class Event {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        Event event = new Event();  
  
        System.out.print("Enter event ID: ");  
        event.setEventID(scanner.nextLine());  
  
        System.out.print("Enter event name: ");  
        event.setEventName(scanner.nextLine());  
  
        System.out.print("Enter event venue: ");  
        event.setEventVenue(scanner.nextLine());  
  
System.out.print("Enter event date (format: yyyy-MM-dd): ");  
String dateString = scanner.nextLine();  
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
try {  
            event.setEventDate(dateFormat.parse(dateString));  
        } catch (ParseException e) {  
            System.out.println("Invalid date format. Please try again.");  
            return;  
        }  
  
        System.out.println("Enter the names of the attendees (enter 'done' to finish):");  
        while (true) {  
            String name = scanner.nextLine();  
            if (name.equalsIgnoreCase("done")) {  
                break;  
            }  
            event.addAttendee(name);  
        }  
  
        event.organizeEvent();  
    }  
}  
  
class Event {  
    private String eventID;  
    private String eventName;  
    private String eventVenue;  
    private Date eventDate;  
    private ArrayList<String> eventAttendees;  
  
    public Event() {  
        eventAttendees = new ArrayList<>();  
    }  
  
    public String getEventID() {  
        return eventID;  
    }  
  
    public void setEventID(String eventID) {  
        this.eventID = eventID;  
    }  
  
    public String getEventName() {  
        return eventName;  
    }  
  
    public void setEventName(String eventName) {  
        this.eventName = eventName;  
    }  
  
    public String getEventVenue() {  
        return eventVenue;  
    }  
  
    public void setEventVenue(String eventVenue) {  
        this.eventVenue = eventVenue;  
    }  
  
    public Date getEventDate() {  
        return eventDate;  
    }  
  
    public void setEventDate(Date eventDate) {  
        this.eventDate = eventDate;  
    }  
  
    public ArrayList<String> getEventAttendees() {  
        return eventAttendees;  
    }  
  
    public void addAttendee(String name) {  
        eventAttendees.add(name);  
    }  
  
    public void removeAttendee(String name) {  
        eventAttendees.remove(name);  
    }  
  
    public void updateAttendee(String oldName, String newName) {  
        int index = eventAttendees.indexOf(oldName);  
        if (index != -1) {  
            eventAttendees.set(index, newName);  
        } else {  
            System.out.println("Attendee not found.");  
        }  
    }  
  
    public String findAttendee(String name) {  
        int index = eventAttendees.indexOf(name);  
        if (index != -1) {  
            return eventAttendees.get(index);  
        } else {  
            return "Attendee not found.";  
        }  
    }  
  
    public void organizeEvent() {  
        System.out.println("Event Information:");  
        System.out.println("Event ID: " + eventID);  
        System.out.println("Event Name: " + eventName);  
        System.out.println("Event Venue: " + eventVenue);  
        System.out.println("Event Date: " + eventDate);  
        System.out.println("Total Attendees: " + eventAttendees.size());  
        System.out.println("Attendees:");  
        for (String attendee : eventAttendees) {  
            System.out.println(attendee);  
        }  
    }  
