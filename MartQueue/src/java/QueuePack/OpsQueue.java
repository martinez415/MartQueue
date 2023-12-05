package QueuePack;
import java.util.ArrayList;

public class OpsQueue {
    
    protected static ArrayList<String> queue = new ArrayList<>();
    protected static int counter = 0;
    
    public static int linearSearch(ArrayList <String> arrList, String searchKey) {
        for(int i = 0; i < arrList.size(); i++) {
            if(arrList.get(i).equals(searchKey)) {
                return i;
            }
        }
        return -1;
    }
    
    public static String push(String customername) {
        if(customername.equals("")) {
            return "Input valid customer name.";
        } else {          
            queue.add(customername);          
            return customername + " added to queue.";
        }
    }
      
    public static String getLiveQueueContent() {
        StringBuilder sb = new StringBuilder();
        for (String name : queue) {
            sb.append(name).append("\n");
        }
        return sb.toString();
    }
 
    public static String enqueue(String customername) {
        int index = linearSearch(queue, customername);
        int rear = queue.size();
        if(index != -1) {            
            queue.add(rear, customername);
            queue.remove(index);
            return customername + " added to end of queue.";
        } else {
            return "Invalid customer name.";
        } 
    }
    
    public static String dequeue(String customername) {
        int index = linearSearch(queue, customername);
        if(index != -1) {
            queue.remove(index);
            counter++;
            return customername + " proceed for processing.";
        } else {
            return "Invalid customer name.";
        }      
    }
    
    public static String isEmpty() {
        if (queue.size() == 0) {
            return "Queue is empty.";
        } else {
            return "Queue is not empty.";
        }
    }
    
    public static String size() {
        if(queue.size() > 0) {
            return "Queue is populated with " + queue.size() + " customer(s).";
        } else {
            return "Queue is empty.";
        }
    }
    
    public static String peek(String customername) {
        int index = linearSearch(queue, customername);
        if(index != -1) {
            return customername + " located in queue position #" + (index+1);
        } else {
            return "Invalid customer name.";
        }
    }
    
    public static String serviced() {
        return "Number of customer serviced: " + counter;
    }
    
    public static String clear() {
        queue.clear();
        counter = 0;
        return "Queue successfully cleared.";
    }
    
}
