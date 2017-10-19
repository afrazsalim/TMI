import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class Test {
	public static void main(String [] args){
		URL u = null;
		Scanner s = null;
		Desktop d = Desktop.getDesktop();
		try {
			u = new URL("https://www.kixeye.com/game/warcommander//guide/");
			System.out.println(u.getClass());
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			s = new Scanner(u.openStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 while(s.hasNext()){
			 System.out.println(s);
		 }
		try {
			d.browse(new URI("https://www.kixeye.com/game/warcommander//guide/"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
