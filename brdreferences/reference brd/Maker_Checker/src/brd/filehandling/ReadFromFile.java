package brd.filehandling;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromFile {
	static ArrayList<String> listoffileds = new ArrayList<String>();
	private static String String;

	public static void mains(InputStream fileContent,String file) throws Exception {

//		File reader used to read the file from the folder
		//String file = "File2.txt";
		  BufferedReader reader = new BufferedReader(new InputStreamReader(fileContent));
		if (file.endsWith(".txt")) {

			System.out.println("The file format is in '.txt' format");
//			FileReader fl = new FileReader(file);
//			Buffered reader is kind of scanner 
//			BufferedReader bf = new BufferedReader(fl);

			String string;
			while ((string = reader.readLine()) != null) {
				string += "~";
				listoffileds.add(string);
			}
			String[] DataBaseConnection = new String[16];
			int count = 0;
			for (int i = 0; i < listoffileds.size(); i++) {
				String str = listoffileds.get(i);
				String[] str1 = str.split("(?<=~)");
				for (int j = 0; j < 16; j++) {

					DataBaseConnection[j] = str1[j].substring(0, str1[j].lastIndexOf("~"));
//					System.out.println(DataBaseConnection[j]);
//					System.out.println(DataBaseConnection[5]);
				}
				Boolean b = validator(DataBaseConnection);
//				System.out.println(b);
				if (validator(DataBaseConnection) == true) {
					
					database.getConnection(Integer.toString(count += 1), DataBaseConnection[0], DataBaseConnection[1],
							DataBaseConnection[2], DataBaseConnection[3], DataBaseConnection[4], DataBaseConnection[5],
							DataBaseConnection[6], DataBaseConnection[7], DataBaseConnection[8], DataBaseConnection[9],
							DataBaseConnection[10], DataBaseConnection[11], DataBaseConnection[12],
							DataBaseConnection[13], DataBaseConnection[14], DataBaseConnection[15]);
				}
				else {
					System.out.println("Valiation error");
				}
			}
		} else {
			System.err.println("The file is in the worng format");
		}
	}
		public static boolean validator(String[] DataBaseConnection) {
		boolean customernameRESULT = customername(DataBaseConnection[1]);
		boolean pincodeRESULT = pincode(DataBaseConnection[4]);
		boolean emailValidationRESULT = emailValidation(DataBaseConnection[5]);
		boolean recordStatusValidatorRESULT = recordStatusValidator(DataBaseConnection[8]);
		boolean Active_Inactive_FlagRESULT = Active_Inactive_Flag(DataBaseConnection[9]);
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

//customername(str1[1].substring(0, str1[1].lastIndexOf("~")));
//pincode(str1[4].substring(0, str1[4].lastIndexOf("~")));
//recordStatusValidator(str1[5].substring(0, str1[5].lastIndexOf("~")));
//Active_Inactive_Flag(str1[9].substring(0, str1[9].lastIndexOf("~")));