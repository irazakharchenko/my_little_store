import java.util.ArrayList;

public class DeliveryDHL implements DeliveryStrategy {
    public String nameDelivery = "DHL";
    @Override
    public boolean deliver(ArrayList<ComputerGame> cg) {
        return true;
    }
    @Override
    public String toString(){
        return nameDelivery;
    }
}
