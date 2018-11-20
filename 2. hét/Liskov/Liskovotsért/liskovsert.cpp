class Madar {
public:
     virtual void repul() {};
};

class Program {
public:
     void fgv ( Madar &madar ) {
          madar.repul();
     }
};

//extend a javaban
class Sas : public Madar
{};

class Pingvin : public Madar //a pingvin tud repülni
{};

int main ( int argc, char **argv )
{
     Program program;
     Madar madar;
     program.fgv ( madar );

     Sas sas;
     program.fgv ( sas );

     Pingvin pingvin;
     program.fgv ( pingvin ); // sérül a Liskov, mert a pingvin nem tud repülni, mégis az hívódik meg
