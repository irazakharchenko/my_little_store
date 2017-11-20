public class CashStrategy implements PaymentStrategy {

    public String namePayment = "Cash";
    public boolean pay(double pay){
        return true;
    }

    @Override
    public String toString(){
        return namePayment;
    }
}
