package brd. filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileLevelRejection {
	static ArrayList<String> listoffileds = new ArrayList<String>();
	static ArrayList<Boolean> IncorrectRecords = new ArrayList<>();
	static ArrayList<Boolean> CorrectedRecords = new ArrayList<>();
//	private static String String;
	static String[] SeperatedFieldValueStorage = new String[16];

//	public static void main(String[] args) throws Exception {
	
	public static void mains(InputStream fileContent,String file) throws Exception {
//		String[] DataBaseConnection = new String[16];
		BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
//		File reader used to read the file from the folder
//	String file = "File1.txt";
		if (file.endsWith(".txt")) {
			System.out.println("The file format is in '.txt' format");
			FileReader filereader = new FileReader(file);
//		Buffered reader is kind of scanner 
			BufferedReader bufferreader = new BufferedReader(filereader);
			String addSpecialChar;
			while ((addSpecialChar = bufferreader.readLine()) != null) {
				addSpecialChar += "~";
				listoffileds.add(addSpecialChar);
			}
			
			int count = 0;
			for (int records = 0; records < listoffileds.size(); records++) {
				String str = listoffileds.get(records);
				String[] withoutSPchar = str.split("(?<=~)");
				for (int clearRecords = 0; clearRecords < 16; clearRecords++) {
					SeperatedFieldValueStorage[clearRecords] = withoutSPchar[clearRecords].substring(0,
							withoutSPchar[clearRecords].lastIndexOf("~"));

				}
				Boolean ValidationResult = Fieldvalidator(SeperatedFieldValueStorage);
				if (ValidationResult == true) {
					CorrectedRecords.add(ValidationResult);
				}
				if (ValidationResult == false) {
					IncorrectRecords.add(ValidationResult);
				}

			}
		}

		Rejection(SeperatedFieldValueStorage);
	}

	public static void Rejection(String[] DataBaseConnection) {
		if (IncorrectRecords.contains(false)) {
			System.out.println("err");
		} else {
			int count = 0;
			for (int records = 0; records < listoffileds.size(); records++) {
				String str = listoffileds.get(records);
				String[] withoutSPchar = str.split("(?<=~)");
				for (int clearRecords = 0; clearRecords < 16; clearRecords++) {
					DataBaseConnection[clearRecords] = withoutSPchar[clearRecords].substring(0,
							withoutSPchar[clearRecords].lastIndexOf("~"));

				}
				if (Fieldvalidator(DataBaseConnection) == true) {
					database.getConnection(Integer.toString(count += 1), DataBaseConnection[0], DataBaseConnection[1],
							DataBaseConnection[2], DataBaseConnection[3], DataBaseConnection[4], DataBaseConnection[5],
							DataBaseConnection[6], DataBaseConnection[7], DataBaseConnection[8], DataBaseConnection[9],
							DataBaseConnection[10], DataBaseConnection[11], DataBaseConnection[12],
							DataBaseConnection[13], DataBaseConnection[14], DataBaseConnection[15]);
				} else {
					System.out.println("Valiation error");
				}
			}
		}
	}

	public static boolean Fieldvalidator(String[] FieldValue) {
		boolean customernameRESULT = customername(FieldValue[1]);
		boolean pincodeRESULT = pincode(FieldValue[4]);
		boolean emailValidationRESULT = emailValidation(FieldValue[5]);
		boolean recordStatusValidatorRESULT = recordStatusValidator(FieldValue[8]);
		boolean Active_Inactive_FlagRESULT = Active_Inactive_Flag(FieldValue[9]);
		if (customernameRESULT && pincodeRESULT && emailValidationRESULT && recordStatusValidatorRESULT
				&& Active_Inactive_FlagRESULT) {
			return true;
		}
		return false;
		
	}
	public static boolean customername(String txt) {
		String regx = "[a-zA-Z]+\\.?";
		Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
		if (pattern.matcher(txt).find()) {
			return true;
		}
		return false;
	}
	public static boolean pincode(String pcode) {
		if (pcode.length() == 6) {
		
			return true;
		}
		return false;
	}
	public static boolean emailValidation(String email) {
		if (email.contains("@") || email.contains(".")) {
			if (!email.contains(" ")) {
				return true;
			}
		}
		return false;
	}
	public static boolean recordStatusValidator(String RecordStatus) {
		if (RecordStatus.contains("N") || RecordStatus.contains("M") || RecordStatus.contains("D")
				|| RecordStatus.contains("A") || RecordStatus.contains("R")) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean Active_Inactive_Flag(String Active_Inactive) {
		if (Active_Inactive.contains("A") || Active_Inactive.contains("I")) {
			return true;
		} else {
			return false;
		}
	}


}




//if(Rejectioncontol.equals(record))
//{
//	ReadFromFile.mains(fileContent, fileName);
//}
//else
//{
//	FileLevelRejection.mains(fileContent, fileName);
//}
//}
//customername(str1[1].substring(0, str1[1].lastIndexOf("~")));
//pincode(str1[4].substring(0, str1[4].lastIndexOf("~")));
//recordStatusValidator(str1[5].substring(0, str1[5].lastIndexOf("~")));
//Active_Inactive_Flag(str1[9].substring(0, str1[9].lastIndexOf("~")));