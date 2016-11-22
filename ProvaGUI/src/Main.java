import java.awt.EventQueue;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OminoModel model = new OminoModel();
					OminoView frame = new OminoView(model);
					OminoController controller = new OminoController(frame, model);
					controller.activate();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
