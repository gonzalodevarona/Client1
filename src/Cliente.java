import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Scanner;

public class Cliente {
	
	public final static String B1024 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc tincidunt ligula id enim egestas tristique. In turpis nisi, molestie dictum interdum eu, ornare nec neque. Fusce quis odio orci. Sed euismod luctus felis quis imperdiet. Integer condimentum ut elit vel luctus. Nullam at fringilla massa, sed iaculis urna. Donec eu massa et tellus cursus finibus vel et mi. Suspendisse at mi tincidunt, dictum turpis sodales, auctor mi. Maecenas volutpat quam eget leo cursus vestibulum. Suspendisse potenti. Fusce vel bibendum diam, consectetur ultricies lacus. In at mollis mauris, id tempor arcu. " + 
			 
			"Curabitur vel convallis ligula. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Nulla facilisi. Nullam eu euismod ex. Vivamus vitae diam eleifend, tincidunt turpis eget, tincidunt justo. Nullam dictum tincidunt quam et finibus. Nunc pellentesque est libero, ut bibendum mi interdum nec. Quisque lorem neque, tincidunt nec nisl vitae, volutpat accumsan metus. Cras ac ex sed est maximus donec. \n";

	public final static String B8192 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum varius imperdiet arcu, et lobortis nisl pulvinar at. Morbi egestas feugiat tellus eu mollis. Mauris ut lectus leo. Proin sapien ante, laoreet eget convallis nec, sagittis a purus. Phasellus arcu urna, dictum eu nisl eu, mollis porttitor diam. Aliquam luctus blandit arcu, sed pretium velit maximus a. In nec nisl laoreet, tristique nunc eu, pulvinar velit. Vestibulum ullamcorper tincidunt eros, a vestibulum felis rhoncus in. Pellentesque lobortis nisl quis pulvinar rutrum. Integer iaculis in ligula vitae lacinia. Duis non erat hendrerit, dapibus lacus ac, vestibulum nisi. Aliquam id felis erat. Donec pulvinar, libero et consequat maximus, ante justo feugiat massa, vitae eleifend eros sem sit amet ex. " + 
			
			"Fusce placerat, mauris a lacinia vehicula, lacus odio dapibus lectus, eget ullamcorper mi neque quis ante. Maecenas auctor est eros, ac interdum leo malesuada vel. Maecenas fermentum condimentum turpis. Pellentesque gravida nibh a nisi interdum vestibulum. Phasellus ac libero viverra, dictum lorem eu, fermentum quam. Fusce eu sapien vitae odio vestibulum accumsan. Suspendisse at ex nulla. Aliquam tincidunt odio commodo, condimentum leo a, semper urna. Mauris ultricies, elit malesuada accumsan laoreet, lorem tortor blandit sapien, quis sollicitudin tellus felis sed dolor. Donec semper ex et risus bibendum, rhoncus rhoncus lorem aliquam. Morbi consequat ultrices neque ac efficitur. Proin quam mi, condimentum tincidunt blandit et, posuere id libero. Proin vitae libero non felis vehicula mattis. " + 
			 
			"Maecenas viverra, erat facilisis sodales interdum, mi nisi sagittis ex, in tincidunt tellus lorem in neque. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas nisl ipsum, pretium id diam sit amet, bibendum molestie turpis. Pellentesque ornare tristique leo, viverra vulputate erat eleifend eget. Sed quis volutpat dui, eget elementum arcu. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur finibus quam eget erat imperdiet, id luctus ex suscipit. Etiam volutpat suscipit magna quis dignissim. Nunc vel mi ac sem sagittis tempor sed ut nunc. Integer vulputate orci ac lacus placerat condimentum. Ut congue eleifend cursus. " + 
			 
			"Nunc commodo, libero at pretium fermentum, felis turpis condimentum urna, nec tempor ante felis eu mauris. Pellentesque et nulla eget ante malesuada feugiat. Cras ultricies euismod quam at auctor. Suspendisse facilisis sapien nec venenatis commodo. Nunc hendrerit vestibulum metus, tempor porta tellus. Phasellus dapibus imperdiet elit, sit amet pellentesque odio semper id. Cras eros felis, tincidunt sed dapibus eget, auctor sed ligula. Cras sit amet massa ac odio pulvinar dignissim. Phasellus ut cursus neque. Duis mattis aliquam augue ut commodo. Praesent congue tempus turpis, vel tincidunt magna luctus quis. Aliquam sit amet ligula non purus rhoncus finibus. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean eget sapien volutpat, ullamcorper ex eu, luctus est. Duis consectetur auctor nisl, non scelerisque nibh rhoncus at. " + 
			 
