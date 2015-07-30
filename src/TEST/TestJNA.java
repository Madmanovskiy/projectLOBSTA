package TEST;


import com.sun.jna.Library;
import com.sun.jna.Native;

public class TestJNA {
    public interface NinjaTrader extends Library {
        NinjaTrader INSTANCE = (NinjaTrader) Native.loadLibrary("NtDirect", NinjaTrader.class);

        int Connected(int showMessage);

        double CashValue(String account);

        int SubscribeMarketData(String instrument);

        double MarketData(String instrument, int type);

        int UnsubscribeMarketData(String instrument);

        int TearDown();
    }


    public static void main(String[] args) {
//        int i = NinjaTrader.INSTANCE.Connected(1);
//        System.out.println(i);

        double d = NinjaTrader.INSTANCE.CashValue("Sim101");
        System.out.println(d);

        System.out.println(NinjaTrader.INSTANCE.SubscribeMarketData("CL 09-15"));

        System.out.println();
        System.out.println();
        System.out.println();

        int count = 0;
        while (count != 100) {
            double bid = NinjaTrader.INSTANCE.MarketData("CL 09-15", 1);
            double ask = NinjaTrader.INSTANCE.MarketData("CL 09-15", 2);
            System.out.println("ask  = " + ask);
            System.out.println("bid  = " + bid);
            try{
                Thread.sleep(100);
                count++;
            } catch (InterruptedException e) {
                System.out.println(NinjaTrader.INSTANCE.UnsubscribeMarketData("CL 09-15"));
                e.printStackTrace();
            } catch (Throwable e) {
                System.out.println(NinjaTrader.INSTANCE.UnsubscribeMarketData("CL 09-15"));
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(NinjaTrader.INSTANCE.UnsubscribeMarketData("CL 09-15"));

        int j = NinjaTrader.INSTANCE.TearDown();
        System.out.println(j);


    }

}
