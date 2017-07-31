package interactivegraph;


import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;


/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class InteractiveGraphView extends ViewPart {
		Label label;
		Image image;
		public InteractiveGraphView() {
			
		}
		public void createPartControl(Composite parent) {
			label = new Label(parent, SWT.NONE);
		    label.setText("Hello World");

			label = new Label(parent, SWT.NONE);
			image = new Image(null, "image.png");
			label.setImage(image);
		}
		public void setFocus() {
		}
		public static void main(String[] args) {
			CSVcleaner.clean();
			System.out.println("CLEAN DONE!");
			CSVReader.nodes();
			System.out.println("READ DONE!");
			CreateNode.create();
			System.out.println("NODES DONE!");
			//NodeFocus.main();
			
		}
}
