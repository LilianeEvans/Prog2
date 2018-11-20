class Madar {};

class Program {
public:
     void fgv ( Madar &madar ) {
          //a madár nem tud repülni
     }
};

class RepuloMadar : public Madar {
public:
     virtual void repul() {};
};

class Sas : public RepuloMadar
{};

class Pingvin : public Madar 
{};

int main ( int argc, char **argv )
{
     Program program;
     Madar madar;
     program.fgv ( madar );

     Sas sas;
     program.fgv ( sas );

     Pingvin pingvin;
     program.fgv ( pingvin );

}
