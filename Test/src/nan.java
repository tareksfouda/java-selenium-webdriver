import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class nan {
public static void main(String[]  args) throws FileNotFoundException {
	/*
	String url = "http://xxx.xxx.xx.xx/resources/upload/2014/09/02/new sample.pdf";
	String[] urlArray = url.split("/");
	String lastPath = urlArray[urlArray.length-1];

	String restOfUrl = url.substring(0,url.lastIndexOf("/"));
	System.out.println(lastPath+"1");
	System.out.println(restOfUrl + "2");
	*/
	
	


    Scanner scanner = new Scanner(new File("/home/tarek-fouda/6437_CustomPages.csv"));
    String csvFile = "/home/tarek-fouda/6437_CustomPages.csv";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";

    try {

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] country = line.split(cvsSplitBy);

            System.out.println("Page name " + country[1] );

        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
	
}

