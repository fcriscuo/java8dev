package edu.jhu.fcriscu1.tardev;

import org.xeustechnologies.jtar.TarEntry;
import org.xeustechnologies.jtar.TarOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by fcriscuolo on 3/30/16.
 */
public class JtarTest {
    public static void main(String[] args) {

        try {
            FileOutputStream dest = new FileOutputStream(("/tmp/test.tar"));
            TarOutputStream out = new TarOutputStream((new BufferedOutputStream(dest)));
            Path jsonPath = Paths.get("/tmp/json");
            Files.walk(jsonPath)
                    .filter ((p) -> p.toString().endsWith(".json"))
                    .forEach((p)->{
                        try {
                            out.putNextEntry(new TarEntry(p.toFile(),p.toString() ));
                            BufferedInputStream origin = new BufferedInputStream(new FileInputStream(p.toFile()));
                            int count;
                            byte data[] = new byte[2048];
                            while(( count= origin.read(data)) != -1){
                                out.write(data,0,count);
                            }
                            out.flush();
                            origin.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
            out.close();

        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

}
