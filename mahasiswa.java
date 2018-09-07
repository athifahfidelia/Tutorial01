import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;


public class SDA1718L2A {
	//treemap untuk antrean print
	static TreeMap<String, Integer> treemap = new TreeMap<>();

	public static void main (String[] args) throws IOException{
		BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
		String str = in.readLine(); //baca input
		
		//array untuk list yang sudah diprint
		ArrayList<String> done = new ArrayList<>();
		
		while (str != null){ //kalau isinya tidak null
			String[] input = str.split(" "); //split input
			
			//jika perintah submit
			if (input.length>1 && input[1].equals("SUBMIT")&& input[3].equals("HALAMAN")&& input[0].length()==8 && input[0].startsWith("1") && Integer.parseInt(input[2])>0 && Integer.parseInt(input[2])<1000){
				if(treemap.containsKey(input[0])){ //jika submisi sebelumnya belum di print
					System.out.println("Harap tunggu hingga submisi sebelumnya selesai diproses");
				}
				else if(Integer.parseInt(input[2])>10){ //jika jumlah halaman >10
					System.out.println("Jumlah halaman submisi "+input[0]+" terlalu banyak");
				}else{ //jika perintah benar dan bisa dijalankan
					treemap.put(input[0], Integer.parseInt(input[2]));
					System.out.println("Submisi "+input[0]+" telah diterima");	
				}
				
			//jika perintah print
			}else if (input[0].equals("PRINT")){
				int jmlHal = 0;
				if(treemap.isEmpty()){ //jika tidak ada antrean untuk print
					System.out.println("Antrean kosong");
				}
				else{ //jika perintah benar dan bisa dijalankan
					while (jmlHal <= 10 && !(treemap.isEmpty())){
						jmlHal += treemap.get(treemap.firstKey()); //jumlah halaman ditambah
						if (jmlHal <=10){ //jumlah halaman benar <10
							System.out.println("Submisi "+treemap.firstKey()+" telah dicetak sebanyak "+treemap.get(treemap.firstKey())+" halaman");
							done.add(treemap.firstKey());
							treemap.remove(treemap.firstKey());
						}
						else{ //jumlah halaman >10, tunggu di antrean selanjutnya
							break;
						}
					}
				}
				
			//jika perintah cancel
			}else if (input.length>1 && input[1].equals("CANCEL")){
				if (treemap.containsKey(input[0])){ //jika benar akan dibatalkan
					treemap.remove(input[0]);
					System.out.println("Submisi "+input[0]+" dibatalkan");
				}else{ //jika npm tidak ada dalam antrian print
					System.out.println(input[0]+" tidak ada dalam antrean");
				}
				
			//jika perintah status
			}else if (input.length>1 && input[0].equals("STATUS")){
				if (treemap.containsKey(input[1])){ //jika masih ada di dalam antrian (Treemap treemap)
					System.out.println("Submisi "+input[1]+" masih dalam antrean");
				}else if (done.contains(input[1])){ //jika sudah di proses (Arraylist done)
					System.out.println("Submisi "+input[1]+" sudah diproses");
				}else{//jika belum di proses dan tidak ada dalam antrian
					System.out.println(input[1]+" tidak ada dalam sistem");
				}
			}
			str = in.readLine();//membaca baris setelahnya
		}
		
	}
}
