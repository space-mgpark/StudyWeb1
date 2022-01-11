package sw.gdal.homework.service;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileListReader {
    public List<String> filelist = new ArrayList<>();

        public List<String> list (String fileDir) {

            File dir = new File(fileDir);
            File files[] = dir.listFiles();
            for (int i = 0; i < files.length; i++) {
                filelist.add(String.valueOf(files[i]));
            }
            return filelist;
        }
    }

