package p20241113_01_resume;

public class Ghepardo extends Mammifero implements Must, Req, Comparable<Ghepardo>{

	private Double speed; 

	public Ghepardo(Integer freqResp, Integer freqCardio, Double speed) {
		super(freqResp, freqCardio);
		this.speed = speed;
	}

	public Ghepardo() {
		super();
	}
	
	@Override
	public String Verso() {
		// TODO Auto-generated method stub
		return "Roar";
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	
	@Override
	public String toString() {
		return "\nGhepardo [speed=" + speed + ", toString()=" + super.toString() + "]";
	}

	@Override
	public String GetClassName() {
		// TODO Auto-generated method stub
		return "Ghepardo";
	}

	@Override
	public String GetVersion() {
		// TODO Auto-generated method stub
		return "1.0";
	}

	@Override
	public String GetSerial() {
		// TODO Auto-generated method stub
		return "AI48";
	}

	@Override
	public int compareTo(Ghepardo o) {
		int ret = speed.compareTo(o.speed);
		if(ret == 0) {
			ret = getFreqCardio().compareTo(o.getFreqCardio());
			if(ret == 0) {
				ret = getFreqResp().compareTo(o.getFreqResp());
			}
		}
		return ret;
	}
	
}
