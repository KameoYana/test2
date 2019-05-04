package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jane
 */
public class Starter {

    public static void main(String[] args) {

        Starter starter = new Starter();
        starter.init();

    }

    /**
     *
     */
    private void init() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите максимальную грузоподъемность машины");
        String setProperty = System.setProperty("console.encoding", "Cp866");

        int wight = scanner.nextInt();//wight - грузоподъемность машины
        if (wight < 0) {
            System.out.println("Введено неправильное число. Попробуйте снова");
        } else {
            // System.out.println(wight) ;
        }
        String res;
        List<Wight> wightList = new ArrayList<>();
        String[] resM;
        String[] resM_ = null;
        String name;
        Integer wight2, price;
        System.out.println("Введите предметы для перевозки в формате название_предмета/вес/цена");
        Counteiner counteiner;
        List<Counteiner> massPrice = new ArrayList<>();
        List<Counteiner> massWight = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String vvod = br.readLine();
//            System.out.println(vvod);
            resM_ = vvod.split(" ");
        } catch (IOException ex) {
            Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (String res_ : resM_) {

            resM = res_.split("/");
            if (resM.length != 3) {
                System.out.println("Формат записи не соответствует шаблону.");
                continue;
            }
            name = resM[0];
            try {
                wight2 = Integer.valueOf(resM[1]);
                price = Integer.valueOf(resM[2]);
                counteiner = new Counteiner(name, wight2, price); //name- название предмета wight2- вес предмета price- цена предмета

                massPrice.add(counteiner);
            } catch (NumberFormatException e) {
                System.out.println("Введенное значение - не целое число:" + resM[1] + " " + resM[2]);
            }
        }//end while
        Comparator<Counteiner> compareByIdPrice = (Counteiner o1, Counteiner o2) -> o1.getPrice().compareTo(o2.getPrice());
        Collections.sort(massPrice, compareByIdPrice.reversed());
        int massiv = 0;
        boolean flag = true;
        List<Counteiner> l1 = new ArrayList<>();
        l1.addAll(massPrice);
        Collections.sort(l1, compareByIdPrice.reversed());
        Counteiner counteiner_;
        while (!l1.isEmpty()) {
            massiv=0;
            massWight= new ArrayList<>();
            while (!massPrice.isEmpty()) {
//max цена
                counteiner = massPrice.get(0);

                massiv = massiv + counteiner.getWight2();
                if (massiv <= wight) {

                    massWight.add(counteiner);
                } else {
                    massiv = massiv - counteiner.getWight2();
                }
                massPrice.remove(counteiner);
               // ms = ms-counteiner.getWight2();
//            if (massPrice.isEmpty()) {
//                flag = false;
//            }
                Collections.sort(massPrice, compareByIdPrice.reversed());

            }
            counteiner_ = l1.get(0);
            l1.remove(counteiner_);
            massPrice.addAll(l1);
            Collections.sort(massPrice, compareByIdPrice.reversed());
            
            Wight wightW = new Wight();
            wightW.setL1(massWight);
            Integer summ=0;
            for(Counteiner cc :massWight){
            summ +=cc.getPrice();
            }
            wightW.setSumm(summ);
            wightList.add(wightW);
        }
        Comparator<Wight> compareByWightIdPrice = (Wight o1, Wight o2) -> o1.getSumm().compareTo(o2.getSumm());
       
        Collections.sort(wightList, compareByWightIdPrice.reversed());
        massWight=wightList.get(0).getL1();

        
        String resOut = "";
        int sum = 0;
        for (Counteiner c : massWight) {
            // System.out.println(c.getName());
            resOut = resOut + c.getName() + " ";
            sum = sum + c.getPrice();
        }
        resOut = resOut + sum;
        System.out.println(resOut);
    }

}
