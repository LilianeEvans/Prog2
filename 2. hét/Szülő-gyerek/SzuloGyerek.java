class Madar
{}

class Pingvin extends Madar
{
	public void nemrepul()
		{
		System.out.println("Nem repül.");
		}
}

public class SzuloGyerek
{
	public static void main(String args[])
	{
		Madar madar=new Pingvin();
		madar.nemrepul();

	}
}
