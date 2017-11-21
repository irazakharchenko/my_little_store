import java.util.ArrayList;

public class DeliveryNovaPoshta implements DeliveryStrategy {
    public String nameDelivery = "Nova poshta";
    @Override
    public boolean deliver(ArrayList<ComputerGame> cg) {
        return true;
    }
    @Override
    public String toString(){
        return nameDelivery;
    }
}
