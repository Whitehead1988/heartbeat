package com.capgemini.heartbeat;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReportCreator {


	private static final String separator = ";";
	private static final String endOfLine = "\n";
	private static final String fileHeader = "timestamp; Jenkins|Grid; Status";
	public String pathWithCsvFile = "";// default
	File file = null;
	FileWriter writeToCsv = null;

	public CSVReportCreator() {

	};

	public CSVReportCreator(String path) {
		this.pathWithCsvFile = path;
	};

	public void createReport(ArrayList<TaskResult> results) {
		//@SuppressWarnings("unchecked")
		//ArrayList<TaskResult> listResults = (ArrayList<TaskResult>) results;

		try {
			file = new File(pathWithCsvFile);
			if (!file.exists()) {
				file.createNewFile();
			}
			writeToCsv = new FileWriter(file.getAbsolutePath(), true);
			writeToCsv.append(fileHeader);

			for (int i = 0; i < results.size(); i++) {
				writeToCsv.append(results.get(i).getTimestamp().toString());
				writeToCsv.append(separator);
				writeToCsv.append(results.get(i).getName());
				writeToCsv.append(separator);
				writeToCsv.append(results.get(i).getStatus());
				writeToCsv.append(endOfLine);
			}
		} catch (IOException e) {
			System.out.println("File open error! ");
			e.printStackTrace();
		} finally {
			try {
				writeToCsv.flush();
				if (writeToCsv != null) {
					writeToCsv.close();
				}
			} catch (IOException e) {
				System.out.println("File flush or close error! ");
				e.printStackTrace();
			}
		}
	}

}
