package lib;

import java.io.File;
import java.io.IOException;


public class WebpackBuildFile {
	static String jsBundle = "";

	static {
		try {
			final String prefix = new File(".").getCanonicalPath();
			final File directory = new File(prefix + "/public/bundle");
			final File[] listOfFiles = directory.listFiles();

			if(listOfFiles != null) {
				for(final File file : listOfFiles) {
					final String fileName = file.getName();
					if(file.isFile() && fileName.contains("js.bundle.") && fileName.substring(fileName.lastIndexOf(".") + 1).equals("js")) {
						jsBundle = fileName;
					}
				}
			}

		} catch(final IOException e) {
			e.printStackTrace();
		}
	}

	public static String getJsBundle() {
		return jsBundle;
	}
}
