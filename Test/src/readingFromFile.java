import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class readingFromFile {

	
	
	public static void main(String[] args) {
		try {
			File file = new File("/home/tarek-fouda/text.txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			int i =0;
			while ((line = bufferedReader.readLine()) != null) {
			System.out.println(line);
			System.out.println(i);
			i++;
			}
			fileReader.close();
			System.out.println("Contents of file:");
			System.out.println(stringBuffer.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