			"Maecenas eleifend ante id mi vehicula mattis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed lacinia orci vel egestas efficitur. Etiam ac auctor urna, a scelerisque magna. Mauris finibus, dui ut hendrerit finibus, purus arcu eleifend nibh, eu porttitor massa diam quis urna. Sed sodales nisl non facilisis elementum. Ut in eros erat. Aliquam facilisis ipsum est, sit amet sodales leo consequat a. Pellentesque gravida justo non leo dapibus vehicula. Cras facilisis hendrerit scelerisque. Vivamus laoreet odio lacinia, bibendum erat nec, egestas nisl. Vestibulum non tincidunt nunc, eu ornare nisi. Maecenas laoreet interdum vestibulum. Integer et convallis ipsum. Phasellus faucibus non ex at feugiat. " + 
			 
			"Sed nisi dolor, porta sit amet ipsum nec, aliquam suscipit neque. Phasellus ut sapien eros. Quisque cursus urna purus, sed fringilla nisl tempus tempus. Praesent non tempus tortor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas sed quam sed leo pharetra efficitur. In ultricies eleifend mi, a faucibus enim eleifend vitae. In imperdiet mattis vulputate. Nulla euismod pulvinar nunc, eget pretium leo ullamcorper non. Pellentesque posuere porttitor nisl vel pharetra. Morbi rutrum tellus augue, sed pretium quam pulvinar in. Donec egestas, enim ut molestie commodo, ligula leo mattis erat, a commodo lorem erat eu leo. Phasellus in rutrum neque. Maecenas ac rhoncus ligula. Fusce id ipsum feugiat, ornare diam nec, pulvinar nibh. " + 
			 
			"Ut vitae tincidunt arcu. Maecenas at scelerisque felis. In orci lorem, ornare vel fermentum ac, dictum quis sapien. Sed tortor nibh, sagittis vitae eros ut, pellentesque facilisis neque. Cras lectus libero, placerat sed lacus et, semper feugiat ipsum. Vestibulum volutpat ex id sapien pharetra, a malesuada felis luctus. Morbi consequat hendrerit magna. Ut egestas, mi vitae tempus congue, enim nibh tempus risus, et accumsan mi quam ut odio. Ut scelerisque pulvinar ultricies. Etiam ut ornare purus. Pellentesque at neque nec purus molestie facilisis. " + 
			 
			"Aliquam est felis, lobortis nec mollis et, porta quis tortor. Quisque ac ante mattis, iaculis leo non, ornare metus. Donec ut ullamcorper mi. Aliquam varius ac odio a porttitor. Morbi efficitur vel mauris et rutrum. Aenean facilisis neque metus, id finibus nunc pharetra a. Curabitur vel blandit velit. Nullam id enim bibendum, hendrerit dui sit amet, viverra ipsum. Maecenas placerat lectus in congue facilisis. Ut dignissim convallis odio. Suspendisse potenti. Praesent scelerisque malesuada dolor, nec dictum velit accumsan eu. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nam pellentesque ligula mauris, eu ultrices sapien scelerisque et. Nunc mattis sed lacus eu aliquet. Sed eget porttitor nulla, sit amet luctus ex. " + 
			 
			"Curabitur turpis risus, tristique vitae ligula eget, vehicula vehicula tortor. Fusce purus erat, viverra ut augue id, gravida semper diam. Sed luctus et nisl at aliquet. Nam risus libero, ornare ut augue id, faucibus viverra erat. Suspendisse non finibus justo. Suspendisse sed dictum mi, eget viverra mauris. Fusce gravida, ipsum sed pellentesque varius, nibh neque volutpat felis, ac aliquet urna felis at sapien. Nulla rhoncus dui magna, ac pharetra eros lobortis eget. Duis congue fermentum purus. Proin tincidunt ante rhoncus tellus euismod sodales. Aenean consequat vel ligula convallis mattis. Ut lorem urna, semper sit amet viverra vitae, malesuada eget velit. Integer efficitur turpis vitae dictum rutrum. Sed ante enim, elementum quis ligula at, facilisis hendrerit nisi. Etiam pretium in lorem in hendrerit. Nulla luctus enim elit, non dapibus erat posuere sed. " + 
			 
