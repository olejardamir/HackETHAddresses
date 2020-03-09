import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

// Main Class
public class Multithread
{
    public static void main(String[] args) throws Exception {
    	
    	deleteJunk();

            int n = 11; // Number of threads
            for (int i = 0; i < n; i++) {
                MultithreadingDemo object = new MultithreadingDemo();
                object.start();
            } 
    }

	private static void deleteJunk() throws IOException {
		File dir = new File("temporary/");
		List<File> files = (List<File>) FileUtils.listFiles(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files) {
			FileUtils.forceDelete(file);
		}
	}


} 