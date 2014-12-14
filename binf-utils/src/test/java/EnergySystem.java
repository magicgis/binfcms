/**
 * Created by wangbin on 2014/12/13.
 */
public class EnergySystem {


    private final double[] energyBoxes;


    public EnergySystem(int n,double initialEnergy){
        energyBoxes = new double[n];
        for(int i=0;i<energyBoxes.length;i++){
            energyBoxes[i] = initialEnergy;
        }
    }


    public void transfer(int from,int to,double amount){

        while (energyBoxes[from]<amount){
            return;
        }

        System.out.print(Thread.currentThread().getName());
        energyBoxes[from] -= amount;
        System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
        energyBoxes[to] += amount;
        System.out.printf(" 能量总和：%10.2f%n", getTotalEnergies());
        //唤醒所有在lockObj对象上等待的线程
    }




    public double getTotalEnergies(){
        double sum = 0;
        for(double amount :energyBoxes)
            sum+=amount;
        return sum;
    }

    public int getBoxAmount(){
        return energyBoxes.length;
    }


}
