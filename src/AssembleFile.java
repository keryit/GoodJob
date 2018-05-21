
import java.io.*;
import java.util.*;

/* 
Asseble one file from several files
Read from console name of files
Each filename: [someName].partN.
For example, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Name of files writing randomly. Reading finish after word "end".
On the folder, where the rest files create new one with the same name but without [.partN].
For example, Lion.avi.
Write to new file all file using buffer.
Shoul be write the fist file, than second and ...
Close.
*/

public class AssembleFile {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String name="";
        TreeMap<Integer,String> map = new TreeMap();
        File fileNew=null;


        while (!(name=sc.nextLine()).equals("end")){

            int numberOnly= Integer.parseInt(name.replaceAll("[^0-9]", ""));
            map.put(numberOnly,name);

        }

        fileNew = new File(map.entrySet().iterator().next().getValue().replaceAll(".part[0-9]",""));

        FileOutputStream outputStream = new FileOutputStream(fileNew, true);
        FileInputStream inputStream=null;

        for (Map.Entry entry : map.entrySet()) {

             inputStream = new FileInputStream(entry.getValue().toString());

            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            outputStream.write(bytes);
            inputStream.close();
            }


        outputStream.close();




    }
}
