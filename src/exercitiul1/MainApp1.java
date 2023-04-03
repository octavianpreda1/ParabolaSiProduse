package exercitiul1;
import java.util.ArrayList;
import java.util.List;

public class MainApp1 {
    public static void main(String[] args) {

       List<Parabola>  parab= new ArrayList<>();
       parab.add(new Parabola(8,5,3));
       parab.add(new Parabola(6,5,22));

       for(int i=0;i< parab.size();i++)
       {
           System.out.println(parab.get(i));
       }

       Parabola.SMijl(parab.get(0),parab.get(1));


    }
}
