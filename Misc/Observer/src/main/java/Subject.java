import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private List<String> messages = new LinkedList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void addMessage(String messsage){
        messages.add(messsage);
        notifyAllObservers(messsage);
    }

    private void notifyAllObservers(String message){
        for (Observer observer :
                observers) {
            observer.update(message);
        }
    }
}
