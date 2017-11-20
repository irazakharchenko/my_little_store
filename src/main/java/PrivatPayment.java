public class PrivatPayment implements PaymentStrategy{

    public String namePayment = "Privat 24";
    public boolean pay(double pay){
        return true;
    }

    @Override
    public String toString(){
        return namePayment;
    }
}
