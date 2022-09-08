import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		try {
			Scanner sc = new Scanner(new File("Peliculas_11_20.txt"));
			//Skips initial line
			sc.nextLine();
			while (sc.hasNext()) {
				String linea = sc.nextLine();
				String [] split = linea.split("\\$");
				peliculas.add(new Pelicula(split[0].trim(), new BigInteger((split[1].trim().replace(",", "")))));
			}
			Scanner sc2 = new Scanner(new File("PeliculasTop10.txt"));
			while (sc2.hasNext()) {
				String linea = sc2.nextLine();
				String [] split = linea.split("\\$");
				peliculas.add(new Pelicula(split[0].trim(), new BigInteger((split[1].trim().replace(",", "")))));
			}
			sc.close();
			sc2.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		StringBuilder sb = new StringBuilder();
		
		//Ordering
		Collections.sort(peliculas, (o2, o1) -> o1.getRecaudacion().subtract(o2.getRecaudacion()).intValue());
		for (int i = 0; i < peliculas.size(); i++) {
			String linea = peliculas.get(i).getNombre() + " " + (i+1);
			sb.append(linea + "\n");
		}
		System.out.println(sb);
		
		String bienvenida = "Hola Mundo! El día de hoy es \"+ elDia +\".\\r\\n"
				+ " Este curso me hizo programar mas de lo que me hubiese gustado";
		ArrayList<String> jenkinsLines = new ArrayList<String>();
		jenkinsLines.add(""
				+ "import java.util.Date\r\n"
				+ "import java.text.SimpleDateFormat\r\n"
				+ "pipeline {\r\n"
				+ "   agent any\r\n"
				+ "   stages {\r\n"
				+ "      stage('Hello') {\r\n"
				+ "         steps {\r\n"
				+ "			  script{\r\n"
				+ "				String elDia =new SimpleDateFormat(\"dd-MM-yyyy\").format(new Date())\r\n"
				+ "				println \""+bienvenida+"\"\r\n"
				+ "			  }\r\n"
				+ "         }\r\n"
				+ "      }\r\n"
				+ "   }\r\n"
				+ "}\r\n"
				+ "");
		try {
			Path jenkins = Paths.get("Jenkinsfile");
			Files.write(jenkins, jenkinsLines, StandardCharsets.UTF_8);
			Path top20 = Paths.get("top20_mejores_peliculas.txt");
			Files.write(top20, Arrays.asList(sb.toString()), StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
