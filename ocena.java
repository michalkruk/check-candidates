
import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import net.sourceforge.jFuzzyLogic.Gpr;

import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

import net.sourceforge.jFuzzyLogic.rule.Variable; 


public class ocena {

	public static void main(String[] args) throws Exception {
		// Load from 'FCL' file
		String fileName = "./ocena.fcl";
		FIS fis = FIS.load(fileName, true);
		if( fis == null ) { 
			System.err.println("Nie moge zaladowc pliku: '" + fileName + "'");
			return;
		}

		// Pokazuje reguly
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
	        JFuzzyChart.get().chart(functionBlock);	

		// Ustawia wejscia
		fis.setVariable("wiek", 22);
		fis.setVariable("iq", 120);
        fis.setVariable("doswiadczenie", 1);

		// Wylicza zbiory rozmyte
		fis.evaluate();

		// Ustawia wyjscia
		Variable ocena = functionBlock.getVariable("ocena");		

		// Pokazuje wykres zmiennych wyjsciowych

		JFuzzyChart.get().chart(ocena, ocena.getDefuzzifier(), true);
		
		// Drukuje reguly
		System.out.println(fis);
		System.out.println("Ocena:" + fis.getVariable("ocena").getValue()); 
	}
}
