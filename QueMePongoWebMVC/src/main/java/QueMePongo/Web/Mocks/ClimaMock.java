package QueMePongo.Web.Mocks;

import java.time.LocalDateTime;

public class ClimaMock {
	
	public int GetTemperaturaMaxima(LocalDateTime fecha ) {
		
		if((fecha.getYear() == 2020) && (fecha.getMonth().equals(2))) {
			if(fecha.getDayOfMonth() == 10) {
				return 30;
				
			}
			else if(fecha.getDayOfMonth() == 20) {
				
				return 28;
			}}
				return 25;
			
		}
		
		public int GetTemperaturaMinima(LocalDateTime fecha ) {
			
			if((fecha.getYear() == 2020) && (fecha.getMonth().equals(2))) {
				if(fecha.getDayOfMonth() == 10) {
					return 25;
					
				}
				else if(fecha.getDayOfMonth() == 20) {
					
					return 24;
				}}
				
					return 23;
				
			
			
		
	}

}
