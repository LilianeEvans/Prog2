class Madar
{
	void nemrepul()
	{
		System.out.println("Nem repül.");
	}
}

class RepuloMadar extends Madar
{
	void repul()
	{
	System.out.println("Repül.");
	}
}

class Sas extends RepuloMadar{};
class Pingvin extends Madar{};

public class Programszulo
{

public static void main(String args[])
{

Madar madar;
madar=new Madar();
madar.nemrepul();

Sas sas;
sas=new Sas();
sas.repul();

Pingvin pingvin;
pingvin=new Pingvin();
pingvin.nemrepul();

}
}
