#include <iostream>

class Madar {};

class Pingvin : public Madar
{
	public:
		virtual void nemrepul() {std::cout<<"Nem repül.";}
};

int main (int argc, char **argv)
{
	Madar *madar=new Pingvin();
	//meghívja a szülő sétál metódusát
	madar->nemrepul();
}
