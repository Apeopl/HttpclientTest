package test;

import java.net.URL;

public class JarTest {
	public static void main(String[] args) {
		URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
		for (URL url : urLs) {
			System.out.println(url.toExternalForm());
		}
	}
}
