import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class acnhGUI_App {

	public JFrame frame;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	private static final String READERR = "One or more fields had an invalid visitor name. Please try again";
	private static final String DUPERR = "This visitor has already been entered. Please try again";
	private boolean errorGiven = false;
	private JLabel lblResultsGoHere = new JLabel(acnhStats.printStats());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acnhGUI_App window = new acnhGUI_App();
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
	public acnhGUI_App() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(acnhGUI_Welcome.VERSION);
		frame.setResizable(false);
		frame.setBounds(100, 100, 509, 468);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					JTextField[] tfs = {textField, textField_1, textField_2, textField_3, textField_4};
					if(!acnhValid.fieldsFilled(tfs) && !acnhValid.fieldsEmpty(tfs))
					{
						try {
							acnhFileIO.saveProgress(tfs);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						JOptionPane.showMessageDialog(frame, "Your progress is saved! (Any non-visitor names will be cleared)", "Exit", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
					frame.dispose();
				}
			});
		
		JLabel lblCurlysAcnhVisitor = new JLabel("Curly's ACNH Visitor Tracker");
		lblCurlysAcnhVisitor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCurlysAcnhVisitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurlysAcnhVisitor.setBounds(0, 11, 503, 25);
		frame.getContentPane().add(lblCurlysAcnhVisitor);
		
		JLabel lblVisitorsThisWeek = new JLabel("Visitors This Week");
		lblVisitorsThisWeek.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVisitorsThisWeek.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitorsThisWeek.setBounds(300, 64, 203, 25);
		frame.getContentPane().add(lblVisitorsThisWeek);
		
		textField = new JTextField();
		textField.setBounds(369, 100, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					submit();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(369, 131, 100, 20);
		frame.getContentPane().add(textField_1);
		textField_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					submit();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(369, 162, 100, 20);
		frame.getContentPane().add(textField_2);
		textField_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					submit();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(369, 193, 100, 20);
		frame.getContentPane().add(textField_3);
		textField_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					submit();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(369, 224, 100, 20);
		frame.getContentPane().add(textField_4);
		textField_4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try {
					submit();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JTextField[] tfs = {textField, textField_1, textField_2, textField_3, textField_4};
		try {
			firstRun(tfs);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setBounds(300, 100, 80, 20);
		frame.getContentPane().add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setBounds(298, 134, 80, 14);
		frame.getContentPane().add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setBounds(290, 165, 80, 14);
		frame.getContentPane().add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setBounds(295, 196, 80, 14);
		frame.getContentPane().add(lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setBounds(303, 227, 80, 14);
		frame.getContentPane().add(lblFriday);
		
		JButton btnCalculateOdds = new JButton("Calculate Odds!");
		btnCalculateOdds.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				try {
					submit();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnCalculateOdds.setBounds(300, 277, 169, 23);
		frame.getContentPane().add(btnCalculateOdds);
		frame.getRootPane().setDefaultButton(btnCalculateOdds);
		
		lblResultsGoHere.setVerticalAlignment(SwingConstants.TOP);
		lblResultsGoHere.setBounds(23, 58, 267, 381);
		frame.getContentPane().add(lblResultsGoHere);		
		
		JButton btnDonate = new JButton("Donate <3");
		btnDonate.setBounds(300, 379, 169, 23);
		btnDonate.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					donate();
				}
			});
		frame.getContentPane().add(btnDonate);
		
		JButton btnClearWeek = new JButton("Clear Week");
		btnClearWeek.setBounds(300, 311, 169, 23);
		frame.getContentPane().add(btnClearWeek);
		
		JButton btnSetPriorities = new JButton("Set Priorities");
		btnSetPriorities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				frame.setVisible(false);
				acnhGUI_lastWeeksVisitors.main(null);
			}
		});
		btnSetPriorities.setBounds(300, 345, 169, 23);
		frame.getContentPane().add(btnSetPriorities);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 503, 392);
		frame.getContentPane().add(separator);		
		btnClearWeek.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0)
			{
				JTextField[] tfs = {textField, textField_1, textField_2, textField_3, textField_4};
				try {
					clearAllFields(tfs);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	private void submit() throws IOException
	{		
		JTextField[] tfs = {textField, textField_1, textField_2, textField_3, textField_4};
		
		for(int i = 0; i < tfs.length; i++)
		{
			if(tfs[i].getText().equals(""))
			{
				tfs[i].grabFocus();
				break;
			}
		}
		
		frame.setVisible(true);
		
		//TODO: Double check every last part of this program, then roll it out for beta testing!
		//TODO: Create a GitHub repository to show off all this work I did
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
					JOptionPane.showMessageDialog(frame, READERR, "Error", JOptionPane.ERROR_MESSAGE);
				tfs[i].setText("");
				i--;
				errorGiven = true;
			}
			else if(acnhValid.isDupe(tfs, visitor, i))
			{
				JOptionPane.showMessageDialog(frame, DUPERR, "Error", JOptionPane.ERROR_MESSAGE);
				tfs[acnhValid.findDupe(tfs, visitor, i)].setText("");
				i--;
				errorGiven = true;
			}
			else if(acnhValid.isChancer(visitor))
			{
				acnhStats.markChancer(visitor);
			}
			else if(acnhValid.isGuaranteer(visitor))
			{
				acnhStats.markGuaranteer(visitor);
			}
			
			if(i != tfs.length - 1 && !errorGiven)
			{
				tfs[i+1].grabFocus();
			}
		}
		
		errorGiven = false;		
		
		if(acnhValid.fieldsFilled(tfs))
		{
			JOptionPane.showMessageDialog(frame, "This week has now been saved. Next week, we'll be able to use THIS week's visitors to be more accurate!", "Week Saved!", JOptionPane.INFORMATION_MESSAGE);
			
			frame.invalidate();
			lblResultsGoHere.setText(acnhStats.finalStats());
			frame.validate();
			frame.repaint();
			
			acnhFileIO.sentenceCase(tfs);
			acnhFileIO.save(tfs);
		}
		else
		{
			frame.invalidate();
			lblResultsGoHere.setText(acnhStats.printStats());
			frame.validate();
			frame.repaint();
		}
		
		return;
	}
	
	private void firstRun(JTextField[] tfs) throws IOException
	{		
		if(acnhFileIO.inProgress)
		{
			acnhFileIO.readProgress(tfs);
		}
		
		submit();
		
	}
	
	private void clearAllFields(JTextField[] tfs) throws IOException
	{
		boolean neverMind = false;
		
		if(acnhStats.arePriorities())
		{
			int option = JOptionPane.showConfirmDialog(frame, "Would you like to keep your prioritized visitors?", "Keep Prioritized Visitors", JOptionPane.YES_NO_CANCEL_OPTION);
			if(option == JOptionPane.NO_OPTION)
			{
				acnhPrioritize.resetPriorities();
			}
			else if(option == JOptionPane.CANCEL_OPTION)
			{
				neverMind = true;
			}
		}
		
		acnhStats.resetVisitors();
		
		if(!neverMind)
		{
			for(int i = 0; i < tfs.length; i++)
			{
				tfs[i].setText("");
			}
		}
		
		submit();
	}
	
	public void donate()
	{
		try
		{
			Desktop.getDesktop().browse(java.net.URI.create("https://paypal.me/remaincurly?locale.x=en_US"));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
