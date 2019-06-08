import java.text.DecimalFormat;
import java.util.EnumSet;

import static jdk.nashorn.internal.objects.NativeMath.round;

public class Employee extends User {

    private EnumSet<PositionType> function = EnumSet.<PositionType>of(PositionType.EMPLOYEE);

    public Employee(String firstName, String lastName, String email, PositionType positionType) {
        super(firstName, lastName, email);
        this.addFunction(positionType);
    }

    public void addFunction(PositionType positionType){
        function.add(positionType);
    }

    public void removeFunction(PositionType positionType){
        if(!this.function.contains(positionType)){
            throw new RuntimeException("Can't remove unassigned function");
        }
        function.remove(positionType);
    }

    public double getBonusRate(){
        if(this.function.size() == 0){
            return 0;
        }
        double rate = this.function.size()*0.20;
        return rate;
    }
}
