
class Multimeter {
	
	private int intRealMM;
	private final int maxMM = 500;
	private int txtMMvalue;
	
	public void setMM(int inputMM)
	{
		if (inputMM <= maxMM)
		{
			intRealMM = inputMM;
			System.out.println("intRealMM:" + intRealMM);
				
		}
	}
	
	public int getMM()
	{
		return intRealMM;
	}
	
	
}
