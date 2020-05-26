import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class acnhGUI_lastWeeksVisitors {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private boolean errorGiven = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acnhGUI_lastWeeksVisitors window = new acnhGUI_lastWeeksVisitors();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public acnhGUI_lastWeeksVisitors() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(acnhGUI_Welcome.VERSION);
		frame.setResizable(false);
		frame.setBounds(100, 100, 509, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDoYouHappen = new JLabel("<html>Do you happen to know the Chancers that <u>did NOT</u> visit last week?</html>");
		lblDoYouHappen.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoYouHappen.setBounds(0, 21, 503, 14);
		lblDoYouHappen.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblDoYouHappen);
		
		JLabel lblEnterAnyOf = new JLabel("Enter any of them below if you do. If you don't know ANY, just hit continue");
		lblEnterAnyOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAnyOf.setBounds(0, 57, 503, 62);
		frame.getContentPane().add(lblEnterAnyOf);
		
		textField = new JTextField();
		textField.grabFocus();
		textField.setBounds(199, 140, 106, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					submit();
				}
			});
		
		textField_1 = new JTextField();
		textField_1.setBounds(199, 171, 106, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				submit();
			}
		});		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(199, 202, 106, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);	
		textField_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				submit();
			}
		});		
		
		
		JButton btnContinue = new JButton("Continue");
		btnContinue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				submit();
			}
		});
		btnContinue.setBounds(278, 333, 89, 23);
		frame.getContentPane().add(btnContinue);
		frame.getRootPane().setDefaultButton(btnContinue);
		
		JLabel lblChancer = new JLabel("Chancer 1");
		lblChancer.setBounds(116, 143, 73, 14);
		frame.getContentPane().add(lblChancer);
		
		JLabel lblChancer_2 = new JLabel("Chancer 2");
		lblChancer_2.setBounds(116, 174, 73, 14);
		frame.getContentPane().add(lblChancer_2);
		
		JLabel lblChancer_3 = new JLabel("Chancer 3");
		lblChancer_3.setBounds(116, 205, 73, 14);
		frame.getContentPane().add(lblChancer_3);
		
		JButton btnChancersList = new JButton("Chancers List");
		btnChancersList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				JOptionPane.showMessageDialog(frame, listChancers(), "Chancers", JOptionPane.INFORMATION_MESSAGE);
			}
			
			private String listChancers()
			{
				String list = "";
				
				list += "<html><ul>";
				
				for(int i = 0; i < acnhData.CHANCE_LENGTH; i++)
				{
					list += "<li>" + acnhData.chancers[i] + "</li>";
				}
				
				list += "</ul></html";
				
				return list;
			}
		});
		btnChancersList.setBounds(100, 333, 130, 23);
		frame.getContentPane().add(btnChancersList);
		
	}
	
	private static void clearFields(JTextField[] jtf)
	{
		for(int i = 0; i < jtf.length; i++)
		{
			jtf[i].setText("");
		}
	}
	
	private void submit()
	{
		JTextField[] tfs = {textField, textField_1, textField_2};
		//Read textbox values
		for(int i = 0; i < tfs.length; i++)
		{
			String visitor = tfs[i].getText();
			
			if(visitor.equals(""))
			{
				continue;
			}
			else if(!acnhValid.visitorExists(visitor))
			{
				if(!errorGiven)
					JOptionPane.showMessageDialog(frame, "Invalid name detected. Make sure all fields have either a Chancer or nothing.", "Error", JOptionPane.ERROR_MESSAGE);
				clearFields(tfs);
				i--;
				errorGiven = true;
			}
			else if(!acnhValid.isChancer(visitor))
			{
				if(!errorGiven)
					JOptionPane.showMessageDialog(frame, "Guaranteer detected. Make sure all fields have either a Chancer or nothing.", "Error", JOptionPane.ERROR_MESSAGE);
				clearFields(tfs);
				i--;
				errorGiven = true;
			}
			else
			{
				acnhPrioritize.prioritize(visitor);
			}
		}

		if(!errorGiven)
		{
			frame.setVisible(false);
			acnhGUI_App.main(null);
		}
		
		errorGiven = false;
	}
}
