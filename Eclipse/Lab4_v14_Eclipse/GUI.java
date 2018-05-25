

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;


import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


class MainStream extends Thread
{
	private Display display;
	  
	MainStream(Display display)
	{
		this.display = display;
	}	
	
	
	public void run()	
	{
		
		while(true) {
			try{
				Thread.sleep(100);	
				
			}catch(InterruptedException e){}
				
			for(User user: GUI.users) {
				if(user.shell.isDisposed())
					user.thread.stop();
			}
			
			if(!this.isAlive()) {
				break;
			}
		}
	}	
}

public class GUI {
	
	public static ArrayList<User> users = new ArrayList<User>();
	public static int UsersNumber = 3;
	public static boolean checkBot = true;

	static Shell ConfigureShell(Display display) {
		
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("Chat Bot");
		shell.setSize(360, 250);
		
		shell.setLayout(new GridLayout(2, true));
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		

		Label labelWelcome = new Label(shell, SWT.CENTER);
		labelWelcome.setText("Welcome to chat bot wizard!");
		new Label(shell, SWT.None);
		//labelWelcome.setLayoutData(gridData);

		
		new Label(shell, SWT.LEFT).setText("Enter number of Users");
		final Text enterUsersNum = new Text(shell, SWT.BORDER);	
		enterUsersNum.setLayoutData(gridData);

		new Label(shell, SWT.NONE);
		new Label(shell, SWT.NONE);
		
	
		Button goButton = new Button(shell, SWT.PUSH);	
		goButton.setText("Let's GO!");
		goButton.setLayoutData(gridData);
		new Label(shell, SWT.NONE);
		
		
		
		goButton.addListener(SWT.Selection, new Listener(){  
			
			boolean checkFirst = true; 
			
			
			public void handleEvent(Event event) { 
				
				UsersNumber = Integer.valueOf(enterUsersNum.getText());
				
				if (checkBot) { // если не произошла ошибка ввода
			
					if(checkFirst) {
						MainStream stream = new MainStream(display);
						stream.setDaemon(true);
						stream.start();
						checkFirst = false;
					}
					
					ChatBot bot = new ChatBot(display);
					bot.ConfigShell();
					checkBot = false;
					
					for(int i=0; i<UsersNumber; i++)
					{
						users.add(new User(display, bot));
						
					}
					
					for(User user: users)
						user.ConfigShell().open();
					
				}		
				
				/*resultLabel.setText("Листов напечатано: \n" + "A4:    " + numA4 + "    A3:    " + numA3 + "    A2:    " + numA2);
				resultLabel.getParent().layout();*/
							
			}	
			
		});
		
		
		return shell;	
	}	
	
		public static void main(String[] args) {
			Display display = new Display();
			Shell shell = ConfigureShell(display);
		
			shell.open();
					
			while (!shell.isDisposed()) {
			
				if (!display.readAndDispatch())
					display.sleep();
				
			}
		}
}