			"Aliquam erat volutpat. Nullam quis augue purus. Sed volutpat sem elit, at gravida metus interdum nec. Pellentesque et lorem porta, sagittis mi eget, bibendum lorem. Cras in ligula a ante bibendum viverra. Pellentesque id dui eget enim pellentesque aliquam ut ut neque. Proin aliquet dolor vel velit accumsan euismod. Proin neque mauris, vestibulum in lobortis vel, vestibulum non lectus. Sed tincidunt nunc eu odio scelerisque, nec viverra quam porttitor. Fusce viverra erat accumsan arcu scelerisque laoreet. Aenean non iaculis augue, nec venenatis ex. Proin lobortis in purus quis ultrices. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non erat semper, accumsan mi et, ornare massa. Donec sollicitudin porta dolor. Etiam et nibh est. " + 
			 
			"Praesent vel gravida lectus, sed mollis arcu. Aenean cursus ornare metus mollis vehicula. Duis lobortis finibus ante, in lacinia lacus dictum vitae. Nunc vitae eleifend lectus. Sed finibus aliquam lectus vitae efficitur. Cras tempor semper purus nec accumsan. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla ligula elit, lacinia eget est at, tincidunt varius eros. Proin sagittis ligula sed elit accumsan auctor. Nulla quis nulla elit. Phasellus pretium pretium erat quis sodales. Sed scelerisque nulla eget lectus elementum tristique. Etiam neque neque, dapibus id metus at, dictum metus. \n";
	
	
	
	
	public static void main(String[] args) {
		try {
			
			System.out.println("");
			System.out.println("Conectando con el servidor...");
			System.out.println("");
			InetAddress address = InetAddress.getLocalHost();
			Socket socketClient = new Socket(address.getHostAddress(), 5000);
			System.out.println("CONECTADO");
			
			BufferedWriter bWriter = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
			BufferedReader bReader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
			
			
			long startTime = 0;
			long endTime = 0;
				
			while(true){
				
				String answer = "";
				System.out.println(menu());
				Scanner scan = new Scanner(System.in);
				int choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					answer = "1 \n";
					break;
				case 2:
					answer = "2 \n";			
					break;
				case 3:
					answer = "3 \n";
					break;
				case 4:
					System.out.println("");
					System.out.println("Mensaje de 1024 bytes enviado");
					System.out.println("");
					answer = B1024;
					bWriter.write(answer);
					bWriter.flush();
					startTime = System.currentTimeMillis();
					
					System.out.println(bReader.readLine());
					
					endTime = System.currentTimeMillis();
					
					System.out.println("");
					System.out.println("El tiempo de ida y venida de un mensaje de 1024 bytes es de: "+ (endTime-startTime) + " milisegundos.");
					System.out.println("");
					
					break;
				case 5:
					System.out.println("");
					System.out.println("Mensaje de 8192 bytes enviado");
					System.out.println("");
					answer = B8192;
					bWriter.write(answer);
					bWriter.flush();
					startTime = System.currentTimeMillis();
					
					System.out.println(bReader.readLine());
					
					endTime = System.currentTimeMillis();
					
					long realTime = endTime - startTime;
					
					
					long kb = (8192/1000)/realTime;
					
					System.out.println("");
					System.out.println("El tiempo de transferencia es de: "+ kb + " kb/ms.");
					System.out.println("");
					
					break;

				
				default:
					System.out.println("");
					System.out.println("ERROR: Entrada Invalida");
					System.out.println("");
					break;
				}
				
				if (choice == 1 || choice == 2 ||  choice == 3) {
					bWriter.write(answer);
					bWriter.flush();
					System.out.println(bReader.readLine());
					
					
				}
				
				
				
				
				
					
			}
			
			
		} catch (IOException e) {
			 
			e.printStackTrace();
		}
	
		
	}
	
	public static String menu() {
		
		String msg = "\n";
		msg += "Hola, por favor escoge una de las siguientes opciones: \n";
		msg += "1. Ver la dirección IP del servidor \n";
		msg += "2. Ver las interfaces activas del servidor \n";
		msg += "3. Ver la hora del servidor \n";
		msg += "4. Ver cuanto se demora en ir y venir un mensaje de 1024 bytes \n";
		msg += "5. Ver cuál es la velocidad de transferencia (Kb/s) de un mensaje de 8192 bytes \n";
		msg += "\n";
		msg += "Por favor escribe el número de la opción que desees: \n";
		
		
		return msg;
	} 

}
