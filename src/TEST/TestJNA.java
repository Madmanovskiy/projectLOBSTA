package TEST;


import com.sun.jna.Library;
import com.sun.jna.Native;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        SimpleDateFormat dfDateAndTime = new SimpleDateFormat("HH:mm:ss.S");

        double d = NinjaTrader.INSTANCE.CashValue("Sim101");
        System.out.println(d);

        System.out.println(NinjaTrader.INSTANCE.SubscribeMarketData("CL 09-15"));

        System.out.println();

        int count = 0;
        double tempBid = 0;
        double tempAsk = 0;
        while (count != 1000) {
            double bid = NinjaTrader.INSTANCE.MarketData("CL 09-15", 1);
            double ask = NinjaTrader.INSTANCE.MarketData("CL 09-15", 2);

            if (ask != tempAsk) {
                tempAsk = ask;
                System.out.println("ask  = " + ask + "   time:" + dfDateAndTime.format(new Date()) + " | " + "bid  = " + bid + "   time:" + dfDateAndTime.format(new Date()));
            }

            if (bid != tempBid) {
                tempBid = bid;
                System.out.println("ask  = " + ask + "   time:" + dfDateAndTime.format(new Date()) + " | " + "bid  = " + bid + "   time:" + dfDateAndTime.format(new Date()));
            }
//            try{
//                Thread.sleep(100);
//                count++;
//            } catch (InterruptedException e) {
//                System.out.println(NinjaTrader.INSTANCE.UnsubscribeMarketData("CL 09-15"));
//                e.printStackTrace();
//            } catch (Throwable e) {
//                System.out.println(NinjaTrader.INSTANCE.UnsubscribeMarketData("CL 09-15"));
//            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(NinjaTrader.INSTANCE.UnsubscribeMarketData("CL 09-15"));

        int j = NinjaTrader.INSTANCE.TearDown();
        System.out.println(j);


    }

}
