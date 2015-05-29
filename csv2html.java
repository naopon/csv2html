import java.io.*;

class csv2html {
	
	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String tmp = null;
			String buf = null;
			while ((tmp = br.readLine()) != null){
				System.out.println("<tr>");
				buf = rep_comma(tmp);
				System.out.println("\t" + buf);
				System.out.println("</tr>");
			}
		}catch(FileNotFoundException e){
			System.err.println(e);
		}catch(IOException e){
			System.err.println(e);
		}
	}
	
	static String rep_comma(String in){
		int i = 0;
		String tmp = "<td>";
		while( i < in.length() ){
			if (in.charAt(i) == (',')) {
				tmp += "</td><td>";
			}else if(in.charAt(i) == ('\"')){
				tmp += "&quot;";
			}else if(in.charAt(i) == ('&')){
				tmp += "&amp;";
			}else if (in.charAt(i) == ('<')) {
				tmp += "&lt;";
			}else if (in.charAt(i) == ('>')) {
				tmp += "&gt;";
			}else if (in.charAt(i) == (' ')){
				tmp += "&nbsp;";
			}else if (in.charAt(i) == ('©')) {
				tmp += "&copy;";
			}else{
				tmp += in.charAt(i);
			}
			i++;
		}
		tmp += "</td>";
		return tmp;
	}
}