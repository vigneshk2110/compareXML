package compareXMLfiles;

import javax.xml.transform.Source;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;

public class XMLComparator {
	public static void main(String[] args) {
		//        String file1 = "/home/adventurer/Desktop/Task Files/XML/file1.xml";
		//        String file2 = "/home/adventurer/Desktop/Task Files/XML/file0.xml";

		String file1 = "/home/adventurer/eclipse-workspace/compareFilesTask/src/main/resources/XML/fileOriginal.xml";
		String file2 = "/home/adventurer/eclipse-workspace/compareFilesTask/src/main/resources/XML/fileWithError.xml";

		Source source1 = Input.fromFile(file1).build();
		Source source2 = Input.fromFile(file2).build();

		Diff xmlDiff = DiffBuilder.compare(source1).withTest(source2).build();
		
		System.out.println("\n ------------------ Test: 1 ------------------ \n");

		if (xmlDiff.hasDifferences()) {
			System.out.println("Differences found:");

			Iterable<Difference> differences = xmlDiff.getDifferences();

			for (Difference difference : differences) {
				System.out.println(difference);
			}
		} else {
			System.out.println("XML files are identical.");
		}
		
		System.out.println("\n ------------------ Test: 2 ------------------ \n");

		file2 = "/home/adventurer/eclipse-workspace/compareFilesTask/src/main/resources/XML/fileWithoutError.xml";

		source2 = Input.fromFile(file2).build();
		
		xmlDiff = DiffBuilder.compare(source1).withTest(source2).build();

		if (xmlDiff.hasDifferences()) {
			System.out.println("Differences found:");

			Iterable<Difference> differences = xmlDiff.getDifferences();

			for (Difference difference : differences) {
				System.out.println(difference);
			}
		} else {
			System.out.println("XML files are identical.");
		}
	}
}