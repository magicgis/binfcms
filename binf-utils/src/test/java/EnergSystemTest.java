/**
 * Created by wangbin on 2014/12/13.
 */
public class EnergSystemTest {

    public static final int BOX_AMOUNT = 100;

    public static final double INITIAL_ENERGY = 1000;


    public static void main(String[] args){
        EnergySystem eng = new EnergySystem(BOX_AMOUNT,INITIAL_ENERGY);

        for(int i=0;i<BOX_AMOUNT;i++){
            EnergyTransferTask task = new EnergyTransferTask(eng,i,INITIAL_ENERGY);
            Thread t = new Thread(task,"TransferThread_"+i);
            t.start();
        }


    }

}
