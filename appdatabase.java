package appdatabase;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

class appDatabase{
HashMap conf = new HashMap ();

public appDatabase(){ //konstruktor
readConf();
printConf();
}

public void readConf(){
try{
FileInputStream fstream = new FileInputStream(“appDatabase.conf”);
DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine;
String line[];
while ((strLine = br.readLine()) != null) {
if(!strLine.startsWith(“#”) && strLine.length()!=0){ //tidak membaca pada baris yang di awali # dan baris kosong
line = strLine.split(“:”); // memisah karakter : menjadi array
line[0].trim();
line[1].trim();
conf.put(line[0],line[1]); // memasukkan nilai pada Hash
}
}
in.close();
}catch (Exception e){
System.out.println(“Error: ” + e.getMessage());
}
}
public void printConf(){
System.out.println(“TitleApplication: “+ conf.get(“TitleApplication”).toString().trim());
System.out.println(“HostDatabase: “+ conf.get(“HostDatabase”).toString().trim());
System.out.println(“UserDatabase: “+ conf.get(“UserDatabase”).toString().trim());
System.out.println(“PassDatabase: “+ conf.get(“PassDatabase”).toString().trim());
System.out.println(“NamaDatabase: “+ conf.get(“NamaDatabase”).toString().trim());
}

public static void main(String[] args) {
appDatabase obj = new appDatabase();
}
}
//==============================END appDatabase.java==================
