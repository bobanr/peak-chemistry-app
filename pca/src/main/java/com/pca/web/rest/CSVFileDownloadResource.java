package com.pca.web.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.pca.domain.Player;

@RestController
@RequestMapping(value = "/app")
public class CSVFileDownloadResource {

	@RequestMapping(value = "/rest/downloadCSV")
	public void downloadCSV(HttpServletResponse response) throws IOException {

		String csvFileName = "player.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);

		
 	  Player player = new Player("velimir", "dzamto", "macedonian", "skopje", "macedonia", "defender");
 	  Player player1 = new Player("velimir", "dzamtoski", "macedonian", "ohrid", "macedonia", "defender");
 	  Player player2 = new Player("vele", "dzamto", "macedonian", "bitola", "macedonia", "atacker");
 	  Player player3 = new Player("vladimir", "dzamto", "macedonian", "resen", "macedonia", "midfelder");
 	  Player player4 = new Player("kiril", "dzamto", "macedonian", "kicevo", "macedonia", "atacker");
 	  
		
		List<Player> listOfPlayer = Arrays.asList(player, player1, player2, player3,player4);

		// uses the Super CSV API to generate CSV data from the model data 
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "firstName", "lastName", "nationality", "bodyColor",
				"placeOfBorn", "placeOfBorn"};

		csvWriter.writeHeader(header);

		for (Player players : listOfPlayer) {
			csvWriter.write(players, header);
		}

		csvWriter.close();
	}
	
}
