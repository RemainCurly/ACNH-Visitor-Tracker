import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;

public class acnhGUI_Welcome {

	public static final String VERSION = "ACNH Visitor Tracker(v0.9)";
	private static final String IMPORT_FOUND = "Would you like to import last week's data for use in predicting this week?";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acnhGUI_Welcome window = new acnhGUI_Welcome();
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
	public acnhGUI_Welcome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(VERSION);
		frame.setResizable(false);
		frame.setBounds(100, 100, 509, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToCurlys = new JLabel("Welcome to Curly's ACNH Visitor Tracker!");
		lblWelcomeToCurlys.setBounds(0, 0, 503, 33);
		lblWelcomeToCurlys.setAlignmentY(Component.TOP_ALIGNMENT);
		lblWelcomeToCurlys.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToCurlys.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(lblWelcomeToCurlys);
		
		JLabel lblheresHowIt = new JLabel("<html><u>Here's how it works!</u></html>");
		lblheresHowIt.setHorizontalAlignment(SwingConstants.CENTER);
		lblheresHowIt.setBounds(0, 36, 503, 16);
		lblheresHowIt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		frame.getContentPane().add(lblheresHowIt);
		
		JLabel lblTheseAreGuaranteers = new JLabel("These are Guaranteers");
		lblTheseAreGuaranteers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheseAreGuaranteers.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTheseAreGuaranteers.setBounds(0, 78, 261, 20);
		frame.getContentPane().add(lblTheseAreGuaranteers);
		
		JLabel lblkickssaharahleif = new JLabel("<html><ul><li>Kicks</li><li>Saharah</li><li>Leif</li></ul></html>");
		lblkickssaharahleif.setHorizontalAlignment(SwingConstants.LEFT);
		lblkickssaharahleif.setBounds(0, 98, 280, 62);
		frame.getContentPane().add(lblkickssaharahleif);
		
		JLabel lblTheseAreChancers = new JLabel("These are Chancers");
		lblTheseAreChancers.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheseAreChancers.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTheseAreChancers.setBounds(261, 80, 242, 16);
		frame.getContentPane().add(lblTheseAreChancers);
		
		JLabel lblgullivercjflicklabelredd = new JLabel("<html><ul><li>Gulliver</li><li>CJ</li><li>Flick</li><li>Label</li><li>Redd</li></ul></html>");
		lblgullivercjflicklabelredd.setHorizontalAlignment(SwingConstants.LEFT);
		lblgullivercjflicklabelredd.setBounds(261, 98, 253, 90);
		frame.getContentPane().add(lblgullivercjflicklabelredd);
		
		JLabel lblguaranteersAreGuaranteed = new JLabel("<html><ul><li>Guaranteers are guaranteed to visit once every Monday-Friday. You'll see all of them every single week</li><li>Chancers will visit on the two days Guaranteers don't visit</li><li>The Chancers that didn't visit this week will have higher odds of visiting next week</li><li>We'll gather your last week and current week visitors from you to help you determine who you can expect to see in the future!</li></ul></html>");
		lblguaranteersAreGuaranteed.setBounds(0, 199, 503, 141);
		frame.getContentPane().add(lblguaranteersAreGuaranteed);
		
		JButton btnGotIt = new JButton("Let's Go!");
		btnGotIt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0)
			{
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					run();
			}
		});
		btnGotIt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				run();
			}
		});
		btnGotIt.setBounds(191, 388, 89, 23);
		frame.getContentPane().add(btnGotIt);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 63, 503, 376);
		frame.getContentPane().add(separator);
	}
	
	private void run()
	{
		try
		{
			acnhFileIO.checkRead();
		} catch(IOException e)
		{
			System.out.println("ERROR: Couldn't validate file validity (in acnhGUI_Welcome.java)");
		}
		
		//Go to next frame
		if(acnhFileIO.isImport)
		{
			int dialogResult = JOptionPane.showConfirmDialog(frame, IMPORT_FOUND, "Import Found" , JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)
			{
				try
				{
					acnhFileIO.read();
				} catch(IOException e)
				{
					System.out.println("ERROR: Couldn't read lastWeeksVisitors.dat (in acnhGUI_Welcome.java)");
				}
				
				frame.setVisible(false);
				acnhGUI_App.main(null);
			}
			else
			{
				frame.setVisible(false);
				acnhGUI_lastWeeksVisitors.main(null);
			}
		}
		else
		{
			frame.setVisible(false);
			acnhGUI_lastWeeksVisitors.main(null);
		}				
	}
}
