import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class ObserverImpl implements Observer{
    private List<String> messages = new LinkedList<>();
    @Override
    public void update(String string) {
        messages.add(string);
        System.out.println(string);
    }
}
