import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class SDA1718L2B {
	public static void main (String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		String str; //baca input
		
		LinkedList<String> parkiran= new LinkedList<>();
		ArrayList<String> mogok = new ArrayList<>(); 
		
		while ((str = in.readLine()) != null){ //kalau isinya tidak null
			String[] input = str.split(" "); //split input
			
			//jika perintah masuk
			if (input.length>1 && input[0].equals("MASUK") && input[1].length()<21){
				if (input[2].equals("BARAT")){ //ke barat/kiri
					parkiran.addFirst(input[1]);
					System.out.println(input[1]+" masuk melalui pintu BARAT");
				}else if (input[2].equals("TIMUR")){
					parkiran.addLast(input[1]); //ke timur/kanan
					System.out.println(input[1]+" masuk melalui pintu TIMUR");
				}else if(parkiran.contains(input[2])){ //jika mobil sudah ada di parkiran
					System.out.println("Mobil sudah ada di parkiran");
				}
				else{ //input salah
					System.out.println("Input salah");
				}
				
			}//jika perintah keluarkan
			else if (input[0].equals("KELUARKAN")){
				int dariBarat = parkiran.indexOf(input[1]);
				int dariTimur = parkiran.size()-parkiran.indexOf(input[1])-1;
				if(!(parkiran.contains(input[1]))){ //jika mobil tidak ada di garasi
					System.out.println(input[1]+ " tidak ada di garasi");
				}
				else if (mogok.contains("input[1]")){ //jika mobil sedang mogok
					System.out.println("Mobil "+input[1]+" sedang mogok");
				}
				else{//jika mobil ada di parkiran
					//if (!mogok.isEmpty()){
					//	if (parkiran.indexOf(mogok[]))
					//}
					if(dariBarat<dariTimur){ //lebih sedikit mobil di timur
						System.out.println(input[1]+" keluar melalui pintu BARAT");
						parkiran.remove(input[1]);
					}
					else if(dariBarat>dariTimur){ //lebih sedikit mobil di barat
						System.out.println(input[1]+" keluar melalui pintu TIMUR");
						parkiran.remove(input[1]);
					}
					else if(dariBarat==dariTimur){ //mobil di barat = mobil di timur
						System.out.println(input[1]+" keluar melalui pintu BARAT");
						parkiran.remove(input[1]);
					}
				}
			}//jika perintah mogok
			else if (input[0].equals("MOGOK")){
				mogok.add(input[1]);
			}//jika perintah servis
			else if (input[0].equals("SERVIS")){
				mogok.remove(input[1]);
			}
		}str = in.readLine();//membaca baris setelahnya
	}
}
