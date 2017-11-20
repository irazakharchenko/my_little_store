import java.util.ArrayList;

public class DeliveryNovaPoshta implements DeliveryStrategy {
    @Override
    public boolean deliver(ArrayList<ComputerGame> cg) {
        return true;
    }
}
