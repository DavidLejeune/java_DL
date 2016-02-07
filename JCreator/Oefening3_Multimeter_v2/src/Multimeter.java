
class Multimeter {
	private int actueleMeterstand;
	private final int maximaleMeterstand = 300;
	private int meterstandTekstvakinhoud;
		
		public void setMeterstand(int inputMeterstand)
		{
			if (inputMeterstand <= maximaleMeterstand && inputMeterstand >= 0)
			{
				actueleMeterstand = inputMeterstand;
			}
		}
		
		public int getMeterstand()
		{
				return actueleMeterstand;
		}
		
}
