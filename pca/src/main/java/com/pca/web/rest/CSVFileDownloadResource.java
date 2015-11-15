package com.pca.web.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.pca.domain.Player;
import com.pca.service.PlayerService;

@RestController
@RequestMapping(value = "/app")
public class CSVFileDownloadResource {
   
	@Autowired
	PlayerService playerService;
	
	@RequestMapping(value = "/rest/downloadCSVByName")
	public void downloadCSVByName(HttpServletResponse response) throws IOException {

		String csvFileName = "player.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);		 	 

		Collection<Player> listOfPlayer = playerService.findAll();
		// uses the Super CSV API to generate CSV data from the model data 
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "firstName", "lastName","positionInTeam"};

		csvWriter.writeHeader(header);

		for (Player players : listOfPlayer) {
			players.getFirstName();
			players.getLastName();
			players.getPositionInTeam();
			csvWriter.write(players, header);
		}

		csvWriter.close();
	}
	
	@RequestMapping(value = "/rest/downloadCSVByShirtNumber")
	public void downloadCSVByShirtNUmber(HttpServletResponse response) throws IOException {

		String csvFileName = "player.csv";

		response.setContentType("text/csv");

		// creates mock data
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				csvFileName);
		response.setHeader(headerKey, headerValue);		 	 

		Collection<Player> listOfPlayer = playerService.findAll();
		// uses the Super CSV API to generate CSV data from the model data 
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(),
				CsvPreference.STANDARD_PREFERENCE);

		String[] header = { "shirtNumber","positionInTeam"};

		csvWriter.writeHeader(header);

		for (Player players : listOfPlayer) {
			players.getShirtNumber();
			players.getPositionInTeam();
			csvWriter.write(players, header);
		}

		csvWriter.close();
	}
	
}
