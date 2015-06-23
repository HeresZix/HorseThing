package com.zix.horsething;

import java.awt.Color;

import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class Console {

	private JTextPane console;
	private StyledDocument sd;

	public Console(JTextPane textPane) {
		this.console = textPane;
		this.sd = console.getStyledDocument();
	}

	public void characterType(String name, String msg, boolean nl) {
		Style style = sd.addStyle( "bold", null ); 
		StyleConstants.setBold(style, true);
	    
		printLine(name + "> ", false, style);
		typeLine(msg, nl, 50);
	}

	public void printLine(String msg, boolean nl) {
		StyledDocument document = console.getStyledDocument();
		try {
			if (nl) {
				document.insertString(document.getEndPosition().getOffset(),
						msg + "\n", null);
			} else {
				document.insertString(document.getEndPosition().getOffset(),
						msg, null);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public void printLine(String msg, boolean nl, Style style) {
		try {
			if (nl) {
				sd.insertString(sd.getEndPosition().getOffset(), msg + "\n", style);
			} else {
				sd.insertString(sd.getEndPosition().getOffset(), msg, style);
			}
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	public void typeLine(String msg, boolean nl, long millis) {
		if (nl) {
			for (int i = 0; i < msg.length(); i++) {
				try {
					sd.insertString(sd.getEndPosition().getOffset(),
							msg.charAt(i) + "", null);

					Thread.sleep(millis);
				} catch (BadLocationException | InterruptedException e) {
					e.printStackTrace();
				}
			}
			try {
				sd.insertString(sd.getEndPosition().getOffset(), "\n", null);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
		} else {
			for (int i = 0; i < msg.length(); i++) {
				try {
					sd.insertString(sd.getEndPosition().getOffset(),
							msg.charAt(i) + "", null);

					Thread.sleep(50);
				} catch (BadLocationException | InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
