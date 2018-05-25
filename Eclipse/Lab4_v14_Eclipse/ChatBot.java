import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;



public class ChatBot {
	
	public BotThread thread;
	
	class BotThread extends Thread{
		
		private String userMessage;
		
		public void setUserMessage(String userMessage) {
			this.userMessage = userMessage;
		}
		
		BotThread(){}
		
		public void run() {
			while(true) {
				
				try{
					Thread.sleep(1000);		//Приостанавливает поток на 1 секунду
					
				}catch(InterruptedException e){}
				
				if(!this.isAlive()) {
					break;
				}
				
				if(userMessage != null) {
					Answer();
					userMessage = null;
				}
			}
		}
		
		public void Answer () {
			switch(userMessage) {
				case "Hello": System.out.println("Hello, MAN"); break;
				case "Whats up?": System.out.println("Never mind)))"); break;
				default: {
					System.out.println("Error! Try again!"); break;
				}
			}
		}
	}
	
	private Display display;
	
	public ChatBot(Display display) {
		this.display = display;
	}
	
	public Shell ConfigShell ()
	{

	
		Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
		
		shell.setText("Chat Bot");
		shell.setSize(360, 250);
		
		shell.setLayout(new GridLayout(1, true));
		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		Label labelText = new Label(shell, SWT.CENTER);
		labelText.setText("Hello, I'm a Chat bot!");
		
		thread = new BotThread();
		thread.setDaemon(true);
		thread.start();
		
		shell.open();
		
		
		
		return shell;
	}

}
