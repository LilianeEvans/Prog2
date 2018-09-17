public class PolárGenerátor {
	boolean logikai = true;
	double valos;

	public PolárGenerátor(){
		logikai = true;
	}

	public double következő(){
		if(logikai){
			double u1, u2, v1, v2, w;
			do {
				u1=Math.random();
				u2=Math.random();
				v1=2*u1-1;
				v2=2*u2-1;
				w=v1*v1+v2*v2;
			} while(w>1);
			double r=Math.sqrt((-2*Math.log(w))/w);
			valos=r*v2;
			logikai=!logikai;
			return r*v1;
		} else {
			logikai=!logikai;
			return valos;
		}


	}

	public static void main(String[] args){
		PolárGenerátor g=new PolárGenerátor ();
		for(int i=0; i<10; ++i){
			System.out.println(g.következő());
		}

	}

}
