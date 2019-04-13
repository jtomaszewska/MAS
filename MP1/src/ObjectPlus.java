import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectPlus {

    /*trwałość +  zarządzanie ekstensją*/

    protected static Map<Class, List<ObjectPlus>> allExtents = new HashMap<>();

    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();
        if(allExtents.containsKey(theClass)) {
            // An extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            // An extent does not exist - create a new one
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }
    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (HashMap) stream.readObject();
    }

    public void destroyObject(){
        if(allExtents.get(this.getClass()).remove(this)){
            System.out.println("Object "+this.toString()+" destroyed");
        }
    }

    public static void logExtensions(){
        for (Class classEntity: allExtents.keySet()) {
            for (ObjectPlus obj : allExtents.get(classEntity)) {
                System.out.println(obj);
            }
        }
    }
}
