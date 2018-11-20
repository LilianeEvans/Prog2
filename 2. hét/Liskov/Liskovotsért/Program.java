class Madar
{
	void repul(){};
}

class Sas extends Madar{};

class Pingvin extends Madar{};

public class Program
{

public static void main(String args[])
{
Madar madar;
madar=new Madar();
madar.repul();

Sas sas;
sas=new Sas();
sas.repul();

Pingvin pingvin;
pingvin=new Pingvin();
pingvin.repul();

System.out.println("Lefutott.");

}
}



























