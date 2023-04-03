package exercitiul1;

class Punct {
    private  int x;
    private  int y;

    public Punct(int x, int y)
    {
        super();
        this.x=x;
        this.y=y;

    }

    public int X()
    {
        return x;
    }

    public int Y()
    {
        return y;
    }
}

public class Parabola {
    private  final int a;
    private final int b;
    private final int c;

    public Parabola(int a, int b, int c)
    {
        super();
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public Parabola(Parabola p)
    {
        this(p.a,p.b,p.c);
    }

    public String toString()
    {
        return "f(x) = " + a +"x^2 + " + b +" x + "+c;
    }

    public Punct c_varf()
    {
        int x_vf=-(b/(2*a));
        int y_vf=(-(b*b)+4*a*c)/(4*a);
        Punct vf= new Punct(x_vf,y_vf);
        return vf;
    }

    public static void SMijl(Parabola p1, Parabola p2)
    {
        Punct v1=p1.c_varf();
        Punct v2=p2.c_varf();
        System.out.println("Coorodonatele segmentului sunt: ( "+ (v1.X()+v2.Y())/2 + "," + (v1.Y()+v2.X())/2 +")");
    }


}
