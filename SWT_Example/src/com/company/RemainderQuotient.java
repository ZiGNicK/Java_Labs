package com.company;
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

import java.awt.*;

public class RemainderQuotient {
    public static Shell ConfigureShell(Display display) {
        Shell shell = new Shell(display, SWT.SHELL_TRIM & (~SWT.RESIZE));
        shell.setText("Find out remainder and quotient");
        shell.setSize(330, 120);

        shell.setLayout(new GridLayout(3, true));
        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        new Label(shell, SWT.LEFT).setText("Делимое");
        Text dividendTextField = new Text(shell, SWT.BORDER);
        dividendTextField.setLayoutData(gridData);
        new Label(shell, SWT.NONE);
        new Label(shell, SWT.LEFT).setText("Делитель");
        Text dividerTextField = new Text(shell, SWT.BORDER);
        dividerTextField.setLayoutData(gridData);
        Button calculateButton = new Button(shell, SWT.PUSH);
        calculateButton.setText("Поделить");
        calculateButton.setLayoutData(gridData);
        Label quotientLabel = new Label(shell, SWT.LEFT);
        quotientLabel.setText("Частное: ");
        Label remainderLabel = new Label(shell, SWT.LEFT);
        remainderLabel.setText("Остаток: ");

        calculateButton.addListener(SWT.Selection, new Listener()
        {
            public void handleEvent(Event event)
            {
                Integer dividend = Integer.parseInt(dividendTextField.getText());
                Integer divider = Integer.parseInt(dividerTextField.getText());
                quotientLabel.setText("Частное: " + dividend / divider);
                quotientLabel.getParent().layout();
                remainderLabel.setText("Остаток: " + dividend % divider);
                remainderLabel.getParent().layout();
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