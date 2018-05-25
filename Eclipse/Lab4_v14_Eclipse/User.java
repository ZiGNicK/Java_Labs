import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;


public class User {
	
	class UserThread extends Thread{
		
		private ChatBot bot;
		private String userMessage = null;
		
		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}
		
		UserThread(ChatBot bot){
			this.bot = bot;
		}
		
		public void run() {
			while(true) {
				
				try{
					Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
					
				}catch(InterruptedException e){}
				
				if(userMessage!=null) {
					bot.thread.setUserMessage(userMessage);
					bot.thread.Answer();
				}
				if(!this.isAlive()) {
					break;
				}
				
			}
		}
	}
	
	public UserThread thread;
	public Shell shell;
	private Display display;
	private ChatBot bot;
	
	public User (Display display,ChatBot bot) {
		this.display = display;
		this.bot = bot;
	}
	
	public Shell ConfigShell ()
	{
		shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("Chat Bot");
		shell.setSize(360, 250);
		
		shell.setLayout(new GridLayout(1, true));
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		Label labelText = new Label(shell, SWT.CENTER);
		labelText.setText("Enter Here watewa u want!");
		
		final Text enterMessage = new Text(shell, SWT.BORDER);	
		enterMessage.setLayoutData(gridData);
		
		Button sendButton = new Button(shell, SWT.PUSH);	
		sendButton.setText("Send!");
		sendButton.setLayoutData(gridData);
		
		thread = new UserThread(bot);
		
		sendButton.addListener(SWT.Selection, new Listener(){  
			
			public void handleEvent(Event event) { 
				
				thread.setUserMessage(enterMessage.getText());
							
			}	
			
		});
		
		thread.setDaemon(true);
		thread.start();
		
		return shell;
	}

}
