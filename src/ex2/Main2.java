package ex2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        List<Produs> prod= new ArrayList<>();

        Scanner sc = new Scanner(new File("src/ex2/produse.csv"));
        sc.useDelimiter("[,\n]");

        while (sc.hasNext()) {
            String nume = sc.next();
            float pret = sc.nextFloat();
            int cant = sc.nextInt();
            LocalDate l = LocalDate.parse(sc.next());

            Produs p = new Produs(nume, pret, cant, l);
            prod.add(p);
            }
        sc.close();

        Scanner s= new Scanner(System.in);
        int opt=-1;
        while(opt!=0)
        {
            System.out.println("\n--------MENIU--------");
            System.out.println("1.Afisarea produselor");
            System.out.println("2.Afisarea produselor expirate");
            System.out.println("3.Vanzarea unui produs");
            System.out.println("4.Afisarea produselor cu pret minim");
            System.out.println("5.Salvarea produselor care au mai\nputin decat o anumita cantitate.");
            System.out.println("0.Iesire");
            System.out.println("---------------------");
            System.out.println("\n Optiunea dvs:");
            opt=s.nextInt();

            switch (opt) {
                case 0:
                    System.out.println("EXIT");
                    break;
                case 1:
                    for(Produs P:prod)
                        System.out.println(P);
                    Thread.sleep(1500);
                    break;
                case 2:
                    for(Produs P:prod)
                    {
                        if(P.getData_expirarii().isBefore(LocalDate.now()))
                            System.out.println(P);
                    }
                    Thread.sleep(1500);
                    break;

                case 3:
                    for(Produs P:prod)
                        System.out.println(P.getDenumire());
                    System.out.println("Dati numele produsului pe care doriti sa il vindeti:");
                    String produs=s.next();
                    for(Produs P:prod)
                    {
                        if(produs.equals(P.getDenumire()))
                        {
                            System.out.println("Dati cantitatea de vandut:");
                            int c=s.nextInt();
                            if(c<=P.getCantitate())
                            {
                                P.setCantitate(P.getCantitate()-c);
                                Produs.incasari=c*P.getPret();
                                System.out.println("VANDUT!!!");
                                Thread.sleep(1500);
                            }
                            else {
                                System.out.println("Cantitate indisponibila in stoc!");
                                Thread.sleep(1500);
                            }
                            if(P.getCantitate()==0)
                                prod.remove(P);
                            break;
                        }
                    }
                    break;
                case 4:
                    for(Produs P:prod)
                    {

                        if(P.getPret()==min(prod))
                            System.out.println(P);
                    }
                    Thread.sleep(1500);
                    break;
                case 5:
                    File path = new File("src/ex2/iesire.txt");
                    FileWriter wr= new FileWriter(path);
                    Scanner scn=new Scanner(System.in);
                    System.out.println("Dati cantitatea:");
                    int cant=scn.nextInt();

                    for (Produs P:prod)
                    {
                        if(P.getCantitate()<cant)
                            wr.write(P.toString()+"\n");
                    }
                    wr.flush();
                    wr.close();

                    break;



                default:
                    System.out.println("Optiune invalida! Incercati din nou.");
                    Thread.sleep(2000);
                    break;
            }

        }
        sc.close();
        s.close();


    }

    public static float min(List<Produs> list)
    {
        float min= Float.MAX_VALUE;
        for(Produs p:list)
        {
            if(p.getPret()<min)
                min=p.getPret();
        }
        return min;
    }

}
